package samhalperin.com.canvasexercises.chapter10b;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Karpenko, Yevgen (2013-06-23). Android 2D Graphics with Canvas API. Kindle Edition.
 */
public class ProgressActivity extends AppCompatActivity {

    private ProgressView view;
    private ProgressThread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = new ProgressView(this);
        this.setContentView(view);

    }

    @Override
    protected void onStart() {
        super.onStart();
        thread = new ProgressThread(view);
        thread.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
