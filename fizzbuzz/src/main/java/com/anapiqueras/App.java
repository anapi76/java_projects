package com.anapiqueras;

/* - Write a program that prints one line for each number from 1 to 100
- Usually just print the number itself.
- For multiples of three print Fizz instead of the number
- For the multiples of five print Buzz instead of the number
- For numbers which are multiples of both three and five print FizzBuzz instead of the number */

public class App {
    private final static int MIN=1;
    private final static int MAX=100;
    private final static int THREE = 3;
    private final static int FIVE = 5;
    private final static String FIZZ="Fizz";
    private final static String BUZZ="Buzz";
    private final static String FIZZBUZZ="FizzBuzz";

    public static int getMinValue(){return MIN;}
    public static int getMaxValue(){return MAX;}
    public static int getThree(){return THREE;}
    public static int getFive(){return FIVE;}
    public static String getFizz(){return FIZZ;}
    public static String getBuzz(){return BUZZ;}
    public static String getFizzBuzz(){return FIZZBUZZ;}


    public static void main(String[] args) {
            calculateMultiples();
    }

    public static void calculateMultiples(){
        String num;
        for (int i = MIN; i <= MAX; i++) {
            num = fizzBuzz(i);
            System.out.println(num);
        }
    }

    public static String fizzBuzz(int num) {
        boolean isMultipleFive = num % FIVE == 0;
        boolean isMultipleThree = num % THREE == 0;
        boolean isMultiple = isMultipleThree && isMultipleFive;
      
        String result = Integer.toString(num);
        if (isMultiple) {
            result = FIZZBUZZ;
        } else if (isMultipleThree) {
            result = FIZZ;
        } else if (isMultipleFive) {
            result = BUZZ;
        }
        return result;
    }
}