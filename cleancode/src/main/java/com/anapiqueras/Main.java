package com.anapiqueras;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        float result1=calculator.calculate(5f);
        float result2=calculator.calculate(10f);
        System.out.println("Result for number 5: "+result1+", result for number 10: "+result2);
    }
}
