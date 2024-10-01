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
    private static final LocalDate MIN_DATE = LocalDate.now().minusYears(100);
    private static final LocalDate MAX_DATE = LocalDate.now();

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
            System.err.println(e.getMessage());
        }
    }

    public static void readPerson() {
        for (int i = 0; i < people.length; i++) {
            people[i] = new Person(randomBirthdate(), randomGender());
        }
        printPeople(people);
    }

    public static void printPeople(Person[] people) {
        System.out.println("Adults: " + quantityAdults(people));
        System.out.println("Not adults: " + quantityNotAdults(people));
        System.out.println("Male adults: " + quantityMaleAdults(people));
        System.out.println("Female not adults: " + quantityFemaleNotAdults(people));
        System.out.println("Percentage adults: " + calculatePercentageAdults(people) + " %");
        System.out.println("Percentage female: " + calculatePercentageFemale(people) + " %");
    }

    public static LocalDate randomBirthdate() {
        Random random = new Random();
        long minDay = MIN_DATE.toEpochDay();
        long maxDay = MAX_DATE.toEpochDay();
        long randomDay = minDay + random.nextInt((int) (maxDay - minDay));
        return LocalDate.ofEpochDay(randomDay);
    }

    public static Gender randomGender() {
        Gender[] genders = Gender.values();
        Random random = new Random();
        int randomIndex = random.nextInt(genders.length);
        return genders[randomIndex];
    }

    public static int quantityAdults(Person[] people) {
        return (int) Arrays.stream(people).filter(Person::isAdult).count();
    }

    public static int quantityNotAdults(Person[] people) {
        return people.length - quantityAdults(people);
    }

    public static int quantityMaleAdults(Person[] people) {
        return (int) Arrays.stream(people).filter(p -> p.isAdult() && p.getGender() == Gender.MALE).count();

    }

    public static int quantityFemaleNotAdults(Person[] people) {
        return (int) Arrays.stream(people).filter(p -> !p.isAdult() && p.getGender() == Gender.FEMALE).count();
    }

    public static float calculatePercentageAdults(Person[] people) {
        return 100 * (float) quantityAdults(people) / people.length;
    }

    public static float calculatePercentageFemale(Person[] people) {
        float femalesCount = (int) Arrays.stream(people).filter(p -> p.getGender() == Gender.FEMALE).count();
        return 100 * femalesCount / people.length;
    }
}