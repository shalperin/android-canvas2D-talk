package samhalperin.com.canvasexercises.chapter07;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;

/**
 * Karpenko, Yevgen (2013-06-23). Android 2D Graphics with Canvas API. Kindle Edition.
 */

public class GradientView extends View {

    private int color1 = 0xff00FF00;
    private int color2 = 0xff005500;
    private Paint paint;
    private int width, height;
    private LinearGradient gradient;
    private RadialGradient gradient2;

    public GradientView(Context context) {
        super(context);
        setBackgroundColor(Color.WHITE);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawRect(0, 0, width, height, paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        width = w;
        height = h;

        // vertical gradient
        //gradient = new LinearGradient(0, 0, 0, h, color1, color2, Shader.TileMode.CLAMP);

        // horizontal gradient
        //gradient = new LinearGradient(0, 0, width, h, color1, color2, Shader.TileMode.CLAMP);

        // diagonal gradient
        //gradient = new LinearGradient(0, 0, width, height, color1, color2, Shader.TileMode.CLAMP);

        // mirrored vertical gradient
        //gradient = new LinearGradient(0, 0, 0, h/2, color1, color2, Shader.TileMode.MIRROR);

        //radial gradient
        float centerX = w / 2.0f;
        float centerY = h / 2.0f;
//
//        float radius = Math.min(width, height) / 2.0f;
//        gradient2 = new RadialGradient(centerX, centerY, radius, color1, color2, Shader.TileMode.CLAMP);


        // Repeating radial gradient
        float radius = Math.min(width, height) / 20.0f;
        gradient2 = new RadialGradient(centerX, centerY, radius, color1, color2, Shader.TileMode.REPEAT);
        paint.setShader(gradient2);
    }
}

