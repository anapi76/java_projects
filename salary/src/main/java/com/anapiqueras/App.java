package com.anapiqueras;

import java.util.InputMismatchException;
import java.util.Scanner;

/* Desarrolle un algoritmo para el cálculo del salario de un trabajador. 
El importe liquidado (sueldo) depende de una tarifa o precio por hora establecida 
y de un condicionante sobre las horas trabajadas: si la cantidad de horas trabajadas
es mayor a 40 horas, la tarifa se incrementa en un 50% para las horas extras. 
Calcular el sueldo recibido por el trabajador en base las horas trabajadas y la tarifa. 
Utilice las instrucciones LEER HORASTRABAJADAS y LEER TARIFA al inicio del programa para cargar 
los valores en las variables HORASTRABAJADAS y TARIFA */

public class App {
    private static final float INCREASE_HOURLY = 0.5f;
    private final static float HOURLY = 10.0f;
    private static final float MIN_HOURS_WEEK = 40.0f;

    private static Scanner scanner = new Scanner(System.in);

    public static float getIncreaseHourly() {
        return INCREASE_HOURLY;
    }

    public static float getHourly() {
        return HOURLY;
    }

    public static float getMinHoursWeek() {
        return MIN_HOURS_WEEK;
    }

    public static void main(String[] args) throws Exception {
        try {
            readHours();
        } catch (InputMismatchException e) {
            System.err.println(e);
        }
    }

    public static void readHours() throws Exception {
        System.out.println("Write worked hours: ");
        try {
            float hours = scanner.nextFloat();
            if (isPositive(hours)) {
                printSalary(hours);
            } else {
                System.out.println("Is not a positive number");
            }
        } catch (InputMismatchException e) {
            scanner.close();
            throw new InputMismatchException("Is not a decimal number");
        }
    }

    public static boolean isPositive(float hour) {
        return (hour > 0);
    }

    public static float calculateOverTime(float hours) {
        float overtime = hours - MIN_HOURS_WEEK;
        if (hours < 40) {
            overtime = 0;
        }
        return overtime;
    }

    public static float calculateOvertimeSalary(float hours) {
        return calculateOverTime(hours) * (1 + getIncreaseHourly());
    }

    public static float calculateSalary(float hours) {
        float overtime = calculateOverTime(hours);
        float minHours = hours - overtime;
        return (minHours * HOURLY) + ((overtime) * (1 + INCREASE_HOURLY));
    }

    public static void printSalary(float hours) {
        System.out.println("Hours: " + hours);
        System.out.println("Hourly: " + HOURLY);
        System.out.println("Overtime: " + calculateOverTime(hours));
        System.out.println("Salary: " + calculateSalary(hours));
    }

}
