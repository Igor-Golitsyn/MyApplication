package com.example.myapplication;

import java.util.Random;

/**
 * Created by Игорь on 08.08.2016.
 */
public class EnemySircle extends SimpleCircle {

    public static final int FROM_RADIUS = 10;
    public static final int TO_RADIUS = 110;

    public EnemySircle(int x, int y, int radius) {
        super(x, y, radius);
    }

    public static SimpleCircle getRandomCircle() {
        Random random = new Random();
        int x = random.nextInt(GameManager.getWidth());
        int y = random.nextInt(GameManager.getHeight());
        int radius = FROM_RADIUS + random.nextInt(TO_RADIUS - FROM_RADIUS);
        return new EnemySircle(x, y, radius);
    }
}
