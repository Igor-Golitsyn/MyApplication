package com.example.myapplication;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by Игорь on 08.08.2016.
 */
public class EnemySircle extends SimpleCircle {

    public static final int FROM_RADIUS = 10;
    public static final int TO_RADIUS = 110;
    public static final int ENEMY_COLOR = Color.RED;
    public static final int FOOD_COLOR = Color.rgb(0, 200, 0);
    public static final int RANDOM_SPEED = 10;
    private int dx;
    private int dy;

    public EnemySircle(int x, int y, int radius, int dx, int dy) {
        super(x, y, radius);
        this.dx = dx;
        this.dy = dy;
    }

    public static EnemySircle getRandomCircle() {
        Random random = new Random();
        int x = random.nextInt(GameManager.getWidth());
        int y = random.nextInt(GameManager.getHeight());
        int dx = 1 + random.nextInt(RANDOM_SPEED);
        int dy = 1 + random.nextInt(RANDOM_SPEED);
        int radius = FROM_RADIUS + random.nextInt(TO_RADIUS - FROM_RADIUS);
        EnemySircle enemySircle = new EnemySircle(x, y, radius, dx, dy);
        return enemySircle;
    }

    public void setEnemyOrFoodColor(MainCircle mainCircle) {
        if (isSmallerThan(mainCircle)) {
            setColor(FOOD_COLOR);
        } else {
            setColor(ENEMY_COLOR);
        }
    }

    private boolean isSmallerThan(SimpleCircle circle) {
        return radius < circle.radius;
    }

    public void moveOneStep() {
        x += dx;
        y += dy;
        checkBounds();
    }

    private void checkBounds() {
        if (x > GameManager.getWidth() || x < 0) {
            dx = -dx;
        }
        if (y > GameManager.getHeight() || y < 0) {
            dy = -dy;
        }
    }
}
