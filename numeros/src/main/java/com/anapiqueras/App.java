/*Escriba un algoritmo que lea un número entero y determine si es par o impar.
Si es par, que escriba todos los pares de manera descendiente desde sí mismo y hasta el cero.
Si es impar, que escriba todos los impares de manera descendiente desde si sí mismo hasta el uno.
Utilice la instrucción LEER NUMERO al inicio del programa para cargar un número en la variable NUMERO.*/
package com.anapiqueras;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        try {
            readNumber();
        } catch (InputMismatchException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void readNumber() throws Exception {
        System.out.println("Write a number: ");
        try {
            int number = scanner.nextInt();
            if (!isPositive(number)) {
                System.out.println("Is not a positive number");
                return;
            }
            calculateNumbers(number);
        } catch (InputMismatchException e) {
            scanner.close();
            throw new InputMismatchException("Is not a integer");
        }
    }

    public static void calculateNumbers(int number) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int lowerLimit = numberIsPair(number) ? 0 : 1;
        for (int i = number; i >= lowerLimit; i -= 2) {
            result.add(i);
        }
        printNumbers(result);
    }

    public static void printNumbers(ArrayList<Integer> numbers) {
        System.out.print("Results: "+ numbers.toString());
    }

    public static boolean numberIsPair(int number) {
        return (number % 2 == 0);
    }

    public static boolean isPositive(int number) {
        return (number > 0);
    }
}
