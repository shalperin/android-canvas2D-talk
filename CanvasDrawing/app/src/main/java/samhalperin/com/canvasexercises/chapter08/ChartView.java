package samhalperin.com.canvasexercises.chapter08;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

/**
 * Karpenko, Yevgen (2013-06-23). Android 2D Graphics with Canvas API. Kindle Edition.
 */

public class ChartView extends View {

    private Transform transform;
    private ChartModel model;
    private Path      path;
    private Paint     paint;

    public ChartView(Context context) {
        super(context);
        setBackgroundColor(Color.WHITE);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(5);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);

        transform = new Transform();
        model = new ChartModel();

    }

    @Override
    public void onDraw(Canvas canvas) {

        canvas.drawPath(path, paint);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {

        //init transform
        transform.setMoveBeforeScale(0, -model.getMinPrice());

        float scaleX = (float) w / (model.getMaxDay() - model.getMinDay());
        float scaleY = (float) h / (model.getMaxPrice() - model.getMinPrice());
        transform.setScale(scaleX, -scaleY);

        transform.setMoveAfterScale(0, h);

        // Create path
        path = new Path();

        float x = transform.transformX(0);
        float y = transform.transformY(model.getPrice(0));
        path.moveTo(x, y);

        for (int i = 1; i< model.getNumberOfDays(); i++) {
            x = transform.transformX(i);
            y = transform.transformY(model.getPrice(i));
            path.lineTo(x, y);
        }
    }
}

