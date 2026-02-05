package com.designpatterns.behavioral.visitor;

/**
 * ConcreteElement - Represents a list element in the document.
 * Implements the accept method to allow visitors to operate on list elements.
 */
public class ListElement implements Element {
    
    private String[] items;
    
    /**
     * Constructor for list element
     * @param items the list items
     */
    public ListElement(String... items) {
        this.items = items;
    }
    
    @Override
    public void accept(Visitor visitor) {
        // Double dispatch: calls the appropriate visit method on the visitor
        // The visitor knows how to handle ListElement
        visitor.visit(this);
    }
    
    @Override
    public String getContent() {
        return String.join(", ", items);
    }
    
    /**
     * Get the list items
     * @return array of items
     */
    public String[] getItems() {
        return items;
    }
    
    /**
     * Get the number of items in the list
     * @return the item count
     */
    public int getItemCount() {
        return items.length;
    }
}
