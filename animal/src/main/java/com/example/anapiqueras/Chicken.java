package com.example.anapiqueras;

public class Chicken extends Animal{

    private final String SOUND="Cluck";

    public Chicken(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return SOUND;
    }

}
