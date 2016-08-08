package com.example.myapplication;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Игорь on 08.08.2016.
 */
public class GameManager {
    private static int width;
    private static int height;
    private MainCircle mainCircle;
    private Paint paint;
    private CanvasView canvasView;

    public GameManager(CanvasView canvasView, int w, int h) {
        this.canvasView = canvasView;
        width = w;
        height = h;
        initMainCircle();
        initPaint();
    }

    public void onDraw(Canvas canvas) {
        canvas.drawCircle(mainCircle.getX(), mainCircle.getY(), mainCircle.getRadius(), paint);
    }

    private void initMainCircle() {
        mainCircle = new MainCircle(width / 2, height / 2);
    }

    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }
}
