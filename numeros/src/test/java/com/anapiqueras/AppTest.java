package com.anapiqueras;

import static com.anapiqueras.App.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.InputMismatchException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void testPrintNumbers() {
        // Arrange
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(2);
        numbers.add(0);
        String expected = "Number: 4\r\nNumber: 2\r\nNumber: 0\r\n";
        // Act
        App.printNumbers(numbers);
        // Assert
        assertEquals(expected, getOutput());
    }

    @Test(expected = InputMismatchException.class)
    public void checkIsNotANumber() throws Exception {
        // Arrange
        final String testString = "dgd";
        provideInput(testString);
        App.readNumber();
    }

    @Test
    public void CheckNumberIsPositive() {
        // Arrange
        int number = 10;
        // Act
        boolean result = isPositive(number);
        // Assert
        assertEquals(true,result);
    }

    @Test
    public void CheckNumberIsPair() {
        // Arrange
        int number = 10;
        // Act
        boolean result = numberIsPair(number);
        // Assert
        assertEquals(true, result);
    }

    @Test
    public void CheckNumberIsOdd() {
        // Arrange
        int number = 11;
        // Act
        boolean result = numberIsPair(number);
        // Assert
        assertEquals(false, result);
    }

}
