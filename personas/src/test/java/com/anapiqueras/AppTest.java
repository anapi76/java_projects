package com.anapiqueras;

import static com.anapiqueras.App.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDate;

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
    public void checkNumberOfPerson() {
        // Arrange
        int numberOfPerson = 50;
        // Act
        int result = getPeople().length;
        // Assert
        assertEquals(numberOfPerson, result);
    }

    @Test
    public void testPrint() {
        // Arrange
        LocalDate date1 = LocalDate.now().minusYears(18);
        Person person1 = new Person(date1, Gender.MALE);
        LocalDate date2 = LocalDate.now().minusYears(10);
        Person person2 = new Person(date2, Gender.FEMALE);
        LocalDate date3 = LocalDate.now().minusYears(30);
        Person person3 = new Person(date3, Gender.FEMALE);
        Person[] people = { person1, person2, person3 };
        String expected = "Adults: 2\r\nNot adults: 1\r\nMale adults: 1\r\nFemale not adults: 1\r\nPercentage adults: 66.666664 %\r\nPercentage female: 66.666664 %\r\n";
        // Act
        App.printPeople(people);
        // Assert
        assertEquals(expected, getOutput());
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkAgeException() throws Exception {
        // Arrange
        LocalDate date = LocalDate.now().plusYears(5);
        Person person = new Person(date, Gender.FEMALE);
        // Act
        String result = Integer.toString(person.getAge());
        // Assert
        provideInput(result);
        App.readPerson();
    }

    @Test
    public void checkRandomBirthdate() {
        // Arrange
        LocalDate minDate = getMinDate();
        LocalDate maxDate = getMaxDate();
        // Act
        LocalDate result = randomBirthdate();
        // Assert
        assertTrue(result.isAfter(minDate) && result.isBefore(maxDate));
    }

    @Test
    public void checkRandomGendre() {
        // Arrange
        // Act
        Gender result = randomGender();
        // Assert
        assertTrue(result == Gender.MALE || result == Gender.FEMALE);
    }

    @Test
    public void checkValidAge() {
        // Arrange
        LocalDate date = LocalDate.now().minusYears(1);
        int ageExpected = 1;
        Person person = new Person(date, Gender.FEMALE);
        // Act
        int result = person.getAge();
        // Assert
        assertEquals(ageExpected, result);
    }

    @Test
    public void checkIsAdult() {
        // Arrange
        LocalDate date = LocalDate.now().minusYears(18);
        Person person = new Person(date, Gender.FEMALE);
        // Act
        boolean result = person.isAdult();
        // Assert
        assertEquals(true, result);
    }

    @Test
    public void checkIsNotAdult() {
        // Arrange
        LocalDate date = LocalDate.now().minusYears(10);
        Person person = new Person(date, Gender.FEMALE);
        // Act
        boolean result = person.isAdult();
        // Assert
        assertEquals(false, result);
    }

    @Test
    public void checkQuantityAdults() {
        // Arrange
        LocalDate date1 = LocalDate.now().minusYears(18);
        Person person1 = new Person(date1, Gender.FEMALE);
        LocalDate date2 = LocalDate.now().minusYears(10);
        Person person2 = new Person(date2, Gender.FEMALE);
        LocalDate date3 = LocalDate.now().minusYears(30);
        Person person3 = new Person(date3, Gender.FEMALE);
        Person[] people = { person1, person2, person3 };
        int quantity = 2;
        // Act
        int result = quantityAdults(people);
        // Assert
        assertEquals(quantity, result);
    }

    @Test
    public void checkQuantityNotAdults() {
        // Arrange
        LocalDate date1 = LocalDate.now().minusYears(18);
        Person person1 = new Person(date1, Gender.FEMALE);
        LocalDate date2 = LocalDate.now().minusYears(10);
        Person person2 = new Person(date2, Gender.FEMALE);
        LocalDate date3 = LocalDate.now().minusYears(17);
        Person person3 = new Person(date3, Gender.FEMALE);
        Person[] people = { person1, person2, person3 };
        int quantity = 2;
        // Act
        int result = quantityNotAdults(people);
        // Assert
        assertEquals(quantity, result);
    }

    @Test
    public void checkQuantityMaleAdults() {
        // Arrange
        LocalDate date1 = LocalDate.now().minusYears(18);
        Person person1 = new Person(date1, Gender.MALE);
        LocalDate date2 = LocalDate.now().minusYears(25);
        Person person2 = new Person(date2, Gender.FEMALE);
        LocalDate date3 = LocalDate.now().minusYears(17);
        Person person3 = new Person(date3, Gender.MALE);
        Person[] people = { person1, person2, person3 };
        int quantity = 1;
        // Act
        int result = quantityMaleAdults(people);
        // Assert
        assertEquals(quantity, result);
    }

    @Test
    public void checkQuantityFemaleNotAdults() {
        // Arrange
        LocalDate date1 = LocalDate.now().minusYears(18);
        Person person1 = new Person(date1, Gender.FEMALE);
        LocalDate date2 = LocalDate.now().minusYears(25);
        Person person2 = new Person(date2, Gender.MALE);
        LocalDate date3 = LocalDate.now().minusYears(17);
        Person person3 = new Person(date3, Gender.FEMALE);
        Person[] people = { person1, person2, person3 };
        int quantity = 1;
        // Act
        int result = quantityFemaleNotAdults(people);
        // Assert
        assertEquals(quantity, result);
    }

    @Test
    public void checkCalculatePercentageAdults() {
        // Arrange
        LocalDate date1 = LocalDate.now().minusYears(18);
        Person person1 = new Person(date1, Gender.FEMALE);
        LocalDate date2 = LocalDate.now().minusYears(25);
        Person person2 = new Person(date2, Gender.FEMALE);
        LocalDate date3 = LocalDate.now().minusYears(17);
        Person person3 = new Person(date3, Gender.FEMALE);
        Person[] people = { person1, person2, person3 };
        float quantity = (100 * (float) quantityAdults(people)) / people.length;
        // Act
        float result = calculatePercentageAdults(people);
        // Assert
        assertEquals(quantity, result, 0);
    }

    @Test
    public void checkCalculatePercentageFemale() {
        // Arrange
        LocalDate date1 = LocalDate.now().minusYears(18);
        Person person1 = new Person(date1, Gender.MALE);
        LocalDate date2 = LocalDate.now().minusYears(25);
        Person person2 = new Person(date2, Gender.FEMALE);
        LocalDate date3 = LocalDate.now().minusYears(17);
        Person person3 = new Person(date3, Gender.MALE);
        Person[] people = { person1, person2, person3 };
        float quantity = (100 * 1.0f) / people.length;
        // Act
        float result = calculatePercentageFemale(people);
        // Assert
        assertEquals(quantity, result, 0);
    }

}
