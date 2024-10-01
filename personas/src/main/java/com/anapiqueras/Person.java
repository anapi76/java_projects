package com.anapiqueras;

import java.time.LocalDate;
import java.time.Period;

public class Person {
    private LocalDate age;
    private Gender gender;

    public Person(LocalDate age, Gender gender) {
        setAge(age);
        this.gender = gender;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public boolean isAdult() {
        int ADULT_AGE = 18;
        return getAge() >= ADULT_AGE;
    }

}
