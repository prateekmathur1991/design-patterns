package com.designpatterns.structural.bridge.solution.shape;

import com.designpatterns.structural.bridge.solution.color.Color;

/**
 * Notice how creating a blue (or red) circle now does not require me to create a class by the name BlueCircle (or RedCircle)
 * 
 * Also, if a gree circle is desired, I only need to change the Color hierarchy (by introducing a new Color) and leave the shapes hierarchy untouched.
 * Similarly, if a red triangle is desired, I only to need change the Shape hierarchy (by introducing a new Shape) and leave the colors hierarchy untouched.
 */
public class Circle extends Shape {

    private int radius;
    
    public Circle(Color color, int radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "I am a circle of " + this.color + " color and radius " + this.radius;
    }
}
