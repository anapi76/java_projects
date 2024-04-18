package com.anapiqueras;

import java.util.Arrays;

public class App {
    private static final int PRICEONEBOOK = 8;
    private static final double[] DISCOUNTS = { 0.05, 0.10, 0.20, 0.25 };

    public static int getPriceOneBook(){return PRICEONEBOOK;}
    public static double[] getDiscounts(){return DISCOUNTS;}

    public static void main(String[] args) {
        /*
         * int[] zero = {};
         * int[] oneBook = { 1 };
         * int[] twoBooks = { 1, 1 };
         * int[] twoBooksDifferents = { 1, 2 };
         * int[] threeBooks = { 1, 1, 1 };
         * int[] threeBooksDifferents = { 1, 2, 3 };
         * int[] fourBooksDifferents = { 1, 2, 3, 4 };
         * int[] fiveBooksDifferents = { 1, 2, 3, 4, 5 };
         * int[] list1 = { 1, 1, 2, 1 };
         */
        //int[] list = { 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 4, 5 };
        int[] list = {4};


        System.out.println(calculatePriceBooks(list));
        int[] basquet = createBasquets(list);
       /*  Basket b = new Basket();
        try {
            Book bo = new Book("book1", 1.0);
            b.addBook(bo);
        } catch (NullNameException nnx) {
            System.err.println(nnx);
        } catch (BasketFullException bfx) {
            System.err.println(bfx);
        } */

        System.out.println(Arrays.toString(basquet));
    }

    public static double calculatePriceBooks(int[] list) {
        double result = 0;
        int[] basquet = {};
        int difference = 0;
        basquet = createBasquets(list);
        if (basquet.length == 1) {
            result = priceBooksEquals(list.length);
        }
        if (basquet.length == 2) {
            difference = basquet[0] - basquet[1];
            if (difference == 0) {
                result = priceBooksEquals(list.length);
            } else if (difference > 0) {
                result = priceBooksDifferents(basquet[1] * 2, DISCOUNTS[1]) + priceBooksEquals(difference);
            }
        }
        if (basquet.length == 3) {
            result = priceBooksEquals(list.length);

        }
        if (basquet.length == 4) {
            result = priceBooksEquals(list.length);

        }
        if (list.length == 5) {
            result = priceBooksEquals(list.length);
        }

        return result;
    }

    public static int[] createBasquets(int[] list) {
        int[] books = new int[5];
        for (int i = 0; i <= list.length - 1; i++) {
            books[list[i] - 1]++;
        }
        return books;
    }

    public static double priceBooksEquals(int quantity) {
        return quantity * PRICEONEBOOK;
    }

    public static double priceBooksDifferents(int quantity, double discount) {
        return quantity * PRICEONEBOOK * (1 - discount);
    }
}
