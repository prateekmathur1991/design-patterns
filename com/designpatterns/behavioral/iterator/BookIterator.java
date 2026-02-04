package com.designpatterns.behavioral.iterator;

/**
 * Concrete Iterator implementation for an array of Books.
 */
public class BookIterator implements Iterator {
    private Book[] books;
    private int currentIndex = 0;

    public BookIterator(Book[] books) {
        this.books = books;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < books.length;
    }

    @Override
    public Object next() {
        if (hasNext()) {
            return books[currentIndex++];
        }
        return null;
    }
}
