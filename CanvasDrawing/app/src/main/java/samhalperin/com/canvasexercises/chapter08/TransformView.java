package samhalperin.com.canvasexercises.chapter08;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.SweepGradient;
import android.view.View;

/**
 * Karpenko, Yevgen (2013-06-23). Android 2D Graphics with Canvas API. Kindle Edition.
 */

public class TransformView extends View {

    private Transform transform;
    private Path      path;
    private Paint     paint;

    public TransformView(Context context) {
        super(context);
        setBackgroundColor(Color.WHITE);

        transform = new Transform();
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(25);
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawPath(path, paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (w > h) { //landscape
            transform.setScale(h, -h);
            transform.setMoveAfterScale(0, h); //updated from next exercise
        } else { // portrait
            transform.setScale(w, -w);
            transform.setMoveAfterScale(0, h);
        }

        float Ax = transform.transformX(0.2f);
        float Ay = transform.transformY(0.2f);

        float Bx = transform.transformX(0.8f);
        float By = transform.transformY(0.8f);

        float Cx = transform.transformX(0.8f);
        float Cy = transform.transformY(0.2f);

        path = new Path();
        path.moveTo(Ax, Ay);
        path.lineTo(Bx, By);
        path.lineTo(Cx, Cy);
        path.close();

    }
}

