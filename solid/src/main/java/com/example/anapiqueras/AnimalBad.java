package com.example.anapiqueras;

public class AnimalBad {
    private String name;

    public AnimalBad(String name) {
        this.name = name;
    }

    public String makeSound(String animalType) {
        switch (animalType) {
            case "cat" -> {
                return "Meaw";
            }
            case "dog" -> {
                return "Woof! Woof!";
            }
            case "chicken" -> {
                return "Cluck";
            }
            case "duck" -> {
                return "Quack";
            }
            default -> {
                return "This is not an animal";
            }
        }
    }

    public int flightDistance(String animalType) {
        switch (animalType) {
            case "cat" -> {
                return 0;
            }
            case "dog" -> {
                return 0;
            }
            case "chicken" -> {
                return 0;
            }
            case "duck" -> {
                return 5000;
            }
            default -> {
                return 0;
            }
        }
    }

    public int getNumberOfTeeths(String animalType) {
        switch (animalType) {
            case "cat" -> {
                return 24;
            }
            case "dog" -> {
                return 30;
            }
            case "chicken" -> {
                return 0;
            }
            case "duck" -> {
                return 0;
            }
            default -> {
                return 0;
            }
        }
    }

    public String getName() {
        return this.name;
    }

    public static void animalSound(String animalName, String type) {
        AnimalBad animal = new AnimalBad(animalName);
        String sound = animal.makeSound(type);
        String name = animal.getName();

        System.out.println("El sonido que hace " + name + " es " + sound);
    }

    public static void animalTeeths(String animalName, String type) {
        AnimalBad animal = new AnimalBad(animalName);
        int totalTeeth = animal.getNumberOfTeeths(type);
        String name = animal.getName();

        System.out.println(name + " tiene " + totalTeeth + " dientes");
    }

    public static void animalflightDistance(String animalName, String type) {
        AnimalBad animal = new AnimalBad(animalName);
        int flightMeters = animal.flightDistance(type);
        String name = animal.getName();

        System.out.println(name + " puede volar " + flightMeters + " metros");
    }
}
