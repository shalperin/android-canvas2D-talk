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

public class OvalView extends View {

    private Paint paint;
    private float padding;
    private RectF rect;

    public OvalView(Context context) {
        super(context);
        setBackgroundColor(Color.WHITE);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rect = new RectF();
    }

    @Override
    public void onDraw(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(padding);
        paint.setColor(Color.RED);
        canvas.drawOval(rect, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(padding/12);
        paint.setColor(Color.BLUE);
        canvas.drawRect(rect, paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        padding = Math.max(w, h) * .1f;
        rect.left = padding;
        rect.right = w-padding;
        rect.top = padding;
        rect.bottom = h-padding;
    }
}

