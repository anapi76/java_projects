package com.anapiqueras;

import static com.anapiqueras.App.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        assertEquals("1", checkNumber(1));
    }

    @Test
    public void testMultipleThreeThenFizz() {
        assertEquals("Fizz", checkNumber(99));
    }

    @Test
    public void testMultipleFiveThenBuzz() {
        assertEquals("Buzz", checkNumber(100));
    }

    @Test
    public void testMultipleFiveThreeThenFizzBuzz() {
        assertEquals("FizzBuzz", checkNumber(90));
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








}
