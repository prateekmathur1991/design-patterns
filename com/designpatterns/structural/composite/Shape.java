package com.designpatterns.structural.composite;

import java.awt.Graphics;

public interface Shape {
    
    void paint(Graphics graphics);
    int getX();
    int getY();
    int getWidth();
    int getHeight();
    void move(int x, int y);
    boolean isInsideBounds(int x, int y);
    void select();
    void unSelect();
    boolean isSelected();
}
