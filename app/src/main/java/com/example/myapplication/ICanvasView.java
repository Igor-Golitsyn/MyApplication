package com.example.myapplication;

/**
 * Created by Игорь on 08.08.2016.
 */
public interface ICanvasView {
    void drawCircle(SimpleCircle circle);

    void redraw();

    void showMessage(String s);
}
