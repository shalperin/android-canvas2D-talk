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

public class CustomFontView extends View {

    private static final String TAG = CustomFontView.class.getSimpleName();
    private Paint paint;
    private Path  path;
    private static int BACKGROUND_COLOR = Color.WHITE;
    private static int DRAW_COLOR       = Color.BLACK;
    private static int STROKE_WIDTH     = 30;
    private static int TEXT_SIZE        = 70;
    private Typeface font1, font2;

    public CustomFontView(Context context) {
        super(context);
        setBackgroundColor(BACKGROUND_COLOR);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(DRAW_COLOR);
        paint.setTextSize(TEXT_SIZE);

        font1 = Typeface.createFromAsset(context.getAssets(), "Magnolia.ttf");


    }

    @Override
    public void onDraw(Canvas canvas) {
        int x = 20;
        int y = 300;

        paint.setTypeface(font1);
        canvas.drawText("Magnolia", x, y, paint);
    }
}
