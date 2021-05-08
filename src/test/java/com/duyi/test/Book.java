package com.duyi.test;

public class Book extends Animal{

    private String bookName;
    private Float bookPrice;

    public Book() {
    }

    public Book(String bookName, Float bookPrice) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookPrice(Float bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookName() {
        return bookName;
    }

    public Float getBookPrice() {
        return bookPrice;
    }
}
