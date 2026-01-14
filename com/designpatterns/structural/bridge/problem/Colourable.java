package com.designpatterns.structural.bridge.problem;

public interface Colourable {

    public enum Color {
        RED,
        BLUE
    }

    Color getColor();
}
