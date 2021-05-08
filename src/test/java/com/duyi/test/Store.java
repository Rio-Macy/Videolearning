package com.duyi.test;

import java.util.List;

public class Store {

    public void sellBook(Customer customer) {

        String identity = customer.getIdentity();
        Float finalPrice = 0.0f;

        switch (identity) {

            case "vip":
                finalPrice = sum(customer.getBooks()) * 0.8f;
                break;
            case "manager":
                finalPrice = sum(customer.getBooks()) * 0.5f;
            default:
                finalPrice = sum(customer.getBooks()) * 1.0f;
        }
    }

    public Float sum(List<Book> books) {

        Float sumPrice = 0.0f;

        if (books.size() == 0) {

            return 0.0f;
        }

        for (int i = 0; i < books.size(); i++) {

            sumPrice = sumPrice + books.get(i).getBookPrice();
        }

        return sumPrice;
    }
}
