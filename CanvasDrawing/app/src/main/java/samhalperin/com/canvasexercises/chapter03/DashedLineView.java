package samhalperin.com.canvasexercises.chapter03;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

/**
 * Karpenko, Yevgen (2013-06-23). Android 2D Graphics with Canvas API. Kindle Edition.
 */

public class DashedLineView extends View {

    private static final String TAG = DashedLineView.class.getSimpleName();
    private Paint paint;
    private Path  path;
    private static int BACKGROUND_COLOR = Color.WHITE;
    private static int DRAW_COLOR       = Color.BLACK;
    private static int STROKE_WIDTH     = 30;


    public DashedLineView(Context context) {
        super(context);
        setBackgroundColor(BACKGROUND_COLOR);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(DRAW_COLOR);
        paint.setStrokeWidth(STROKE_WIDTH);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawPath(path, paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        path = new Path();
        path.moveTo(50, 300);
        path.lineTo(w - 50, 300);

        DashPathEffect effect = new DashPathEffect(new float[]{90, 30}, 0);
// dotted line
//        paint.setStrokeCap(Paint.Cap.ROUND);
//        DashPathEffect effect = new DashPathEffect(new float[]{1, 60}, 0);

        paint.setPathEffect(effect);
    }
}
