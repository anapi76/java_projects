package com.anapiqueras;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

/* Escriba un algoritmo que visualice una clasificación de 50 personas según edad y sexo. Deberá mostrar los siguientes resultados:
a. Cantidad de personas mayores de edad (18 años o más).
b. Cantidad de personas menores de edad.
c. Cantidad de personas masculinas mayores de edad.
d. Cantidad de personas femeninas menores de edad.
e. Porcentaje que representan las personas mayores de edad respecto al total de personas.
f. Porcentaje que representan las mujeres respecto al total de personas.
Utilice la instrucción LEER PERSONAS al inicio del programa para cargar los datos de las 50 personas en un variable, PERSONAS, que actúa como un vector de 50 posiciones.
Cada elemento de PERSONAS es de un tipo estructurado que dispone dos campos:
SEXO y EDAD. */

public class App {
    private static Person[] people = new Person[50];
    private static LocalDate MIN_DATE = LocalDate.now().minusYears(100);
    private static LocalDate MAX_DATE = LocalDate.now();

    public static Person[] getPeople() {
        return people;
    }

    public static LocalDate getMinDate() {
        return MIN_DATE;
    }

    public static LocalDate getMaxDate() {
        return MAX_DATE;
    }

    public static void main(String[] args) {
        try {
            readPerson();
        } catch (IllegalArgumentException e) {
            System.err.println(e);
        }
    }

    public static void readPerson() {
        for (int i = 0; i < people.length; i++) {
            people[i] = new Person(randomBirthdate(), randomGendre());
        }
        printPeople(people);

        /*
         * IntStream.range(0, people.length)
         * .forEach(i -> {
         * Person person = new Person(randomBirthdate(), randomGendre());
         * people[i] = person;
         * });
         */
    }

    public static LocalDate randomBirthdate() {
        Random random = new Random();
        long minDay = MIN_DATE.toEpochDay();
        long maxDay = MAX_DATE.toEpochDay();
        long randomDay = minDay + random.nextInt((int) (maxDay - minDay));

        LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
        return randomBirthDate;
    }

    public static int randomGendre() {
        Random random = new Random();
        int randomGendre = random.nextInt(2);
        return randomGendre;
    }

    public static int quantityAdults(Person[] people) {
        return (int) Arrays.stream(people).filter(p -> p.isAdult()).count();
    }

    public static int quantityNotAdults(Person[] people) {
        return people.length - quantityAdults(people);
    }

    public static int quantityMaleAdults(Person[] people) {
        return (int) Arrays.stream(people).filter(p -> p.isAdult() && p.getGendre() == 1).count();

    }

    public static int quantityFemaleNotAdults(Person[] people) {
        return (int) Arrays.stream(people).filter(p -> !p.isAdult() && p.getGendre() == 0).count();
    }

    public static float calculatePercentageAdults(Person[] people) {
        return 100 * (float) quantityAdults(people) / people.length;
    }

    public static float calculatePercentageFemale(Person[] people) {
        float quantityFemales = (int) Arrays.stream(people).filter(p -> p.getGendre() == 0).count();
        float percentage = 100 * quantityFemales / people.length;
        return percentage;
    }

    public static void printPeople(Person[] people) {
        System.out.println("Adults: " + quantityAdults(people));
        System.out.println("Not adults: " + quantityNotAdults(people));
        System.out.println("Male adults: " + quantityMaleAdults(people));
        System.out.println("Female not adults: " + quantityFemaleNotAdults(people));
        System.out.println("Percentage adults: " + calculatePercentageAdults(people) + " %");
        System.out.println("Percentage female: " + calculatePercentageFemale(people) + " %");
    }

}