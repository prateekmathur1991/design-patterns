package com.designpatterns.behavioral.iterator;

/**
 * Demo class to show how the Iterator pattern works.
 */
public class Demo {
    public static void main(String[] args) {
        // Create a bookshelf with capacity for 5 books
        Bookshelf bookshelf = new Bookshelf(5);

        // Add books to the bookshelf
        bookshelf.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        bookshelf.addBook(new Book("To Kill a Mockingbird", "Harper Lee", 1960));
        bookshelf.addBook(new Book("1984", "George Orwell", 1949));
        bookshelf.addBook(new Book("Pride and Prejudice", "Jane Austen", 1813));
        bookshelf.addBook(new Book("The Catcher in the Rye", "J.D. Salinger", 1951));

        // Create an iterator to traverse the bookshelf
        Iterator iterator = bookshelf.createIterator();

        // Iterate through the books and print them
        System.out.println("Iterating through the bookshelf:");
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            System.out.println(book);
        }
    }
}
