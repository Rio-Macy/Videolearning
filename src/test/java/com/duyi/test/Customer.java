package com.duyi.test;

import java.util.List;

public class Customer {

    private String identity;
    private List<Book> books;

    public Customer() {
    }

    public Customer(String identity) {
        this.identity = identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getIdentity() {
        return identity;
    }

    public void buyBook(Book book) {

        books.add(book);
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }
}
