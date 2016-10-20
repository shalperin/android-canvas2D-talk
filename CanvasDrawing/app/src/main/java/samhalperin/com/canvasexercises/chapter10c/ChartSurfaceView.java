package samhalperin.com.canvasexercises.chapter10c;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import samhalperin.com.canvasexercises.chapter08.ChartModel;

/**
 * Karpenko, Yevgen (2013-06-23). Android 2D Graphics with Canvas API. Kindle Edition.
 */
public class ChartSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private Matrix matrix;

    private Paint paint, textPaint;
    private Path path;

    private int deviceWidth, deviceHeight;

    public ChartSurfaceView(Context context) {
        super(context);
        init();
    }

    public ChartSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(5);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setColor(Color.BLACK);
        matrix = new Matrix();
        this.getHolder().addCallback(this);
    }

    public void drawLoading() {
        SurfaceHolder holder = this.getHolder();
        Canvas canvas = null;

        try {

            canvas = holder.lockCanvas();
            if (canvas != null) {
                canvas.drawColor(Color.WHITE);
                canvas.drawText(" Loading...", deviceWidth / 2, deviceHeight / 2, textPaint);
            }
        } finally {
            if (canvas != null) {
                holder.unlockCanvasAndPost(canvas);
            }
        }
    }

    public void drawChart(ChartModel model) {
        SurfaceHolder holder = this.getHolder();
        Canvas canvas = null;
        try {
            canvas = holder.lockCanvas();
            if (canvas != null) {
                updatePath(model);
                canvas.drawColor(Color.WHITE);
                canvas.drawPath(path, paint);
            }
        } finally {
            if (canvas != null) {
                holder.unlockCanvasAndPost(canvas);
            }
        }
    }

    private void updatePath(ChartModel model) {
        matrix.reset();
        matrix.postTranslate(0, -model.getMinPrice());
        float scaleX = (float) deviceWidth / (model.getMaxDay() - model.getMinDay());
        float scaleY = (float) deviceHeight / (model.getMaxPrice() - model.getMinPrice());
        matrix.postScale(scaleX, -scaleY);
        matrix.postTranslate(0, deviceHeight);
        path = new Path();
        path.moveTo(0, model.getPrice(0));
        for (int i = 1; i < model.getNumberOfDays(); i++) {
            path.lineTo(i, model.getPrice(i));
        }
        path.transform(matrix);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        deviceHeight = h;
        deviceWidth = w;
        textPaint.setTextSize(h * 0.1f);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Canvas canvas = null;
        try {
            canvas = holder.lockCanvas();
            if (canvas != null) {
                canvas.drawColor(Color.WHITE);
            }
        } finally {
            if (canvas != null)
                holder.unlockCanvasAndPost(canvas);
        }
    }


    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
    }
}
