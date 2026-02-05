package com.designpatterns.behavioral.visitor;

/**
 * ConcreteElement - Represents an image element in the document.
 * Implements the accept method to allow visitors to operate on image elements.
 */
public class ImageElement implements Element {
    
    private String url;
    private String altText;
    
    /**
     * Constructor for image element
     * @param url the image URL
     * @param altText the alternative text for the image
     */
    public ImageElement(String url, String altText) {
        this.url = url;
        this.altText = altText;
    }
    
    @Override
    public void accept(Visitor visitor) {
        // Double dispatch: calls the appropriate visit method on the visitor
        // The visitor knows how to handle ImageElement
        visitor.visit(this);
    }
    
    @Override
    public String getContent() {
        return altText;
    }
    
    /**
     * Get the image URL
     * @return the URL
     */
    public String getUrl() {
        return url;
    }
    
    /**
     * Get the alternative text
     * @return the alt text
     */
    public String getAltText() {
        return altText;
    }
}
