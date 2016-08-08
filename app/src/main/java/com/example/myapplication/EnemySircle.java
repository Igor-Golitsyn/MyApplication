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

    public EnemySircle(int x, int y, int radius) {
        super(x, y, radius);
    }

    public static EnemySircle getRandomCircle() {
        Random random = new Random();
        int x = random.nextInt(GameManager.getWidth());
        int y = random.nextInt(GameManager.getHeight());
        int radius = FROM_RADIUS + random.nextInt(TO_RADIUS - FROM_RADIUS);
        EnemySircle enemySircle = new EnemySircle(x, y, radius);
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
}
