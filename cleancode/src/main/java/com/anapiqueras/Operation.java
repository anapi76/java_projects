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
        if (checkDivision(divisor)) {
            return dividend;
        }
        return dividend / divisor;
    }

    private boolean checkDivision(float divisor) {
        return divisor == 0;
    }
}
