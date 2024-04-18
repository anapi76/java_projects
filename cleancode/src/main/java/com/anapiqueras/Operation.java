package com.anapiqueras;

public class Operation {

    public float addition(float summandOne, float summandTwo) {
        return summandOne + summandTwo;
    }

    public float substract(float minuend, float subtrahend) {
        return minuend - subtrahend;
    }

    public float multiplication(float multiplying, float multiplier) {
        return multiplying * multiplier;
    }

    public float division(float dividend, float divisor) {
        int invalidDivisor = 0;
        if (divisor == invalidDivisor) {
            System.out.println("Error: Cannot divide by zero.");
            return dividend;
        }
        return dividend / divisor;
    }
}
