package com.example.myapplication;

import android.graphics.Color;

/**
 * Created by Игорь on 03.08.2016.
 */
public class MainCircle extends SimpleCircle {
    public static final int INIT_RADIUS = 50;
    public static final int MAIN_SPEED = 30;
    public static final int OUR_COLOR = Color.BLUE;

    public MainCircle(int x, int y) {
        super(x, y, INIT_RADIUS);
        setColor(OUR_COLOR);
    }

    public void moveMainCircleWhenTouchAt(int x1, int y1) {
        int dx = (x1 - x) * MAIN_SPEED / GameManager.getWidth();
        int dy = (y1 - y) * MAIN_SPEED / GameManager.getHeight();
        x += dx;
        y += dy;
    }

    public void initRadius() {
        radius = INIT_RADIUS;
    }

    public void growRadius(EnemySircle sircle) {
        //pi*newR^2=pi*r^2+pi*reat^2
        //newR=sqrt(r^2+reat^2)
        radius = (int) Math.sqrt(Math.pow(radius, 2) + Math.pow(sircle.radius, 2));
    }
}
