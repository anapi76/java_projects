package com.anapiqueras;

public class App 
{
    public static void main(String[] args) {
        String word = "radar";
        System.out.println("Is \"" + word + "\" a palindrome? " + isPalindrome(word));
    }

    public static boolean isPalindrome(String word) {
        StringBuilder invertWord= new StringBuilder();
        for (int i = word.length() - 1; i >=0 ; i--) {
           invertWord.append(word.charAt(i));
        }
        return (word.equals(invertWord.toString()));
    }
}





