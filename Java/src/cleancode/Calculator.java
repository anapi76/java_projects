package com.anapiqueras;

import java.util.function.BiFunction;

public class Calculator{

     public static void main(String[] args) {
        System.out.println(division(2,3));
    }

    public static float addition(float numberOne, float numberTwo) {
        return numberOne + numberTwo;
    }

    public static float substract(float numberOne, float numberTwo) {
        return numberOne - numberTwo;
    }

    public static float multiplication(float numberOne, float numberTwo) {
        return numberOne * numberTwo;
    }

    public static float division(float numberOne, float numberTwo){ 
        if (numberTwo != 0) {
            return numberOne / numberTwo;
        } else {
            System.out.println("Error: Cannot divide by zero.");
            return numberOne;
        }
    }

  /*   public static float op(float a, float b, String operation) {
        switch (operation) {

            case "d":
               
            default:
                System.out.println("Error: Invalid operation.");
                return a;
        }
    } */

/*     public static double calculator(float num) {
        float res = num;

        res = op(res, 5, "a");
        res = op(res, 3, "m");
        res = op(res, 2, "s");
        res = op(res, 4, "d");

        res = op(res, 10, "a");
        res = op(res, 2, "m");

        BiFunction<Float, Float, Float> custom = (a, b) -> {
            return a + b * 2F;
        };

        res = custom.apply(res, 5f);

        res = op(res, 3, "m");
        res = op(res, 8, "d");
        res = op(res, 2, "a");

        return res;
    } */
}
