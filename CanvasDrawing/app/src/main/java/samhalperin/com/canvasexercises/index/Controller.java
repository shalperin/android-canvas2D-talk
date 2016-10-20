package samhalperin.com.canvasexercises.index;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import samhalperin.com.canvasexercises.R;
import samhalperin.com.canvasexercises.chapter01.ScreenSizeActivity;
import samhalperin.com.canvasexercises.chapter03.DashedLineActivity;
import samhalperin.com.canvasexercises.chapter03.LineActivity;
import samhalperin.com.canvasexercises.chapter03.PathActivity;
import samhalperin.com.canvasexercises.chapter03.TriangleActivity;
import samhalperin.com.canvasexercises.chapter03.TriangleFillActivity;
import samhalperin.com.canvasexercises.chapter04.CustomFontActivity;
import samhalperin.com.canvasexercises.chapter04.TextActivity;
import samhalperin.com.canvasexercises.chapter04.TextAlignActivity;
import samhalperin.com.canvasexercises.chapter04.TextBaselineActivity;
import samhalperin.com.canvasexercises.chapter04.TextShadowActivity;
import samhalperin.com.canvasexercises.chapter04.TextVerticalAlignActivity;
import samhalperin.com.canvasexercises.chapter05.BarChartActivity;
import samhalperin.com.canvasexercises.chapter06.ArcActivity;
import samhalperin.com.canvasexercises.chapter06.CircleActivity;
import samhalperin.com.canvasexercises.chapter06.CircularChartActivity;
import samhalperin.com.canvasexercises.chapter06.OvalActivity;
import samhalperin.com.canvasexercises.chapter07.GradientActivity;
import samhalperin.com.canvasexercises.chapter07.GradientBallActivity;
import samhalperin.com.canvasexercises.chapter07.SweepGradientActivity;
import samhalperin.com.canvasexercises.chapter08.ChartActivity;
import samhalperin.com.canvasexercises.chapter08.TransformActivity;
import samhalperin.com.canvasexercises.chapter09.CTMBadExampleActivity;
import samhalperin.com.canvasexercises.chapter09.CTMFixedExampleActivity;
import samhalperin.com.canvasexercises.chapter09.MatrixChartActivity;
import samhalperin.com.canvasexercises.chapter09.TriangleMatrixActivity;
import samhalperin.com.canvasexercises.chapter10a.ChartMTActivity;
import samhalperin.com.canvasexercises.chapter10b.ProgressActivity;
import samhalperin.com.canvasexercises.chapter10c.ChartActivitySV;

/**
 * Created by sqh on 1/24/16.
 */
public class Controller {

    private final Context context;

    public Controller(Context context) {
        this.context = context;
    }

    public void launch(int id) {
        switch(id) {
            case R.id.screen_size:
                context.startActivity(new Intent(context, ScreenSizeActivity.class));
                break;
            case R.id.line_view:
                context.startActivity(new Intent(context, LineActivity.class ));
                break;
            case R.id.path_view:
                context.startActivity(new Intent(context, PathActivity.class));
                break;
            case R.id.triangle_view:
                context.startActivity(new Intent(context, TriangleActivity.class));
                break;
            case R.id.triangle_fill_view:
                context.startActivity(new Intent(context, TriangleFillActivity.class));
                break;
            case R.id.dashed_line_view:
                context.startActivity(new Intent(context, DashedLineActivity.class));
                break;
            case R.id.text_view:
                context.startActivity(new Intent(context, TextActivity.class));
                break;
            case R.id.custom_typeface_view:
                context.startActivity(new Intent(context, CustomFontActivity.class));
                break;
            case R.id.text_align_view:
                context.startActivity(new Intent(context, TextAlignActivity.class));
                break;
            case R.id.text_baseline_view:
                context.startActivity(new Intent(context, TextBaselineActivity.class));
                break;
            case R.id.text_vertical_align_view:
                context.startActivity(new Intent(context, TextVerticalAlignActivity.class));
                break;
            case R.id.text_shadow_view:
                context.startActivity(new Intent(context, TextShadowActivity.class));
                break;
            case R.id.bar_chart_view:
                context.startActivity(new Intent(context, BarChartActivity.class));
                break;
            case R.id.circle_view:
                context.startActivity(new Intent(context, CircleActivity.class));
                break;
            case R.id.oval_view:
                context.startActivity(new Intent(context, OvalActivity.class));
                break;
            case R.id.arc_view:
                context.startActivity(new Intent(context, ArcActivity.class));
                break;
            case R.id.circular_chart_view:
                context.startActivity(new Intent(context, CircularChartActivity.class));
                break;
            case R.id.gradient_view:
                context.startActivity(new Intent(context, GradientActivity.class));
                break;
            case R.id.gradient_ball_view:
                context.startActivity(new Intent(context, GradientBallActivity.class));
                break;
            case R.id.sweep_gradient_view:
                context.startActivity(new Intent(context, SweepGradientActivity.class));
                break;
            case R.id.transform_view:
                context.startActivity(new Intent(context, TransformActivity.class));
                break;
            case R.id.chart_view:
                context.startActivity(new Intent(context, ChartActivity.class));
                break;
            case R.id.triangle_matrix_view:
                context.startActivity(new Intent(context, TriangleMatrixActivity.class));
                break;
            case R.id.matrix_chart_view:
                context.startActivity(new Intent(context, MatrixChartActivity.class));
                break;
            case R.id.ctm_bad_example_view:
                context.startActivity(new Intent(context, CTMBadExampleActivity.class));
                break;
            case R.id.ctm_fixed_example_view:
                context.startActivity(new Intent(context, CTMFixedExampleActivity.class));
                break;
            case R.id.chartViewMT:
                context.startActivity(new Intent(context, ChartMTActivity.class));
                break;
            case R.id.progress_view:
                context.startActivity(new Intent(context, ProgressActivity.class));
                break;
            case R.id.chart_surface_view:
                context.startActivity(new Intent(context, ChartActivitySV.class));
                break;
            default:
                new Toast(context).makeText(context, "invalid activity", Toast.LENGTH_LONG).show();
        }
    }
}
