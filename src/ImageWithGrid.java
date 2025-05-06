import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class ImageWithGrid extends JPanel {
    private final BufferedImage img;
    private final int numStrips;

    public ImageWithGrid(BufferedImage img, int numStrips) {
        this.img = img;
        this.numStrips = numStrips;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the image
        g.drawImage(img, 0, 0, this);

        // Overlay lines corresponding to thread strips
        int stripW = img.getWidth() / numStrips;
        Graphics2D g2 = (Graphics2D) g.create();
        float[] dash = {5f, 5f};
        g2.setColor(new Color(255, 0, 0, 128));  
        g2.setStroke(new BasicStroke(
            2, 
            BasicStroke.CAP_ROUND, 
            BasicStroke.JOIN_ROUND, 
            1f, dash, 0f
        ));
        for (int i = 1; i < numStrips; i++) {
            int x = i * stripW;
            g2.drawLine(x, 0, x, img.getHeight());
        }
        g2.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(img.getWidth(), img.getHeight());
    }
}
