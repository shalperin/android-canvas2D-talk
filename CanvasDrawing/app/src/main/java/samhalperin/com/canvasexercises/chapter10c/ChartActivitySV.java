package samhalperin.com.canvasexercises.chapter10c;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import samhalperin.com.canvasexercises.R;

/**
 * Karpenko, Yevgen (2013-06-23). Android 2D Graphics with Canvas API. Kindle Edition.
 */
public class ChartActivitySV extends Activity implements View.OnClickListener, MessageListener {
    private Button           btnGo;
    private EditText         txtTicker;
    private ChartSurfaceView chartView;
    private MessageHandler   handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.activity_chart_sv);
        txtTicker = (EditText) findViewById(R.id.txtTicker);
        btnGo = (Button) findViewById(R.id.btnGo);
        btnGo.setOnClickListener(this);
        chartView = (ChartSurfaceView) findViewById(R.id.chartView);
        handler = new MessageHandler();
        handler.setMessageListener(this);
    }

    @Override
    public void onClick(View v) {
        btnGo.setEnabled(false);
        txtTicker.setEnabled(false);
        chartView.drawLoading();
        String ticker = txtTicker.getText().toString();
        ChartDataThread thread = new ChartDataThread(chartView, handler, ticker);
        thread.start();
    }

    @Override

    public void afterDrawChart() {
        btnGo.setEnabled(true);
        txtTicker.setEnabled(true);
    }
}





