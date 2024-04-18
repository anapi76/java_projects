package com.anapiqueras;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import static com.anapiqueras.App.fizzBuzz;
import static com.anapiqueras.App.getMinValue;
import static com.anapiqueras.App.getMaxValue;
import static com.anapiqueras.App.getThree;
import static com.anapiqueras.App.getFive;
import static com.anapiqueras.App.getFizz;
import static com.anapiqueras.App.getBuzz;
import static com.anapiqueras.App.getFizzBuzz;

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
    public void testIsNotMultiple() {
        assertEquals("1", fizzBuzz(1));
    }

    @Test
    public void testMultipleThreeThenFizz() {
        assertEquals("Fizz", fizzBuzz(99));
    }

    @Test
    public void testMultipleFiveThenBuzz() {
        assertEquals("Buzz", fizzBuzz(100));
    }

    @Test
    public void testMultipleFiveThreeThenFizzBuzz() {
        assertEquals("FizzBuzz", fizzBuzz(90));
    }

    @Test
    public void checkMinValue() {
        assertEquals(1, getMinValue());
    }

    @Test
    public void checkMaxValue() {
        assertEquals(100, getMaxValue());
    }

    @Test
    public void checkMultipleThreeValue() {
        assertEquals(3, getThree());
    }

    @Test
    public void checkMultipleFiveValue() {
        assertEquals(5, getFive());
    }

    @Test
    public void checkFizzValue() {
        assertEquals("Fizz", getFizz());
    }

    @Test
    public void checkBuzzValue() {
        assertEquals("Buzz", getBuzz());
    }

    @Test
    public void checkFizzBuzzValue() {
        assertEquals("FizzBuzz", getFizzBuzz());
    }







}
