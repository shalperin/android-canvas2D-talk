package samhalperin.com.canvasexercises.chapter10b;

/**
 * Karpenko, Yevgen (2013-06-23). Android 2D Graphics with Canvas API. Kindle Edition.
 */
public class ProgressThread extends Thread {
    private volatile boolean stopRequested = false;
    private ProgressView view;
    private int progress;

    public ProgressThread(ProgressView view) {
        this.view = view;
    }

    public void run() {
        while (!stopRequested && progress <= 100) {
            view.drawProgress(progress);

            try {
                Thread.sleep(500);
            } catch (Exception ex) {
                break;
            }
            progress += 10;
        }
    }
}
