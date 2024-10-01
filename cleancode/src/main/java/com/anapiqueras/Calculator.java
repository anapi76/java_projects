package com.anapiqueras;;

public class Calculator {

    private final Operation operation;

    public Calculator() {
        this.operation = new Operation();
    }

    public float calculate(float number) {
        float result = number;
        result = operation.addition(result, 5);
        result = operation.multiplication(result, 3);
        result = operation.substract(result, 2);
        result = operation.division(result, 4);
        result = operation.addition(result, 10);
        result = operation.multiplication(result, 2);
        result = operation.addition(result, 10);
        result = operation.multiplication(result, 3);
        result = operation.division(result, 8);
        result = operation.addition(result, 2);
        return result;
    }
}
