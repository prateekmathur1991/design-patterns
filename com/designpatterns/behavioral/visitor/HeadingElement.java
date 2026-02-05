package com.designpatterns.behavioral.visitor;

/**
 * ConcreteElement - Represents a heading element in the document.
 * Implements the accept method to allow visitors to operate on heading elements.
 */
public class HeadingElement implements Element {
    
    private String content;
    private int level; // 1 = H1, 2 = H2, etc.
    
    /**
     * Constructor for heading element
     * @param content the heading text
     * @param level the heading level (1-6)
     */
    public HeadingElement(String content, int level) {
        this.content = content;
        this.level = level;
    }
    
    @Override
    public void accept(Visitor visitor) {
        // Double dispatch: calls the appropriate visit method on the visitor
        // The visitor knows how to handle HeadingElement
        visitor.visit(this);
    }
    
    @Override
    public String getContent() {
        return content;
    }
    
    /**
     * Get the heading level
     * @return the heading level
     */
    public int getLevel() {
        return level;
    }
}
