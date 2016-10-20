package samhalperin.com.canvasexercises.chapter09;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/**
 * Karpenko, Yevgen (2013-06-23). Android 2D Graphics with Canvas API. Kindle Edition.
 */

public class CTMFixedExampleView extends View {

    private int minX = 0;
    private int maxX = 19;
    private int minY = 1510;
    private int maxY = 1580;

    private Paint paint;
    private RectF rect;

    Matrix matrix;

    public CTMFixedExampleView(Context context) {
        super(context);
        setBackgroundColor(Color.WHITE);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(5);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);

        matrix = new Matrix();

    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawRect(rect, paint);

    }

    @Override
    protected void onSizeChanged(int deviceWidth, int deviceHeight, int oldw, int oldh) {
        matrix.reset();

        matrix.postTranslate(0, -minY);

        float scaleX = (float) deviceWidth / (maxX - minX);
        float scaleY = (float) deviceHeight / (maxY - minY);
        matrix.postScale( scaleX, -scaleY);

        matrix.postTranslate(0, deviceHeight);

        rect = new RectF(5, 1520, 14, 1570);
        matrix.mapRect(rect);

        paint.setStrokeWidth(deviceHeight * 0.05f);


    }
}

