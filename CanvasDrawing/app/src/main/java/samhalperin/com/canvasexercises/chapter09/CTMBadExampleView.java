package samhalperin.com.canvasexercises.chapter09;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

import samhalperin.com.canvasexercises.chapter08.ChartModel;

/**
 * Karpenko, Yevgen (2013-06-23). Android 2D Graphics with Canvas API. Kindle Edition.
 */

public class CTMBadExampleView extends View {

    private int minX = 0;
    private int maxX = 19;
    private int minY = 1510;
    private int maxY = 1580;

    private Paint paint;
    private RectF rect;

    private int deviceHeight;
    private int deviceWidth;

    public CTMBadExampleView(Context context) {
        super(context);
        setBackgroundColor(Color.WHITE);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(5);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);

        rect = new RectF(5, 1520, 14, 1570);

    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.translate(0, deviceHeight);

        float scaleX = (float)deviceWidth / (maxX - minX);
        float scaleY = (float)deviceHeight/ (maxY - minY);
        canvas.scale(scaleX, -scaleY);

        canvas.translate(0, -minY);

        canvas.drawRect(rect, paint);


    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.deviceWidth = w;
        this.deviceHeight = h;
    }
}

