package samhalperin.com.canvasexercises.chapter10a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import samhalperin.com.canvasexercises.chapter08.ChartModel;

/**
 * Karpenko, Yevgen (2013-06-23). Android 2D Graphics with Canvas API. Kindle Edition.
 */

public class ChartViewMT extends View {

    private Matrix matrix;
    private ChartModel model;
    private Path       path;
    private Paint      paint;
    private Paint   textPaint;
    private int deviceWidth, deviceHeight;
    private boolean loading = false;


    public ChartViewMT(Context context) {
        super(context);
        init();
    }

    public ChartViewMT(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    private void init()
    {
        setBackgroundColor(Color.WHITE);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(5);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);

        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setTextAlign(Paint.Align.CENTER);
        matrix = new Matrix();

    }
    @Override
    public void onDraw(Canvas canvas) {

        if (model == null) {
            if (loading)
                canvas.drawText("Loading...", deviceWidth/2, deviceHeight/2, textPaint);
        } else {
            canvas.drawPath(path, paint);
        }

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {

        deviceHeight = h;
        deviceWidth = w;
        textPaint.setTextSize(h * .1f);
    }

    public void setLoading(boolean b) {
        loading = b;
        this.model = null;
        invalidate();
    }

    public void setModel(ChartModel m) {
        model = m;
        loading = false;
        updatePath();
        invalidate();
    }

    private void updatePath() {

        matrix.reset();

        matrix.postTranslate(0, -model.getMinPrice());

        float scaleX = (float) deviceWidth / (model.getMaxDay() - model.getMinDay());
        float scaleY = (float) deviceHeight / (model.getMaxPrice() - model.getMinPrice());

        matrix.postScale(scaleX, -scaleY);
        matrix.postTranslate(0, deviceHeight);

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

