package com.example.bookfinder.model;
import java.util.List;

public class BookResponse {
    private int totalItems;
    private List<Book> items;

    public int getTotalItems() {
        return totalItems;
    }

    public List<Book> getItems() {
        return items;
    }
}

