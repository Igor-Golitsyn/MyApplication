package com.example.myapplication;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Игорь on 08.08.2016.
 */
public class GameManager {
    private MainCircle mainCircle;
    private Paint paint;

    public GameManager() {
        initMainCircle();
        initPaint();
    }

    public void onDraw(Canvas canvas) {
        canvas.drawCircle(mainCircle.getX(), mainCircle.getY(), mainCircle.getRadius(), paint);
    }

    private void initMainCircle() {
        mainCircle = new MainCircle(200, 500);
    }

    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }
}
