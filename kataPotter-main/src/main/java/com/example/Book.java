package com.example;

import java.util.HashMap;
import java.util.Map;

public class Book {
    public static final Map<Integer, Float> discounts = new HashMap<Integer, Float>() {
        {
            put(1, 0f);
            put(2, 0.05f);
            put(3, 0.1f);
            put(4, 0.2f);
            put(5, 0.25f);
            put(6, 0.5f);
        }
    };

    public static final float price = 8;

    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public float getPrice() {
        return 8f;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            Book aux = (Book) obj;
            return this.title == aux.title;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.title.hashCode();
    }

    @Override
    public String toString() {
        return title;
    }
}
