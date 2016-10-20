package samhalperin.com.canvasexercises.chapter06;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Karpenko, Yevgen (2013-06-23). Android 2D Graphics with Canvas API. Kindle Edition.
 */

public class CircleView extends View {

    private int   centerX;
    private int   centerY;
    private float radius;

    private Paint paint;

    public CircleView(Context context) {
        super(context);
        setBackgroundColor(Color.WHITE);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(0xff000099);
    }

    @Override
    public void onDraw(Canvas canvas) {
        paint.setStrokeWidth(radius * 0.3f);
        canvas.drawCircle(centerX, centerY, radius, paint);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        centerX = w/2;
        centerY = h/2;
        radius = Math.min(w,h) * .35f;
    }
}

