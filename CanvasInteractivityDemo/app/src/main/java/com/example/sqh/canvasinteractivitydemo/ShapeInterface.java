package com.example.sqh.canvasinteractivitydemo;

import android.graphics.Canvas;

/**
 * Created by sqh on 2/2/16.
 */
public interface ShapeInterface {

    public void draw(Canvas canvas);
    public void setColor(int color);
    public boolean contains(float x, float y);
    public void moveTo(int x, int y);

}
