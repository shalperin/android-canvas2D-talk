package samhalperin.com.canvasexercises.chapter10b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;

/**
 * Karpenko, Yevgen (2013-06-23). Android 2D Graphics with Canvas API. Kindle Edition.
 */
public class ProgressHelper {

    private float centerX;
    private float centerY;
    private float radius;
    private float textY;

    private RectF arcOval;
    private Rect  textBounds;

    private Paint paint;
    private Paint txtPaint;

    private int color1 = Color.LTGRAY;
    private int color2 = 0xff333477;

    public ProgressHelper(Context context) {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);

        txtPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        txtPaint.setColor(color2);
        txtPaint.setTypeface(Typeface.DEFAULT_BOLD);
        txtPaint.setTextAlign(Paint.Align.CENTER);

        arcOval = new RectF();
        textBounds = new Rect();
    }

    public void draw(Canvas canvas, float value) {
        paint.setStrokeWidth(radius * .05f);
        paint.setColor(color1);
        canvas.drawCircle(centerX, centerY, radius, paint);

        paint.setColor(color2);
        paint.setStrokeWidth(radius * .4f);
        canvas.drawArc(arcOval, -90, value * 360, false, paint);

        String label = String.format("%.0f%%", value * 100);
        canvas.drawText(label, centerX, textY, txtPaint);
    }

    public void changeSize(int w, int h) {
        centerX = w / 2.0f;
        centerY = h / 2.0f;

        radius = Math.min(w, h) * .7f / 2;
        txtPaint.setTextSize(radius * .6f);

        String label = "100";
        txtPaint.getTextBounds(label, 0, label.length(), textBounds);
        textY = centerY - (textBounds.top + textBounds.bottom) * .5f;

        arcOval.left = centerX - radius;
        arcOval.right = centerX + radius;
        arcOval.top = centerY - radius;
        arcOval.bottom = centerY + radius;
    }



}



