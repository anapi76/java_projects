package com.example.anapiqueras;

public class Duck extends AnimalCanFly {

    private final int FLIGHT_DISTANCE=5000;

    private final String SOUND = "Quack";

    public Duck(String name) {
        super(name);
    }

    @Override
    public int getFlightDistance() {
        return FLIGHT_DISTANCE;
    }

    @Override
    public String makeSound() {
        return SOUND;
    }

}
