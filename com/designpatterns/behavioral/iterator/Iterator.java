package com.designpatterns.behavioral.iterator;

/**
 * Iterator interface that defines methods for traversing a collection.
 */
public interface Iterator {
    /**
     * Check if there are more elements to iterate.
     * @return true if there are more elements, false otherwise
     */
    boolean hasNext();

    /**
     * Get the next element in the collection.
     * @return the next element
     */
    Object next();
}
