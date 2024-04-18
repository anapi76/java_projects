package com.anapiqueras;

import java.time.LocalDate;
import java.time.Period;

public class Person {
    private final int ADULT_AGE=18;
    private LocalDate age;
    private int gendre;//0--Female 1 -- Male

    public Person(LocalDate age, int gendre) {
        setAge(age);
        this.gendre = gendre;
    }

    public int getAge() {
        int years= 0;
        LocalDate currentDate = LocalDate.now();
        years=Period.between(this.age, currentDate).getYears();
        return years;
    }

    public void setAge(LocalDate age) {
        LocalDate minDate = LocalDate.now().minusYears(100);
        LocalDate currentDate = LocalDate.now();
        if (age.isBefore(minDate) || age.isAfter(currentDate)) {
            throw new IllegalArgumentException("Invalid birthdate");
        } else {
            this.age = age;
        }
    }

    public int getGendre() {
        return gendre;
    }

    public void setGendre(int gendre) {
        this.gendre = gendre;
    }

    public boolean isAdult() {
        boolean adult = getAge() >= ADULT_AGE;
        return adult;
    }

}
