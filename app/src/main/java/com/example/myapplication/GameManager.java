package com.example.myapplication;

import java.util.ArrayList;

/**
 * Created by Игорь on 08.08.2016.
 */
class GameManager {
    private static final int MAX_CIRCLES = 10;
    private static int width;
    private static int height;
    private MainCircle mainCircle;
    private ArrayList<EnemySircle> circles;
    private CanvasView canvasView;

    GameManager(CanvasView canvasView, int w, int h) {
        this.canvasView = canvasView;
        width = w;
        height = h;
        initMainCircle();
        initEnemyCircles();
    }

    static int getWidth() {
        return width;
    }

    static int getHeight() {
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

    void onDraw() {
        canvasView.drawCircle(mainCircle);
        for (SimpleCircle cir : circles) {
            canvasView.drawCircle(cir);
        }
    }

    private void initMainCircle() {
        mainCircle = new MainCircle(width / 2, height / 2);
    }

    void onTouchEvent(int x, int y) {
        mainCircle.moveMainCircleWhenTouchAt(x, y);
        checkCollision();
        moveCircles();
    }

    private void checkCollision() {
        SimpleCircle circleForDel = null;
        for (EnemySircle sircle : circles) {
            if (mainCircle.isIntersect(sircle)) {
                if (sircle.isSmallerThan(mainCircle)) {
                    mainCircle.growRadius(sircle);
                    circleForDel = sircle;
                    calculateAndSetCirclesColor();
                    break;
                } else {
                    gameEnd("ВЫ ПРОИГРАЛИ!");
                    return;
                }
            }
        }
        if (circleForDel != null) {
            circles.remove(circleForDel);
        }
        if (circles.isEmpty()) {
            gameEnd("ВЫ ВЫИГРАЛИ!");
        }
    }

    private void gameEnd(String s) {
        canvasView.showMessage(s);
        mainCircle.initRadius();
        initEnemyCircles();
        canvasView.redraw();
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
