package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;

public class MainTest {

    public static final float bookPrice = 8;

    Cart cart = new Cart();

    @After
    public void after() {
        cart.clear();
    }

    @Test
    public void testEmptyCart() {
        float expectedResult = 0;
        assertEquals(expectedResult, cart.calculateBestPrice(), 0.0f);
    }

    @Test
    public void testSingleBook() {
        float expectedResult = bookPrice;
        Book[] books = { new Book("Piedra filosofal") };
        cart.addItems(books);
        assertEquals(expectedResult, cart.calculateBestPrice(), 0.0f);
    }

    @Test
    public void testTwoSameBooks() {
        float expectedResult = (bookPrice * 2);
        Book[] books = { new Book("Piedra filosofal"), new Book("Piedra filosofal") };
        cart.addItems(books);
        assertEquals(expectedResult, cart.calculateBestPrice(), 0.0f);
    }

    @Test
    public void testTwoSameBooksAndSingleDifferent() {
        float expectedResult = (bookPrice * 2 * 0.95f) + bookPrice;

        Book[] books = { new Book("Piedra filosofal"), new Book("Piedra filosofal"), new Book("Orden fenix") };
        cart.addItems(books);
        assertEquals(expectedResult, cart.calculateBestPrice(), 0.0f);
    }

    @Test
    public void testTwoDifferentBooks() {
        float expectedResult = (bookPrice * 2 * 0.95f);
        Book[] books = { new Book("Piedra filosofal"), new Book("Caliz fuego") };
        cart.addItems(books);
        assertEquals(expectedResult, cart.calculateBestPrice(), 0.0f);
    }

    @Test
    public void testAddBooksNotInOffer() {
        float expectedResult = bookPrice * 2;

        Book[] books = { new Book("Piedra filosofica"), new Book("Caliz de fuego") };
        cart.addItems(books);
        assertEquals(expectedResult, cart.calculateBestPrice(), 0.0f);
    }

    @Test
    public void mixBooksWithAndWithOutOffer() {
        float expectedResult = (bookPrice * 2 * 0.95f) + bookPrice;

        Book[] books = { new Book("Piedra filosofal"), new Book("Caliz fuego"), new Book("Otro libro") };
        cart.addItems(books);
        assertEquals(expectedResult, cart.calculateBestPrice(), 0.0f);
    }

    @Test
    public void testEdgeCase1() {
        float expectedResult = (2 * (bookPrice * 4 * 0.8f));

        Book[] books = { new Book("Piedra filosofal"), new Book("Piedra filosofal"),
                new Book("Camara secreta"), new Book("Camara secreta"), new Book("Prisionero azkaban"),
                new Book("Prisionero azkaban"), new Book("Caliz fuego"), new Book("Orden fenix") };

        cart.addItems(books);
        assertEquals(expectedResult, cart.calculateBestPrice(), 0.0f);
    }

    @Test
    public void testEdgeCase2() {
        float expectedResult = (3 * (bookPrice * 5 * 0.75f) + 2 * (bookPrice * 4 * 0.8f));

        Book[] books = {
                new Book("Piedra filosofal"),
                new Book("Piedra filosofal"),
                new Book("Piedra filosofal"),
                new Book("Piedra filosofal"),
                new Book("Piedra filosofal"),
                new Book("Camara secreta"),
                new Book("Camara secreta"),
                new Book("Camara secreta"),
                new Book("Camara secreta"),
                new Book("Camara secreta"),
                new Book("Caliz fuego"),
                new Book("Caliz fuego"),
                new Book("Caliz fuego"),
                new Book("Caliz fuego"),
                new Book("Prisionero azkaban"),
                new Book("Prisionero azkaban"),
                new Book("Prisionero azkaban"),
                new Book("Prisionero azkaban"),
                new Book("Prisionero azkaban"),
                new Book("Orden fenix"),
                new Book("Orden fenix"),
                new Book("Orden fenix"),
                new Book("Orden fenix"),
        };

        cart.addItems(books);
        assertEquals(expectedResult, cart.calculateBestPrice(), 0.0f);
    }
}
