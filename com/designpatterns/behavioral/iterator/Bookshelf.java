package com.designpatterns.behavioral.iterator;

/**
 * Concrete Collection implementation for a Bookshelf.
 */
public class Bookshelf implements Collection {
    private Book[] books;
    private int size = 0;

    public Bookshelf(int capacity) {
        this.books = new Book[capacity];
    }

    public void addBook(Book book) {
        if (size < books.length) {
            books[size++] = book;
        }
    }

    public Book getBook(int index) {
        if (index >= 0 && index < size) {
            return books[index];
        }
        return null;
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator createIterator() {
        return new BookIterator(books);
    }
}
