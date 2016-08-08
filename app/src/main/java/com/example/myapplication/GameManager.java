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
    private ArrayList<EnemySircle> circles;
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
        SimpleCircle mainCircleArea = mainCircle.getCircleArea();
        circles = new ArrayList<>();
        for (int i = 0; i < MAX_CIRCLES; i++) {
            EnemySircle enemySircle;
            do {
                enemySircle = EnemySircle.getRandomCircle();
            } while (enemySircle.isIntersect(mainCircleArea));
            circles.add(enemySircle);
        }
        calculateAndSetCirclesColor();
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
        moveCircles();
    }

    private void moveCircles() {
        for (EnemySircle sircle : circles) {
            sircle.moveOneStep();
        }
    }

    private void calculateAndSetCirclesColor() {
        for (EnemySircle cir : circles) {
            cir.setEnemyOrFoodColor(mainCircle);
        }
    }
}
