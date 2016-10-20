package samhalperin.com.canvasexercises.chapter09;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

import samhalperin.com.canvasexercises.chapter08.Transform;

/**
 * Karpenko, Yevgen (2013-06-23). Android 2D Graphics with Canvas API. Kindle Edition.
 */

public class TriangleViewMatrix extends View {

    private Matrix matrix;
    private Path   path;
    private Paint  paint;

    public TriangleViewMatrix(Context context) {
        super(context);
        setBackgroundColor(Color.WHITE);


        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(25);

        matrix = new Matrix();
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawPath(path, paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        matrix.reset();

        if (w > h) { //landscape
            matrix.postScale(h, -h);
            matrix.postTranslate(0, h);
        } else { // portrait
            matrix.postScale(w, -w);
            matrix.postTranslate(0, h);
        }


        path = new Path();
        path.moveTo(.2f, .2f);
        path.lineTo(.8f, .8f);
        path.lineTo(.8f, .2f);
        path.close();

        path.transform(matrix);

    }
}

