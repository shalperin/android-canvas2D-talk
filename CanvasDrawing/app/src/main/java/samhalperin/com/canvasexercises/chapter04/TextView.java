package samhalperin.com.canvasexercises.chapter04;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.view.View;

import java.lang.reflect.Type;

/**
 * Karpenko, Yevgen (2013-06-23). Android 2D Graphics with Canvas API. Kindle Edition.
 */

public class TextView extends View {

    private static final String TAG = TextView.class.getSimpleName();
    private Paint paint;
    private Path  path;
    private static int BACKGROUND_COLOR = Color.WHITE;
    private static int DRAW_COLOR       = Color.BLACK;
    private static int STROKE_WIDTH     = 30;
    private static int TEXT_SIZE        = 70;


    public TextView(Context context) {
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
        canvas.drawText("Default", x, y, paint);

        y+=90;

        paint.setTypeface(Typeface.DEFAULT_BOLD);
        canvas.drawText("Default Bold", x, y, paint);

        y+=90;

        paint.setTypeface(Typeface.SANS_SERIF);
        canvas.drawText("Sans Serif", x, y, paint);

        y+= 90;

        paint.setTypeface(Typeface.SERIF);
        canvas.drawText("Serif", x, y, paint);

        y+= 90;

        paint.setTypeface(Typeface.MONOSPACE);
        canvas.drawText("Monospace", x, y, paint);

        y+= 90;

        Typeface font = Typeface.create("serif", Typeface.BOLD);
        paint.setTypeface(font);
        canvas.drawText("Serif Bold", x, y, paint);

        y+=90;

        font = Typeface.create("serif", Typeface.ITALIC);
        paint.setTypeface(font);
        canvas.drawText("Serif Italic", x, y, paint);

    }
}
