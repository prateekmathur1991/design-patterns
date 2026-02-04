package com.designpatterns.behavioral.iterator;

/**
 * Collection interface that defines method to create an iterator.
 */
public interface Collection {
    /**
     * Create and return an iterator for this collection.
     * @return an Iterator for this collection
     */
    Iterator createIterator();
}
