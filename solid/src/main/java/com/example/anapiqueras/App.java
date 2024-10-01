package com.example.anapiqueras;

public class App {
    public static void main(String[] args) {
        Duck duck = new Duck("Donald");
        Cat cat = new Cat("Simba");
        Animal chicken=new Chicken("Pollito");
        chicken.animalSound();
        duck.animalSound();
        duck.animalflightDistance();
        cat.animalTeeths();
    }
}
