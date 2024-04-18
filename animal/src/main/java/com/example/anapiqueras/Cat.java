package com.example.anapiqueras;

public class Cat extends AnimalWithTeeths {

    private final String SOUND="Meaw";
    private final int TEETHS=24;

    public Cat(String name) {
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
