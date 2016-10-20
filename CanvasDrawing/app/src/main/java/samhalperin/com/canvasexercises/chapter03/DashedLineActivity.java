package samhalperin.com.canvasexercises.chapter03;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import samhalperin.com.canvasexercises.R;

/**
 * Karpenko, Yevgen (2013-06-23). Android 2D Graphics with Canvas API. Kindle Edition.
 */

public class DashedLineActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);
        FrameLayout container = (FrameLayout)findViewById(R.id.main_container);
        container.addView(new DashedLineView(this));

    }
}
