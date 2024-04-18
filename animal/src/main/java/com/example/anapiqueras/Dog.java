package com.example.anapiqueras;

public class Dog extends AnimalWithTeeths {

    private final String SOUND = "Woof! Woof!";
    private final int TEETHS = 30;

    public Dog(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return SOUND;
    }

    @Override
    public int getTeeth() {
        return TEETHS;
    }

}
