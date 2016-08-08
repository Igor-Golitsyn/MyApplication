package com.example.myapplication;

import java.util.ArrayList;

/**
 * Created by Игорь on 08.08.2016.
 */
public class GameManager {
    public static final int MAX_CIRCLES = 10;
    private static int width;
    private static int height;
    private MainCircle mainCircle;
    private ArrayList<SimpleCircle> circles;
    private CanvasView canvasView;

    public GameManager(CanvasView canvasView, int w, int h) {
        this.canvasView = canvasView;
        width = w;
        height = h;
        initMainCircle();
        initEnemyCircles();
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    private void initEnemyCircles() {
        circles = new ArrayList<>();
        for (int i = 0; i < MAX_CIRCLES; i++) {
            circles.add(EnemySircle.getRandomCircle());
        }
    }

    public void onDraw() {
        canvasView.drawCircle(mainCircle);
        for (SimpleCircle cir : circles) {
            canvasView.drawCircle(cir);
        }
    }

    private void initMainCircle() {
        mainCircle = new MainCircle(width / 2, height / 2);
    }

    public void onTouchEvent(int x, int y) {
        mainCircle.moveMainCircleWhenTouchAt(x, y);
    }
}
