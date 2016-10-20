package samhalperin.com.canvasexercises.chapter07;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.view.View;

/**
 * Karpenko, Yevgen (2013-06-23). Android 2D Graphics with Canvas API. Kindle Edition.
 */

public class SweepGradientView extends View {

    private int color1 = 0xff00FF00;
    private int color2 = 0xff005500;
    private Paint         paint;
    private SweepGradient gradient;
    private float centerX;
    private float centerY;
    private float radius;

    public SweepGradientView(Context context) {
        super(context);
        setBackgroundColor(Color.WHITE);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawCircle(centerX, centerY, radius, paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        centerX = w / 2.0f;
        centerY = h / 2.0f;
        radius = Math.min(w, h) * .7f / 2.0f;

        // rotate the gradient 45 degrees
        Matrix matrix = new Matrix();
        matrix.postTranslate(-centerX, -centerY);
        matrix.postRotate(-45);
        matrix.postTranslate(centerX, centerY);

        gradient = new SweepGradient(centerX, centerY, color1, color2);
        gradient.setLocalMatrix(matrix);

        paint.setShader(gradient);
        paint.setStrokeWidth(radius/2);
    }
}

