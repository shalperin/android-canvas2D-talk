package samhalperin.com.canvasexercises.chapter05;

/**
 * Karpenko, Yevgen (2013-06-23). Android 2D Graphics with Canvas API. Kindle Edition.
 */

public class BarChartModel {

    private String labels[] = {"2010", "2011", "2012"};
    private float values[] = {6535, 4236, 7654};
    private float maxValue;
    private String title = "Annual Sales";

    public BarChartModel() {
        maxValue = values[0];
        for (float v : values) {
            if (v > maxValue) {
                maxValue = v;
            }
        }
    }

    public int size() {
        return values.length;
    }

    public String getLabel(int index) {
        return labels[index];
    }

    public float getValue(int index) {
        return values[index];
    }

    public float maxValue() {
        return maxValue;
    }

    public String title() {
        return title;
    }
}
