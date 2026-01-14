package com.designpatterns.structural.bridge.solution;

import com.designpatterns.structural.bridge.solution.shape.Circle;
import com.designpatterns.structural.bridge.solution.shape.Shape;
import com.designpatterns.structural.bridge.solution.color.Color;

public class Client {
    
    public static void main(String [] args) {
        Shape blueCircle = new Circle(Color.BLUE);
        Shape redCircle = new Circle(Color.RED);

        System.out.println(blueCircle);
        System.out.println(redCircle);
    }
}
