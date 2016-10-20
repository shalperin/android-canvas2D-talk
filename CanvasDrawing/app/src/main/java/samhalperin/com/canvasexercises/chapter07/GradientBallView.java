package samhalperin.com.canvasexercises.chapter07;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.view.View;

/**
 * Karpenko, Yevgen (2013-06-23). Android 2D Graphics with Canvas API. Kindle Edition.
 */

public class GradientBallView extends View {

    private int color1 = 0xff00FF00;
    private int color2 = 0xff005500;
    private Paint paint;
    private RadialGradient gradient;
    private float centerX, centerY, radius;

    public GradientBallView(Context context) {
        super(context);
        setBackgroundColor(Color.WHITE);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawCircle(centerX, centerY, radius, paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {

        centerX = w / 2.0f;
        centerY = h / 2.0f;

        radius = Math.min(w, h) / 3.0f;
        gradient = new RadialGradient(centerX-radius*.3f, centerY-radius*.3f, radius*1.3f, color1, color2, Shader.TileMode.CLAMP);

        paint.setShader(gradient);
    }
}

