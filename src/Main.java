import java.awt.image.BufferedImage;

public class Main {
    public static void main(String[] args) {
        System.out.println("Java Parallel Image Processor started.");

        BufferedImage img = Utils.loadImage("images/sample.png"); 

        if (img != null) {
            System.out.println("Image loaded successfully!");

            Utils.saveImage(img, "images/output.png");
            System.out.println("Image saved successfully!");
        } else {
            System.out.println("Image loading failed.");
        }
    }
}
