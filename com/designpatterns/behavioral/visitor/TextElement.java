package com.designpatterns.behavioral.visitor;

/**
 * ConcreteElement - Represents a text element in the document.
 * Implements the accept method to allow visitors to operate on text elements.
 */
public class TextElement implements Element {
    
    private String content;
    
    /**
     * Constructor for text element
     * @param content the text content
     */
    public TextElement(String content) {
        this.content = content;
    }
    
    @Override
    public void accept(Visitor visitor) {
        // Double dispatch: calls the appropriate visit method on the visitor
        // The visitor knows how to handle TextElement
        visitor.visit(this);
    }
    
    @Override
    public String getContent() {
        return content;
    }
}
