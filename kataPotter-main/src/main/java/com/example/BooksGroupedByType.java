package com.example;

import java.util.HashMap;
import java.util.Map;

public class BooksGroupedByType {
    private Map<String, Integer> modelsOfBooks;

    public BooksGroupedByType() {
        modelsOfBooks = new HashMap<>();
    }

    public Map<String, Integer> getList() {
        return modelsOfBooks;
    }

    public Integer getModelByTitle(String title) {
        return modelsOfBooks.get(title);
    }

    public void put(String title, Integer quantity) {
        modelsOfBooks.put(title, quantity);
    }

    @Override
    public String toString() {
        String output = "";
        for (Map.Entry<String, Integer> entry : modelsOfBooks.entrySet()) {
            output += entry.getKey() + " => " + String.valueOf(entry.getValue()) + " ";
        }
        return output;
    }
}
