package samhalperin.com.canvasexercises.chapter04;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;

/**
 * Karpenko, Yevgen (2013-06-23). Android 2D Graphics with Canvas API. Kindle Edition.
 */

public class TextVerticalAlignView extends View {

    private static final String TAG = TextVerticalAlignView.class.getSimpleName();
    private Paint paint;
    private Path  path;
    private int   width;
    private int   height;
    private static int BACKGROUND_COLOR = Color.WHITE;
    private static int DRAW_COLOR       = Color.BLACK;
    private static int STROKE_WIDTH     = 30;
    private static int FONT_SIZE        = 100;
    private static int LINE_HEIGHT      = 250;


    public TextVerticalAlignView(Context context) {
        super(context);
        setBackgroundColor(BACKGROUND_COLOR);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(DRAW_COLOR);
        paint.setTextSize(FONT_SIZE);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTypeface(Typeface.SERIF);
    }

    @Override
    public void onDraw(Canvas canvas) {
        center1(canvas, "Python", 100);
        center2(canvas, "Python", 300);
        top(canvas, "Python", 500);
        top2(canvas, "Python", 700);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        width = w;
        height = h;
    }

    private void center1(Canvas canvas, String str, int y) {
        int x = width/2;

        float offset = (paint.ascent() + paint.descent()) / 2;
        canvas.drawText(str, x, y-offset, paint);

        float topY = y - FONT_SIZE/2.0f;
        float bottomY = y+ FONT_SIZE/2.0f;

        canvas.drawLine (0, y, width, y, paint);
        canvas.drawLine(0, topY, width, topY, paint);
        canvas.drawLine(0, bottomY, width, bottomY, paint);
    }

    private void center2(Canvas canvas, String str, int y) {
        int x = width/2;

        Rect bounds = new Rect();
        paint.getTextBounds(str, 0, str.length(), bounds) ;

        float offset = bounds.exactCenterY();
        canvas.drawText(str, x, y-offset, paint);

        float topY = y - FONT_SIZE/2.0f;
        float bottomY = y + FONT_SIZE/2.0f;

        canvas.drawLine(0, y, width, y, paint);
        canvas.drawLine(0, topY, width, topY, paint);
        canvas.drawLine(0, bottomY, width, bottomY, paint);
    }

    private void top(Canvas canvas, String str, int y) {
        int x = width/2;
        canvas.drawText(str, x, y-paint.ascent(), paint);
        canvas.drawLine(0, y, width, y, paint);
    }

    private void top2(Canvas canvas, String str, int y) {
        int x = width/2;

        Rect bounds = new Rect();
        paint.getTextBounds(str, 0, str.length(), bounds);

        canvas.drawText(str, x, y-bounds.top, paint);
        canvas.drawLine(0, y, width, y, paint);
    }

}
