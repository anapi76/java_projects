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
            System.err.println(e);
        }
    }

    public static void readNumber() throws Exception {
        System.out.println("Write a number: ");
        try {
            int number = scanner.nextInt();
            if (isPositive(number)) {
                calculateNumbers(number);
            } else {
                System.out.println("Is not a positive number");
            }
        } catch (InputMismatchException e) {
            scanner.close();
            throw new InputMismatchException("Is not a integer");
        }
    }

    public static boolean numberIsPair(int number) {
        return (number % 2 == 0);
    }

    public static boolean isPositive(int number) {
        return (number > 0);
    }

    public static void calculateNumbers(int number) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = number; i >= 0; i -= 2) {
            result.add(i);
        }
        if (!numberIsPair(number))
            result.add(0);
        printNumbers(result);
    }

    public static void printNumbers(ArrayList<Integer> numbers) {
        for (int number : numbers) {
            System.out.println("Number: " + number);
        }
    }

}
