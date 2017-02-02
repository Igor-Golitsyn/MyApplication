package com.example.myapplication;

/**
 * Created by Игорь on 08.08.2016.
 */
class SimpleCircle {
    int x;
    int y;
    int radius;
    private int color;

    SimpleCircle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    int getRadius() {
        return radius;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    SimpleCircle getCircleArea() {
        return new SimpleCircle(x, y, radius * 3);
    }

    boolean isIntersect(SimpleCircle mainCircleArea) {
        return radius + mainCircleArea.radius >= Math.sqrt(Math.pow(x - mainCircleArea.x, 2) + Math.pow(y - mainCircleArea.y, 2));
    }
}
