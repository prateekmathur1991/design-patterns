package com.designpatterns.behavioral.visitor;

/**
 * Visitor interface - Defines the contract for all concrete visitors.
 * The Visitor pattern allows defining new operations on elements
 * without changing their classes.
 * 
 * Each concrete visitor implements different operations for each element type.
 * This is the "double dispatch" mechanism - the operation depends on both
 * the visitor type AND the element type.
 */
public interface Visitor {
    
    /**
     * Visit a text element
     * @param element the text element to visit
     */
    void visit(TextElement element);
    
    /**
     * Visit a heading element
     * @param element the heading element to visit
     */
    void visit(HeadingElement element);
    
    /**
     * Visit an image element
     * @param element the image element to visit
     */
    void visit(ImageElement element);
    
    /**
     * Visit a list element
     * @param element the list element to visit
     */
    void visit(ListElement element);
}
