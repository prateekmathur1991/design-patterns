package com.designpatterns.structural.bridge.problem;

/**
 * This represents the problem here. If a new GreenCircle (or even a RedTriangle) is desired, a new class has to be created.
 * The more color options and more shapes are desired, more complex the code base gets.
 */
public class BlueCircle extends Circle {
    
    @Override
    public Color getColor() {
        return Color.BLUE;
    }
}
