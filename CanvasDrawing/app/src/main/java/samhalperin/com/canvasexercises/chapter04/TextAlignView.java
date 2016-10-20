package samhalperin.com.canvasexercises.chapter04;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.view.View;

/**
 * Karpenko, Yevgen (2013-06-23). Android 2D Graphics with Canvas API. Kindle Edition.
 */

public class TextAlignView extends View {

    private static final String TAG = TextAlignView.class.getSimpleName();
    private Paint paint;
    private Path  path;
    private int   width;
    private int   height;
    private static int BACKGROUND_COLOR = Color.WHITE;
    private static int DRAW_COLOR       = Color.BLACK;
    private static int STROKE_WIDTH     = 30;
    private static int TEXT_SIZE        = 90;
    private static int LINE_HEIGHT      = 120;


    public TextAlignView(Context context) {
        super(context);
        setBackgroundColor(BACKGROUND_COLOR);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(DRAW_COLOR);
        paint.setTextSize(TEXT_SIZE);
    }

    @Override
    public void onDraw(Canvas canvas) {
        int x = width / 2;
        int y = LINE_HEIGHT;

        canvas.drawLine(x, 0, x, height, paint);

        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawText("Left", x, y, paint);

        y += LINE_HEIGHT;

        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("Center", x, y, paint);

        y += LINE_HEIGHT;

        paint.setTextAlign(Paint.Align.RIGHT);
        canvas.drawText("Right", x, y, paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        width = w;
        height = h;
    }
}
