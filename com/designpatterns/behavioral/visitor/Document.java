package com.designpatterns.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Context class - A document that contains multiple elements.
 * The document can accept visitors and let them operate on all its elements.
 * This is the object structure that visitors traverse.
 */
public class Document {
    
    private String title;
    private List<Element> elements;
    
    /**
     * Constructor for creating a document
     * @param title the document title
     */
    public Document(String title) {
        this.title = title;
        this.elements = new ArrayList<>();
    }
    
    /**
     * Add an element to the document
     * @param element the element to add
     */
    public void addElement(Element element) {
        elements.add(element);
    }
    
    /**
     * Accept a visitor to traverse all elements
     * @param visitor the visitor to accept
     */
    public void accept(Visitor visitor) {
        System.out.println("Document \"" + title + "\" accepting visitor...\n");
        for (Element element : elements) {
            element.accept(visitor);
        }
        System.out.println();
    }
    
    /**
     * Get the document title
     * @return the title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Get the number of elements in the document
     * @return element count
     */
    public int getElementCount() {
        return elements.size();
    }
}
