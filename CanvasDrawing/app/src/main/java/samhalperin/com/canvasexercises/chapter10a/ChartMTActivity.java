package samhalperin.com.canvasexercises.chapter10a;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import samhalperin.com.canvasexercises.R;
import samhalperin.com.canvasexercises.chapter08.ChartModel;

/**
 * Karpenko, Yevgen (2013-06-23). Android 2D Graphics with Canvas API. Kindle Edition.
 */
public class ChartMTActivity extends AppCompatActivity implements View.OnClickListener, MessageListener {

    private Button   btnGo;
    private EditText txtTicker;
    private ChartViewMT chartView;
    private MessageHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_mt);

        txtTicker = (EditText)findViewById(R.id.txtTicker);
        btnGo = (Button)findViewById(R.id.btnGo);
        btnGo.setOnClickListener(this);

        chartView = (ChartViewMT)findViewById(R.id.chartView);

        handler = new MessageHandler();
        handler.setMessageListener(this);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    @Override public void onClick(View v) {
        btnGo.setEnabled(false);
        txtTicker.setEnabled(false);
        chartView.setLoading(true);

        String ticker = txtTicker.getText().toString();

        ChartDataThread thread = new ChartDataThread(handler, ticker);
        thread.start();
    }

    @Override
    public void onChartData(ChartModel model) {
        chartView.setModel(model);
        btnGo.setEnabled(true);
        txtTicker.setEnabled(true);
    }
}
