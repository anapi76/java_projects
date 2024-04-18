package com.anapiqueras;

import static com.anapiqueras.App.calculatePriceBooks;
import static com.anapiqueras.App.getDiscounts;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static com.anapiqueras.App.getPriceOneBook;

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
    public void checkPrice(){
        assertEquals(8,getPriceOneBook());
    }

    @Test
    public void checkDiscountTwoDifferentsBooks(){
        double[] discounts=getDiscounts();
        assertEquals(0.05,discounts[0],0);
    }

    @Test
    public void checkDiscountThreeDifferentsBooks(){
        double[] discounts=getDiscounts();
        assertEquals(0.10,discounts[1],0);
    }

    @Test
    public void checkDiscountFourDifferentsBooks(){
        double[] discounts=getDiscounts();
        assertEquals(0.20,discounts[2],0);
    }

    @Test
    public void checkDiscountFiveDifferentsBooks(){
        double[] discounts=getDiscounts();
        assertEquals(0.25,discounts[3],0);
    }

    @Test
    public void anyBook() {
        int[] list = { };
        assertEquals(0, calculatePriceBooks(list), 0);
    }

    @Test
    public void oneBook() {
        int[] list = { 0 };
        assertEquals(8, calculatePriceBooks(list), 0);
    }

    @Test
    public void twoBooksEquals() {
        int[] list = { 0, 0 };
        assertEquals(8 * 2, calculatePriceBooks(list), 0);
    }

    @Test
    public void twoBooksDifferents() {
        int[] list = { 0, 1 };
        assertEquals(8 * 2 * 0.95, calculatePriceBooks(list), 0);
    }

    @Test
    public void threeBooksEquals() {
        int[] list = { 0, 0, 0 };
        assertEquals(8 * 3, calculatePriceBooks(list), 0);
    }

    @Test
    public void threeBooksDifferents() {
        int[] list = { 0, 1, 2 };
        assertEquals(8 * 3 * 0.90, calculatePriceBooks(list), 0);
    }

    @Test
    public void threeBooksTwoDifferentsPlusOne() {
        int[] list = { 0, 1, 1 };
        assertEquals(8 + (2 * 8 * 0.95), calculatePriceBooks(list), 0);
    }
 
    @Test
    public void fourBooksEquals() {
        int[] list = { 0, 0, 0, 0 };
        assertEquals(8 * 4, calculatePriceBooks(list), 0);
    }

    @Test
    public void fourBooksDifferents() {
        int[] list = { 0, 1, 2, 3 };
        assertEquals(8 * 4 * 0.80, calculatePriceBooks(list), 0);
    }

    @Test
    public void fourBooksTwoDifferentsPlusTwoEquals() {
        int[] list = { 0, 1, 1, 1 };
        assertEquals((8 * 2) + (2 * 8 * 0.95), calculatePriceBooks(list), 0);
    }

    @Test
    public void fourBooksTwoDifferentsForTwo() {
        int[] list = { 0, 0, 1, 1 };
        assertEquals(2 * (2 * 8 * 0.95), calculatePriceBooks(list), 0);
    }

    @Test
    public void fourBooksThreeDifferentsPlusOne() {
        int[] list = { 0, 0, 1, 2 };
        assertEquals(8 + (3 * 8 * 0.90), calculatePriceBooks(list), 0);
    }

    @Test
    public void fiveBooksEquals() {
        int[] list = { 0, 0, 0, 0, 0 };
        assertEquals(8 * 5, calculatePriceBooks(list), 0);
    }

    @Test
    public void fiveBooksDifferents() {
        int[] list = { 0, 1, 2, 3, 4 };
        assertEquals(8 * 5 * 0.75, calculatePriceBooks(list), 0);
    }

    @Test
    public void fiveBooksTwoDifferentsPlusThreeEquals() {
        int[] list = { 0, 1, 1, 1, 1 };
        assertEquals((8 * 3) + (2 * 8 * 0.95), calculatePriceBooks(list), 0);
    }

    @Test
    public void fiveBooksThreeDifferentsPlusTwoEquals() {
        int[] list = { 0, 1, 2, 1, 1 };
        assertEquals((8 * 2) + (3 * 8 * 0.90), calculatePriceBooks(list), 0);
    }

    @Test
    public void fiveBooksFourDifferentsPlusOne() {
        int[] list = { 0, 1, 2, 3, 0 };
        assertEquals((4 * 8 * 0.80) + 8 , calculatePriceBooks(list), 0);
    }
    
    @Test
    public void fiveBooksTwoDifferentsForTwoPlusOne() {
        int[] list = { 0, 0, 1, 1, 1 };
        assertEquals(8 + (2 * (2 * 8 * 0.95)), calculatePriceBooks(list), 0);
    }

}
