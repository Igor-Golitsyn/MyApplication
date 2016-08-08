package com.example.myapplication;

/**
 * Created by Игорь on 08.08.2016.
 */
public class GameManager {
    private static int width;
    private static int height;
    private MainCircle mainCircle;
    private CanvasView canvasView;

    public GameManager(CanvasView canvasView, int w, int h) {
        this.canvasView = canvasView;
        width = w;
        height = h;
        initMainCircle();
    }

    public void onDraw() {
        canvasView.drawCircle(mainCircle);
    }

    private void initMainCircle() {
        mainCircle = new MainCircle(width / 2, height / 2);
    }


}
