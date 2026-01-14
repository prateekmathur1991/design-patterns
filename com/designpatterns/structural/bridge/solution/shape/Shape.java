package com.designpatterns.structural.bridge.solution.shape;

import com.designpatterns.structural.bridge.solution.color.Color;

/**
 * The bridge pattern attempts to solve this problem by dividing the Shape and Color hierarchies into 2 separate hierarchies
 * that can be built / changed independently.
 * 
 * Essentially, by making Color an attribute of the Shape (as opposed to requiring every concrete Shape to inherit from both Shape and Color super classes), 
 * the bridge pattern moves from inheritance to object composition instead.
 * 
 * The color reference in the Shape class below acts as the "bridge" betweeen Shape and Color hierarchies.
 */
public abstract class Shape {
   
    Color color;
}