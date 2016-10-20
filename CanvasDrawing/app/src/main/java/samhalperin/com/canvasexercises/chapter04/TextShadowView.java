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

public class TextShadowView extends View {

    private static final String TAG = TextShadowView.class.getSimpleName();
    private Paint paint;
    private Path  path;
    private static int BACKGROUND_COLOR = Color.WHITE;
    private static int DRAW_COLOR       = Color.BLACK;
    private static int STROKE_WIDTH     = 30;
    private static int TEXT_SIZE        = 70;


    public TextShadowView(Context context) {
        super(context);
        setBackgroundColor(BACKGROUND_COLOR);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(DRAW_COLOR);
        paint.setTextSize(TEXT_SIZE);
    }

    @Override
    public void onDraw(Canvas canvas) {
        int x = 20;
        int y = 300;

        paint.setTypeface(Typeface.DEFAULT);
        paint.setShadowLayer(10, 5, -5, Color.GRAY);
        canvas.drawText("Default", x, y, paint);

    }
}
