package com.anapiqueras;

import static com.anapiqueras.App.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
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
    public void checkIncreaseHourly() {
        // Arrange
        float extraHour = 0.5f;
        // Act
        float result = getIncreaseHourly();
        // Assert
        assertEquals(extraHour, result, 0);
    }

    @Test(expected = InputMismatchException.class)
    public void checkIsNotANumber() throws Exception {
        // Arrange
        final String testString = "dgd";
        provideInput(testString);
        App.readHours();
    }

    @Test
    public void checkOvertime() {
        // Arrange
        float hours = 50f;
        // Act
        float result = hours - getMinHoursWeek();
        // Assert
        assertEquals(result, calculateOverTime(hours),0);
    }

    @Test
    public void checkValidHours() {
        // Arrange
        float hour = 0.1f;
        // Act
        boolean result = isPositive(hour);
        // Assert
        assertEquals(result, true);
    }

    @Test
    public void checkCalculateOvertimeSalary() {
        // Arrange
        float hours= 50;
        float overtime=hours-getMinHoursWeek();
        // Act
        float overtimeSalary = overtime * (1 + getIncreaseHourly());
        float result = calculateOvertimeSalary(hours);
        // Assert
        assertEquals(overtimeSalary, result, 0);
    }

    @Test
    public void checkCalculateSalary() {
        // Arrange
        float hours = 50.0f;
        float hourly = getHourly();
        // Act
        float salary = (getMinHoursWeek() * hourly) + ((hours - getMinHoursWeek()) * (1 + getIncreaseHourly()));
        float result = calculateSalary(hours);
        // Assert
        assertEquals(salary, result, 0);
    }

    @Test
    public void testPrintSalary() {
        // Arrange
        float hours = 50;
        String expected = "Hours: 50.0\r\nHourly: 10.0\r\nOvertime: 10.0\r\nSalary: 415.0\r\n";
        // Act
        App.printSalary(hours);
        // Assert
        assertEquals(expected, getOutput());
    }
}
