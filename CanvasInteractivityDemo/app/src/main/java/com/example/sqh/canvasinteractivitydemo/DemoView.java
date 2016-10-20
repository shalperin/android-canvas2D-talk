package com.example.sqh.canvasinteractivitydemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sqh on 2/2/16.
 */
public class DemoView extends View {

    private List<ShapeInterface> shapes;
    private int displayWidth;
    private int displayHeight;
    private boolean initted = false;
    private static int N_SHAPES = 50;
    private static int SHAPE_SIZE = 100;
    private ShapeInterface selectedShape = null;


    public DemoView(Context context) {
        super(context);
        setBackgroundColor(Color.WHITE);
    }

    public void initRand(int size) {
        shapes = new ArrayList<ShapeInterface>();
        for (int i = 0; i<size; i++) {
            shapes.add(Box.randBox(displayWidth, displayHeight, SHAPE_SIZE));
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (ShapeInterface s : shapes) {
            s.draw(canvas);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        displayWidth = w;
        displayHeight = h;

        initRand(N_SHAPES);
        invalidate();
    }

    private ShapeInterface selectedShape(int x, int y) {
        for (int i = shapes.size() - 1; i>=0; i--) {
            if (shapes.get(i).contains(x, y)) {
                return shapes.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float eventX = event.getX();
        float eventY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //shapes.remove(s);
                selectedShape = selectedShape((int) eventX, (int) eventY);
                return true;
            case MotionEvent.ACTION_MOVE:
                if (selectedShape != null) {
                    selectedShape.moveTo((int) eventX, (int) eventY);
                    invalidate();
                }
                return true;
            case MotionEvent.ACTION_UP:
                selectedShape = null;
            default:
                return false;
        }
    }
}
