package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Игорь on 03.08.2016.
 */
public class CanvasView extends View {
    private MainCircle mainCircle;
    private Paint paint;

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initMainCircle();
        initPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
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
