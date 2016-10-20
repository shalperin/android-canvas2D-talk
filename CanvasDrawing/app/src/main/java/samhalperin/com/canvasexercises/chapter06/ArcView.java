package samhalperin.com.canvasexercises.chapter06;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/**
 * Karpenko, Yevgen (2013-06-23). Android 2D Graphics with Canvas API. Kindle Edition.
 */

public class ArcView extends View {

    private int   centerX;
    private int   centerY;
    private float radius;
    private RectF rect;

    private Paint paint;

    public ArcView(Context context) {
        super(context);
        setBackgroundColor(Color.WHITE);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rect = new RectF();
    }

    @Override
    public void onDraw(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.LTGRAY);
        canvas.drawOval(rect, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setColor(Color.BLUE);
        canvas.drawArc(rect, 0, 90, false, paint);

        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.GREEN);
        canvas.drawArc(rect, 180, 90, true, paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        centerX = w/2;
        centerY = h/2;
        radius = Math.min(w,h) * .35f;

        paint.setStrokeWidth(radius * 0.3f);

        rect.left = centerX - radius;
        rect.right = centerX + radius;
        rect.top = centerY - radius;
        rect.bottom = centerY + radius;
    }
}

