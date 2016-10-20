package samhalperin.com.canvasexercises.chapter05;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.View;

/**
 * Karpenko, Yevgen (2013-06-23). Android 2D Graphics with Canvas API. Kindle Edition.
 */

public class BarChartView extends View {
    private Paint barPaint;
    private Paint titleTextPaint;
    private Paint labelTextPaint;

    float totalWidth;

    float barWidth;
    float barPadding;
    float labelPadding;

    float titleY;
    float labelY;
    float plotAreaBottomY;
    float plotAreaHeight;

    private BarChartModel model;
    private RectF         bar;
    private int BACKGROUND_COLOR = Color.WHITE;
    private int BAR_COLOR   = Color.BLUE;
    private int TITLE_TEXT_COLOR = Color.BLACK;


    public BarChartView(Context context) {
        super(context);
        setBackgroundColor(BACKGROUND_COLOR);

        barPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        barPaint.setColor(BAR_COLOR);
        barPaint.setStyle(Paint.Style.FILL);

        titleTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        titleTextPaint.setColor(TITLE_TEXT_COLOR);
        titleTextPaint.setTextAlign(Paint.Align.CENTER);
        titleTextPaint.setTypeface(Typeface.DEFAULT_BOLD);

        labelTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        labelTextPaint.setColor(TITLE_TEXT_COLOR);
        labelTextPaint.setTextAlign(Paint.Align.CENTER);

        model = new BarChartModel();

        bar = new RectF();
    }

    public float getBarLeftX(int barIndex) {
        return barPadding * (barIndex+1) + barWidth * barIndex;

    }

    @Override
    public void onDraw(Canvas canvas) {
        //Title
        canvas.drawText(model.title(), totalWidth/2, titleY, titleTextPaint );

        // Horizontal line below bars
        canvas.drawLine(0, plotAreaBottomY, totalWidth, plotAreaBottomY, labelTextPaint);

        //Bars
        for (int i = 0; i< model.size(); i++) {
            // Bar coordinates
            float leftX = getBarLeftX(i);
            float rightX = leftX + barWidth;
            float topY = plotAreaBottomY - plotAreaHeight * model.getValue(i) / model.maxValue();

            bar.left = leftX;
            bar.right = rightX;
            bar.top = topY;
            bar.bottom = plotAreaBottomY;
            canvas.drawRect(bar, barPaint);

            //Label
            float labelX = (leftX + rightX) / 2;
            canvas.drawText(model.getLabel(i), labelX, labelY, labelTextPaint);

            // Value Text
            String valueText = String.format("%.0f", model.getValue(i));
            canvas.drawText(valueText, labelX, topY - labelPadding, labelTextPaint);
        }
    }

    @Override
    protected void onSizeChanged(int viewWidth, int viewHeight, int oldw, int oldh) {
        totalWidth = viewWidth;

        float viewPadding = viewHeight * 0.03f;
        float titlePadding = viewHeight * 0.05f;
        labelPadding = viewHeight * 0.01f;
        barPadding = viewWidth * 0.1f;

        float titleTextSize = viewHeight * 0.07f;
        float labelTextSize = viewHeight * 0.04f;

        titleY = viewPadding + titleTextSize;
        labelY = viewHeight - viewPadding;

        float plotAreaTopY = viewPadding + titleTextSize + titlePadding + labelTextSize + labelPadding;
        plotAreaBottomY = viewHeight - viewPadding - labelTextSize - labelPadding;
        plotAreaHeight = plotAreaBottomY - plotAreaTopY;

        //Bar width
        int numbars = model.size();
        barWidth = (totalWidth - (numbars+1) * barPadding) / numbars;

        //Font sizes
        titleTextPaint.setTextSize(titleTextSize);
        labelTextPaint.setTextSize(labelTextSize);


    }
}
