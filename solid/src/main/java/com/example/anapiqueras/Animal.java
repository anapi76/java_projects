package com.example.anapiqueras;

public abstract class Animal {

    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract String makeSound();

    public void animalSound() {
        System.out.println("El sonido que hace " + name + " es " + makeSound());
    }

}
