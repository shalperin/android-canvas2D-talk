package com.example.sqh.canvasinteractivitydemo;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import java.util.Random;

/**
 * Created by sqh on 2/2/16.
 */
public class Box implements ShapeInterface {
    private float centerX;
    private float centerY;
    private int color;
    private int size;
    private RectF cache;

    public static Box randBox(int displayWidth, int displayHeight, int size) {
        Box b = new Box();
        Random r = new Random();
        b.size = size;
        b.centerX = r.nextInt(displayWidth + 1);
        b.centerY = r.nextInt(displayHeight + 1);
        b.cache = new RectF(b.centerX - size, b.centerY -size, b.centerX + size, b.centerY + size);
        b.setColor(r.nextInt());
        return b;
    }

    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(cache, paint);
    }

    @Override
    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public boolean contains(float x, float y) {
        return ( cache.contains(x, y));
    }

    public void setRect(RectF rect) {
        this.cache = rect;
    }

    public void moveTo(int x, int y) {
        centerX = x;
        centerY = y;
        cache = new RectF(centerX - size, centerY -size, centerX + size, centerY + size);
    }
}
