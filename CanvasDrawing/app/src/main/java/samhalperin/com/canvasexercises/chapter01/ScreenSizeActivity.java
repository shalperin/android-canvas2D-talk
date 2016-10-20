package samhalperin.com.canvasexercises.chapter01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import samhalperin.com.canvasexercises.R;

/**
 * Karpenko, Yevgen (2013-06-23). Android 2D Graphics with Canvas API. Kindle Edition.
 */

public class ScreenSizeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);
        FrameLayout container = (FrameLayout)findViewById(R.id.main_container);
        container.addView(new ScreenSizeView(this));

    }
}
