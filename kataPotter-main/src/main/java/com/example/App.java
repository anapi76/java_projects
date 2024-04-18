package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static final List<Book> allowedBookTypes = new ArrayList<Book>() {
        {
            add(new Book("Piedra filosofal"));
            add(new Book("Camara secreta"));
            add(new Book("Prisionero azkaban"));
            add(new Book("Caliz fuego"));
            add(new Book("Orden fenix"));
            add(new Book("Principe mestizo"));
        }
    };

    public static void main(String[] args) {
        Cart cart = new Cart();
        Book[] books = {
                new Book("Piedra filosofal"),
                new Book("Orden fenix")
        };

        cart.addItems(books);
        System.out.println(cart.calculateBestPrice() + "€");
    }
}
