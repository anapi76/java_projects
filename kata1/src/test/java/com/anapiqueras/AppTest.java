package com.anapiqueras;

import static com.anapiqueras.App.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void checkPrice() {
        assertEquals(8, getPriceBook());
    }

    @Test
    public void checkDiscountOneBook() {
        double[] discounts = getDiscounts();
        assertEquals(0.00, discounts[0], 0);
    }

    @Test
    public void checkDiscountTwoDifferentsBooks() {
        double[] discounts = getDiscounts();
        assertEquals(0.05, discounts[1], 0);
    }

    @Test
    public void checkDiscountThreeDifferentsBooks() {
        double[] discounts = getDiscounts();
        assertEquals(0.10, discounts[2], 0);
    }

    @Test
    public void checkDiscountFourDifferentsBooks() {
        double[] discounts = getDiscounts();
        assertEquals(0.20, discounts[3], 0);
    }

    @Test
    public void checkDiscountFiveDifferentsBooks() {
        double[] discounts = getDiscounts();
        assertEquals(0.25, discounts[4], 0);
    }

    @Test
    public void checkFiveDifferentsBooks() {
        String[] books = getBooks();
        assertEquals(5, books.length);
    }

    @Test
    public void checkGroupOfBooks() {
        int[] groupsList = { 1, 1, 1, 1, 1 };
        String[] bookList = { "book1", "book2", "book3", "book4", "book5" };
        int[] groups = createGroupsOfBooks(bookList);
        assertEquals(Arrays.toString(groupsList), Arrays.toString(groups));
    }

    @Test
    public void priceAnyBook() {
        int quantity = 0;
        assertEquals(quantity * 8, priceBooks(quantity,0), 0);
    }

    @Test
    public void priceOneBook() {
        int quantity = 1;
        assertEquals(quantity * 8, priceBooks(quantity,0), 0);
    }

    @Test
    public void priceMoreThanOneBooks() {
        int quantity = 10;
        assertEquals(quantity * 8, priceBooks(quantity,0), 0);
    }

    @Test
    public void priceTwoBooksDifferents() {
        int quantity = 2;
        assertEquals(quantity * 8 * (1 - 0.05), priceBooks(quantity, 0.05), 0);
    }

    @Test
    public void priceThreeBooksDifferents() {
        int quantity = 3;
        assertEquals(quantity * 8 * (1 - 0.1), priceBooks(quantity, 0.1), 0);
    }

    @Test
    public void priceFourBooksDifferents() {
        int quantity = 4;
        assertEquals(quantity * 8 * (1 - 0.20), priceBooks(quantity, 0.2), 0);
    }

    @Test
    public void priceFiveBooksDifferents() {
        int quantity = 5;
        assertEquals(quantity * 8 * (1 - 0.25), priceBooks(quantity, 0.25), 0);
    }

    @Test
      public void threeBooksTwoDifferentsPlusOne() {
        String[] list = { "book1", "book1", "book2" };
      assertEquals(8 + (2 * 8 * 0.95), calculatePriceBooks(list), 0);
      }

      @Test
     public void fiveBooksFourDifferentsPlusOne() {
        String[] list = { "book1", "book1", "book2","book3","book4" };
      assertEquals((4 * 8 * 0.80) + 8 , calculatePriceBooks(list), 0);
      } 
}
