package samhalperin.com.canvasexercises.chapter10c;

import android.os.Handler;
import android.os.Message;

/**
 * Karpenko, Yevgen (2013-06-23). Android 2D Graphics with Canvas API. Kindle Edition.
 */
public class MessageHandler extends Handler {
    public static int MSG_AFTER_DRAW_CHART = 1;

    private MessageListener listener;

    public MessageHandler() {

    }

    public void setMessageListener(MessageListener l) {
        listener = l;
    }

    @Override
    public void handleMessage( Message msg) {
        if( listener == null) return;
        if( msg.what == MSG_AFTER_DRAW_CHART) {
            listener.afterDrawChart();
        }
    }


}
