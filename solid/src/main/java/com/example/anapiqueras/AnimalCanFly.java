package com.example.anapiqueras;

public abstract class AnimalCanFly extends Animal {

    public AnimalCanFly(String name) {
        super(name);
    }

    public abstract int getFlightDistance();

    public void animalflightDistance() {
        System.out.println(getName() + " puede volar " + getFlightDistance() + " metros");
    }

}
