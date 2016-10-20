package samhalperin.com.canvasexercises.chapter09;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

import samhalperin.com.canvasexercises.chapter08.ChartModel;
import samhalperin.com.canvasexercises.chapter08.Transform;

/**
 * Karpenko, Yevgen (2013-06-23). Android 2D Graphics with Canvas API. Kindle Edition.
 */

public class MatrixChartView extends View {

    private Matrix matrix;
    private ChartModel model;
    private Path       path;
    private Paint      paint;

    public MatrixChartView(Context context) {
        super(context);
        setBackgroundColor(Color.WHITE);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(5);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);

        matrix = new Matrix();
        model = new ChartModel();

    }

    @Override
    public void onDraw(Canvas canvas) {

        canvas.drawPath(path, paint);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {

        matrix.reset();

        matrix.postTranslate(0, -model.getMinPrice());

        float scaleX = (float) w / (model.getMaxDay() - model.getMinDay());
        float scaleY = (float) h / (model.getMaxPrice() - model.getMinPrice());

        matrix.postScale(scaleX, -scaleY);
        matrix.postTranslate(0, h);

        // Create path
        path = new Path();
        path.moveTo(0, model.getPrice(0));


        // this is all about mapping a logical coordinate system
        // to the screen.
        for (int i = 1; i< model.getNumberOfDays(); i++) {
            path.lineTo(i, model.getPrice(i));
        }

        path.transform(matrix);
    }
}

