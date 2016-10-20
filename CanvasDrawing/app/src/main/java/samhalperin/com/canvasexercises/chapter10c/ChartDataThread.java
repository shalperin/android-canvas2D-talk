package samhalperin.com.canvasexercises.chapter10c;

import android.os.Message;

import samhalperin.com.canvasexercises.chapter08.ChartModel;

/**
 * Karpenko, Yevgen (2013-06-23). Android 2D Graphics with Canvas API. Kindle Edition.
 */
public class ChartDataThread extends Thread {
    private String           ticker;
    private ChartSurfaceView view;
    private MessageHandler   handler;

    public ChartDataThread(ChartSurfaceView view, MessageHandler handler, String ticker) {
        this.view = view;
        this.handler = handler;
        this.ticker = ticker;

    }

    public void run() {
        try {
            Thread.sleep(5000);
        } catch (Exception ex) {
        }
        ChartModel data = new ChartModel();
        view.drawChart(data);
        Message msg = Message.obtain();
        msg.what = MessageHandler.MSG_AFTER_DRAW_CHART;
        handler.sendMessage(msg);
    }
}


