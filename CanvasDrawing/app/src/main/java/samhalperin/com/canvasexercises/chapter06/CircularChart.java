package samhalperin.com.canvasexercises.chapter06;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.View;

/**
 * Karpenko, Yevgen (2013-06-23). Android 2D Graphics with Canvas API. Kindle Edition.
 */

public class CircularChart extends View {

    private int progress = 65;
    private String label;
    private int   centerX;
    private int   centerY;
    private float radius;
    private RectF rect;
    private float textX;
    private float textY;

    private Paint arcPaint;
    private Paint textPaint;

    public CircularChart(Context context) {
        super(context);
        setBackgroundColor(Color.WHITE);
        arcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        arcPaint.setStyle(Paint.Style.STROKE);
        arcPaint.setStrokeCap(Paint.Cap.ROUND);


        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.BLUE);
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);

        label = progress+ "%";
        rect = new RectF();
    }

    @Override
    public void onDraw(Canvas canvas) {
        arcPaint.setStrokeWidth(.1f * radius);
        arcPaint.setColor(Color.LTGRAY);
        canvas.drawOval(rect, arcPaint);

        arcPaint.setColor(Color.BLUE);
        arcPaint.setStrokeWidth(.3f * radius);
        canvas.drawArc(rect, 270, ((progress / 100f) * 360), false, arcPaint);

        String theText = progress + "%";
        canvas.drawText(theText, textX, textY, textPaint);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        centerX = w/2;
        centerY = h/2;
        radius = Math.min(w,h) * .35f;

        arcPaint.setStrokeWidth(radius * 0.3f);

        rect.left = centerX - radius;
        rect.right = centerX + radius;
        rect.top = centerY - radius;
        rect.bottom = centerY + radius;

        textPaint.setTextSize(.6f * radius);

        Rect textBounds = new Rect();
        textPaint.getTextBounds(label, 0, label.length(), textBounds);
        textX = centerX - (textBounds.left + textBounds.right) * .5f;
        textY = centerY - (textBounds.top + textBounds.bottom) * .5f;
    }
}

