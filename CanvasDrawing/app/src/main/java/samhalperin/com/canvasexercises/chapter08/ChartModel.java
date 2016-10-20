package samhalperin.com.canvasexercises.chapter08;

/**
 * Karpenko, Yevgen (2013-06-23). Android 2D Graphics with Canvas API. Kindle Edition.
 */

public class ChartModel {

    private static float  PRICES[] = {1518.20f, 1525.20f, 1539.79f, 1541.46f, 1544.26f, 1551.18f, 1556.22f, 1552.48f, 1554.52f, 1563.23f, 1560.70f, 1552.10f, 1548.34f, 1558.71f, 1545.80f, 1556.89f, 1551.69f, 1563.77f, 1562.85f, 1569.19f};
    private static String DATES[]  = {"2013-03-01", "2013-03-04", "2013-03-05", "2013-03-06", "2013-03-07", "2013-03-08", "2013-03-11", "2013-03-12", "2013-03-13", "2013-03-14", "2013-03-15", "2013-03-18", "2013-03-19", "2013-03-20", "2013-03-21", "2013-03-22", "2013-03-25", "2013-03-26", "2013-03-27", "2013-03-28"};

    private static float MIN_PRICE = 1510;
    private static float MAX_PRICE = 1580;

    public ChartModel() {
    }

    public float getMinPrice() {
        return MIN_PRICE;
    }

    public float getMaxPrice() {
        return MAX_PRICE;
    }

    public int getNumberOfDays() {
        return PRICES.length;
    }

    public int getMinDay() {
        return 0;
    }

    public int getMaxDay() {
        return PRICES.length - 1;
    }

    public float getPrice(int index) {
        return PRICES[index];
    }
}
