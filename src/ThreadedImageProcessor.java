import java.awt.image.BufferedImage;

public class ThreadedImageProcessor implements Runnable {
    private BufferedImage section;
    private int threadId;

    public ThreadedImageProcessor(BufferedImage section, int threadId) {
        this.section = section;
        this.threadId = threadId;
    }

    @Override
    public void run() {
        // TODO: Apply filter to this section
        System.out.println("Thread " + threadId + " processing section.");
    }
}
