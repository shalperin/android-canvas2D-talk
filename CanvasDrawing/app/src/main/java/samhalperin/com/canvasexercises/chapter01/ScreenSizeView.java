package samhalperin.com.canvasexercises.chapter01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

/**
 * Karpenko, Yevgen (2013-06-23). Android 2D Graphics with Canvas API. Kindle Edition.
 */

public class ScreenSizeView extends View {

    private static final String TAG = ScreenSizeView.class.getSimpleName();
    private int width;
    private int height;
    private Paint paint;
    private static int BACKGROUND_COLOR = Color.WHITE;
    private static int DRAW_COLOR = Color.BLACK;
    private static Paint.Align TEXT_ALIGN = Paint.Align.CENTER;
    private static float TEXT_SCALE_FACTOR = .12f;

    public ScreenSizeView(Context context) {
        super(context);
        setBackgroundColor(BACKGROUND_COLOR);
        paint = new Paint();
        paint.setColor(DRAW_COLOR);
        paint.setTextAlign(TEXT_ALIGN);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        Log.d(TAG, "onSizeChanged called " + w + "," + h);
        width = w;
        height = h;
    }

    @Override
    public void onDraw(Canvas canvas) {
        float textSize = Math.min(width, height) * TEXT_SCALE_FACTOR;
        paint.setTextSize(textSize);
        float x = width * .5f;
        float y = height * .5f;
        String str = "w=" + width + ", h=" + height;
        Log.d(TAG, "textpos: " + x + "," + y);
        canvas.drawText(str, x, y, paint);
    }
}
