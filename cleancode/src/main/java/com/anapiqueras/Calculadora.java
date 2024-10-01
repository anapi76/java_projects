package cleancode;

import java.util.function.BiFunction;

public class Calculadora {
    public static float op(float a, float b, String operation) {
        switch (operation) {
            case "a":
                return a + b;
            case "s":
                return a - b;
            case "m":
                return a * b;
            case "d":
                if (b != 0) {
                    return a / b;
                } else {
                    System.out.println("Error: Cannot divide by zero.");
                    return a;
                }
            default:
                System.out.println("Error: Invalid operation.");
                return a;
        }
    }

    public static double calc(float num) {
        float res = num;

        res = op(res, 5, "a");
        res = op(res, 3, "m");
        res = op(res, 2, "s");
        res = op(res, 4, "d");

        res = op(res, 10, "a");
        res = op(res, 2, "m");

        BiFunction<Float, Float, Float> custom = (a, b) -> { return a + b * 2F; };

        res = custom.apply(res, 5f);

        res = op(res, 3, "m");
        res = op(res, 8, "d");
        res = op(res, 2, "a");

        return res;
    }
}
