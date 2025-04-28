import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Utils {
    public static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (Exception e) {
            System.out.println("Failed to load image: " + e.getMessage());
            return null;
        }
    }

    public static void saveImage(BufferedImage image, String path) {
        try {
            ImageIO.write(image, "png", new File(path));
        } catch (Exception e) {
            System.out.println("Failed to save image: " + e.getMessage());
        }
    }
}
