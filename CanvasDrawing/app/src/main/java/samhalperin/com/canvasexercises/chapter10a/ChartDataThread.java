package samhalperin.com.canvasexercises.chapter10a;

import android.os.Message;

import samhalperin.com.canvasexercises.chapter08.ChartModel;
/**
 * Karpenko, Yevgen (2013-06-23). Android 2D Graphics with Canvas API. Kindle Edition.
 */
public class ChartDataThread extends Thread {

    private MessageHandler handler;
    private String ticker;

    public ChartDataThread(MessageHandler handler, String ticker) {
        this.handler = handler;
        this.ticker = ticker;
    }

    public void run() {
        try {
            Thread.sleep(5000);
        } catch (Exception ex) {

        }

        ChartModel data = new ChartModel();

        Message msg = Message.obtain();
        msg.what = MessageHandler.MSG_CHART_DATA;
        msg.obj = data;

        handler.sendMessage(msg);

    }
}
