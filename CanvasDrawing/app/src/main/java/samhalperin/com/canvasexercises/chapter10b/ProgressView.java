package samhalperin.com.canvasexercises.chapter10b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Karpenko, Yevgen (2013-06-23). Android 2D Graphics with Canvas API. Kindle Edition.
 */
public class ProgressView extends SurfaceView {
    private ProgressHelper progress;

    public ProgressView(Context context) {
        super(context);
        progress = new ProgressHelper(context);
    }

    @Override
    protected void onSizeChanged(int width, int height, int oldw, int oldh) {
        progress.changeSize(width, height);
    }

    public void drawProgress(int value) {
        SurfaceHolder holder = this.getHolder();
        Canvas canvas = null;
        try {
            canvas = holder.lockCanvas();
            if (canvas != null) {
               canvas.drawColor(Color.WHITE);
                progress.draw(canvas, value/100.0f);
            }
        } finally {
            if (canvas != null)
            {
                holder.unlockCanvasAndPost(canvas);
            }
        }
    }
}
