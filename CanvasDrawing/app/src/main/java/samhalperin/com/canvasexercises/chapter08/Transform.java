package samhalperin.com.canvasexercises.chapter08;

/**
 * Karpenko, Yevgen (2013-06-23). Android 2D Graphics with Canvas API. Kindle Edition.
 */

public class Transform {
    private float scaleX;
    private float scaleY;

    private float moveBeforeScaleX;
    private float moveBeforeScaleY;

    private float moveAfterScaleX;
    private float moveAfterScaleY;

    public Transform() {
        setMoveBeforeScale(0, 0);
        setMoveAfterScale(0,0);
        setScale(1, 1);
    }

    public void setMoveBeforeScale(float x, float y) {
        moveBeforeScaleX = x;
        moveBeforeScaleY = y;
    }

    public void setMoveAfterScale(float x, float y) {
        moveAfterScaleX = x;
        moveAfterScaleY = y;
    }


    public void setScale(float x, float y) {
        scaleX = x;
        scaleY = y;
    }

    public float transformX(float x)
    {
        return moveAfterScaleX + scaleX * (moveBeforeScaleX + x);
    }

    public float transformY(float y) {
        return moveAfterScaleY + scaleY * (moveBeforeScaleY +y);
    }
}
