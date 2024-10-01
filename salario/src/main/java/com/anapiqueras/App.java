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
    private static final float INCREASE_HOURLY = 1.5f;
    private final static float HOURLY = 10.0f;
    private static final float MIN_HOURS_WEEK = 40.0f;

    private static final Scanner SCANNER = new Scanner(System.in);

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
            System.err.println(e.getMessage());
        }
    }

    public static void readHours() throws Exception {
        System.out.println("Write worked hours: ");
        try {
            float hours = SCANNER.nextFloat();
            if (!isPositive(hours)) {
                System.out.println("Is not a positive number");
                return;
            }
            printSalary(hours);
        } catch (InputMismatchException e) {
            SCANNER.close();
            throw new InputMismatchException("Is not a decimal number");
        }
    }

    public static void printSalary(float hours) {
        System.out.println("Hours: " + hours);
        System.out.println("Hourly: " + HOURLY);
        System.out.println("Overtime: " + calculateOverTimeHours(hours));
        System.out.println("Salary: " + calculateSalary(hours));
    }

    public static boolean isPositive(float hour) {
        return (hour > 0);
    }

    public static float calculateOverTimeHours(float hours) {
        return (hours < MIN_HOURS_WEEK) ? 0 : hours - MIN_HOURS_WEEK;
    }

    public static float calculateOvertimeSalary(float hours) {
        float overtime = calculateOverTimeHours(hours);
        return (HOURLY * INCREASE_HOURLY) * overtime;
    }

    public static float calculateSalary(float hours) {
        float overtime = calculateOverTimeHours(hours);
        float minHours = hours - overtime;
        float salary = HOURLY * minHours;
        return salary + calculateOvertimeSalary(hours);
    }
}
