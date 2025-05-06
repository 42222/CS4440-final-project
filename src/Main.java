import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.GridLayout;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //prompt from user to select from drop-down list of given images for the sake of simplicity
        String[] choices = {
            "dog.png",
            "cat.png",
            "bird.png",
            "rat.png"
            
        };
        String picked = (String) JOptionPane.showInputDialog(
            null,
            "Please select from a list of images:",
            "Images of various animals",
            JOptionPane.PLAIN_MESSAGE,
            null,
            choices,
            choices[0]
        );
        if (picked == null) {
            System.out.println("There was no image selected. Will now exit");
            return;
        }

        // 2) Load the file selected by user input
        BufferedImage original = Utils.loadImage("images/" + picked);
        if (original == null) {
            System.err.println("Failed to load images/" + picked);
            return;
        }
        System.out.println("Loaded images/" + picked);

        // 3) Parallel processing
        BufferedImage result = parallelGreyscale(original);

        // 4) Save output
        Utils.saveImage(result, "images/output.png");
        System.out.println("Processed image saved to images/output.png.");

        // 5) popup with both the original image and altered image side by side
        SwingUtilities.invokeLater(() -> {
            int numThreads = Runtime.getRuntime().availableProcessors();
            JFrame frame = new JFrame("Original on the left, Greyscale on the right");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new GridLayout(1, 2, 10, 10));
            frame.add(new ImageWithGrid(original, numThreads));
            frame.add(new ImageWithGrid(result,   numThreads));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    private static BufferedImage parallelGreyscale(BufferedImage img)
            throws InterruptedException {

        int numThreads = Runtime.getRuntime().availableProcessors();
        int w          = img.getWidth();
        int h          = img.getHeight();
        int stripW     = w / numThreads;

        BufferedImage[] strips = new BufferedImage[numThreads];
        Thread[] threads       = new Thread[numThreads];

        // Split the image into vertical strips
        for (int i = 0; i < numThreads; i++) {
            int x     = i * stripW;
            int thisW = (i == numThreads - 1) ? w - x : stripW;
            BufferedImage sub = new BufferedImage(thisW, h, img.getType());
            Graphics g = sub.getGraphics();
            g.drawImage(img.getSubimage(x, 0, thisW, h), 0, 0, null);
            g.dispose();
            strips[i] = sub;
        }

        // Launch threads to greyscale each strip and count the time taken
        for (int i = 0; i < numThreads; i++) {
            final int id = i;
            threads[i] = new Thread(() -> {
                long startNs = System.nanoTime();

                BufferedImage sec = strips[id];
                int sw = sec.getWidth(), sh = sec.getHeight();
                for (int xx = 0; xx < sw; xx++) {
                    for (int yy = 0; yy < sh; yy++) {
                        int rgb = sec.getRGB(xx, yy);
                        int a   = (rgb >> 24) & 0xff;
                        int r   = (rgb >> 16) & 0xff;
                        int g2  = (rgb >> 8 ) & 0xff;
                        int b   =  rgb        & 0xff;
                        int gray = (int)(0.299*r + 0.587*g2 + 0.114*b);
                        int p    = (a<<24) | (gray<<16) | (gray<<8) | gray;
                        sec.setRGB(xx, yy, p);
                    }
                }

                long durationNs  = System.nanoTime() - startNs;
                double durationMs = durationNs / 1_000_000.0;
                System.out.printf("Thread %d finished in %.2f ms.%n", id, durationMs);
            });
            threads[i].start();
        }

        // Wait for every thread to complete
        for (Thread t : threads) {
            t.join();
        }

        //combine the strips to one image
        BufferedImage out = new BufferedImage(w, h, img.getType());
        Graphics g = out.getGraphics();
        for (int i = 0; i < numThreads; i++) {
            g.drawImage(strips[i], i * stripW, 0, null);
        }
        g.dispose();

        return out;
    }
}
