package com.designpatterns.behavioral.visitor;

/**
 * Element interface - Defines the contract for all document elements.
 * Each element must accept a visitor, enabling the visitor to perform
 * operations on it.
 * 
 * The accept method is the key to the Visitor pattern - it allows
 * visitors to visit each element type.
 */
public interface Element {
    
    /**
     * Accept a visitor to perform operations on this element
     * @param visitor the visitor to accept
     */
    void accept(Visitor visitor);
    
    /**
     * Get the content of this element
     * @return the element's content
     */
    String getContent();
}
