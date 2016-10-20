package samhalperin.com.canvasexercises.chapter03;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

/**
 * Karpenko, Yevgen (2013-06-23). Android 2D Graphics with Canvas API. Kindle Edition.
 */

public class TriangleFillView extends View {

    private static final String TAG = TriangleFillView.class.getSimpleName();
    private Paint paint;
    private Path  path;
    private static int         BACKGROUND_COLOR    = Color.WHITE;
    private static int         DRAW_COLOR          = Color.BLACK;
    private static int         FILL_COLOR          = Color.RED;
    private static Paint.Align TEXT_ALIGN          = Paint.Align.CENTER;
    private static float       STROKE_SCALE_FACTOR = .1f;
    private static float       PATH_START          = .2f;
    public static  float       PATH_MID            = .5f;
    private static float       PATH_END            = .8f;
    private static Paint.Style PAINT_STYLE         = Paint.Style.STROKE;
    private static Paint.Cap   CAP_STYLE           = Paint.Cap.ROUND;
    private static Paint.Join  STROKE_JOIN         = Paint.Join.ROUND;


    public TriangleFillView(Context context) {
        super(context);
        setBackgroundColor(BACKGROUND_COLOR);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(DRAW_COLOR);
        paint.setStyle(PAINT_STYLE);
        paint.setStrokeJoin(STROKE_JOIN);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        paint.setStrokeWidth(Math.min(w, h) * STROKE_SCALE_FACTOR);
        path = new Path();
        ;
        path.moveTo(w * PATH_MID, h * PATH_START);
        path.lineTo(w * PATH_END, h * PATH_END);
        path.lineTo(w * PATH_START, h * PATH_END);
        path.close();
    }

    @Override
    public void onDraw(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(FILL_COLOR);
        canvas.drawPath(path, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(DRAW_COLOR);
        canvas.drawPath(path, paint);
    }
}
