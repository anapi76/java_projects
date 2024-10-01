package com.anapiqueras;

import java.util.ArrayList;
import java.util.List;

public class App {
    private final static int MIN = 1;
    private final static int MAX = 100;
    private final static int OPERATIONBY3 = 3;
    private final static int OPERATIONBY5 = 5;
    private final static String FIZZ = "Fizz";
    private final static String BUZZ = "Buzz";

    public static int getMinValue() {
        return MIN;
    }

    public static int getMaxValue() {
        return MAX;
    }

    public static int getThree() {
        return OPERATIONBY3;
    }

    public static int getFive() {
        return OPERATIONBY5;
    }

    public static String getFizz() {
        return FIZZ;
    }

    public static String getBuzz() {
        return BUZZ;
    }


    public static void main(String[] args) {
        System.out.println(fizzBuzz());
    }

    public static String fizzBuzz() {
        List<String> result = new ArrayList();
        for (int i = MIN; i <= MAX; i++) {
            result.add(checkNumber(i));
        }
        return String.join(" ", result);
    }

    public static String checkNumber(int num) {
        StringBuilder result = new StringBuilder();
        if (isMultipleOf(num, OPERATIONBY3) && isMultipleOf(num, OPERATIONBY5)) {
            result.append("FizzBuzz");
        } else if (isMultipleOf(num, OPERATIONBY3)) {
            result.append(FIZZ);
        } else if (isMultipleOf(num, OPERATIONBY5)) {
            result.append(BUZZ);
        }// If neither "Fizz" nor "Buzz" were added, append the number
        if (result.length() == 0) {
            result.append(num); // Corrected: append instead of append
        }
        return result.toString();
    }

    private static boolean isMultipleOf(int number, int divisor) {
        return number % divisor == 0;
    }
}