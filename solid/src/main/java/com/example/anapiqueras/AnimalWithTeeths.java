package com.example.anapiqueras;

public abstract class AnimalWithTeeths extends Animal {

    public AnimalWithTeeths(String name) {
        super(name);
    }

    public abstract int getTeeth();

    public void animalTeeths() {
        System.out.println(getName() + " tiene " + getTeeth() + " dientes");
    }
}
