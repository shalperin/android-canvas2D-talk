package samhalperin.com.canvasexercises.chapter03;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

/**
 * Karpenko, Yevgen (2013-06-23). Android 2D Graphics with Canvas API. Kindle Edition.
 */
public class LineView extends View {

    private static final String TAG = LineView.class.getSimpleName();
    private int width;
    private int height;
    private Paint paint;
    private static int BACKGROUND_COLOR = Color.WHITE;
    private static int DRAW_COLOR = Color.BLACK;
    private static float STROKE_SCALE_FACTOR = .1f;
    private static float LINE_START = .2f;
    private static float LINE_END = .8f;

    public LineView(Context context) {
        super(context);
        setBackgroundColor(BACKGROUND_COLOR);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(DRAW_COLOR);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        Log.d(TAG, "onSizeChanged called " + w + "," + h);
        width = w;
        height = h;
        paint.setStrokeWidth(Math.min(w, h) * STROKE_SCALE_FACTOR);
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawLine(width * LINE_START, height * LINE_START, width * LINE_END, height * LINE_END, paint);
    }
}
