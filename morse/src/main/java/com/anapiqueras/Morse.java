package com.anapiqueras;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Morse {

    private HashMap<String, Character> morse = new HashMap<>();
    private HashMap<String, String> words = new HashMap<>();
    private String sentenceMorse = "--.--.---.......-.---.-.-.-..-.....--..-....-.-----..-";
    ArrayList<String> wordsFound = new ArrayList<>();
    
    private String wordSentence = "";
    int endIndex = 0;

    public Morse() {
        morse = new HashMap<>(morseCode());
        words = new HashMap<>(fileToArray());
    }

    public HashMap<String, Character> morseCode() {
        morse = new HashMap<>();
        morse.put(".-", 'A');
        morse.put("-...", 'B');
        morse.put("-.-.", 'C');
        morse.put("-..", 'D');
        morse.put(".", 'E');
        morse.put("..-.", 'F');
        morse.put("--.", 'G');
        morse.put("....", 'H');
        morse.put("..", 'I');
        morse.put(".---", 'J');
        morse.put("-.-", 'K');
        morse.put(".-..", 'L');
        morse.put("--", 'M');
        morse.put("-.", 'N');
        morse.put("---", 'O');
        morse.put(".--.", 'P');
        morse.put("--.-", 'Q');
        morse.put(".-.", 'R');
        morse.put("...", 'S');
        morse.put("-", 'T');
        morse.put("..-", 'U');
        morse.put("...-", 'V');
        morse.put(".--", 'W');
        morse.put("-..-", 'X');
        morse.put("-.--", 'Y');
        morse.put("--..", 'Z');

        return morse;
    }

    public HashMap<String, String> fileToArray() {
        String pathWords = "C:\\Users\\abpj7\\Documents\\FCT_sopra\\ejercicios\\morse\\words4.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(pathWords))) {
            String line;

            while ((line = br.readLine()) != null) {
                line = line.toUpperCase().trim();
                StringBuilder morseWord = new StringBuilder();

                for (char character : line.toCharArray()) {
                    morseWord.append(convertCharToMorse(character));
                }
                words.put(line, morseWord.toString());
            }
            return words;
            // System.out.println(words.get("ONLY"));
        } catch (IOException e) {
            System.err.println("Error to read the file: " + e.getMessage());
        }
        return words;
    }

    public char convertMorseToChar(String morseLetter) {
        return morse.getOrDefault(morseLetter, '\0');
    }

    public String convertCharToMorse(char letter) {
        String findKey = "";
        for (Entry<String, Character> entry : morse.entrySet()) {
            if (entry.getValue() == letter) {
                return entry.getKey();
            }
        }
        return findKey;
    }

    public String convertWordToMorse(String word) {
        word = word.toUpperCase();
        StringBuilder morseWord = new StringBuilder();
        for (char character : word.toCharArray()) {
            morseWord.append(convertCharToMorse(character));
        }
        return morseWord.toString();
    }

    public void decodeMorse(int beginIndex,ArrayList<String> wordsFound) {
        if (beginIndex >= sentenceMorse.length()) {
            System.out.println(wordsFound);
            return;
        }
        for (Entry<String, String> entry : words.entrySet()) {
            String word = entry.getKey();
            String morseWord = entry.getValue();

            endIndex = beginIndex + morseWord.length();
            if (endIndex <= sentenceMorse.length()) {
                wordSentence = sentenceMorse.substring(beginIndex, endIndex);
                if (wordSentence.equals(morseWord)) {
                    ArrayList<String> newWordsFound = new ArrayList<>(wordsFound);
                    newWordsFound.add(word);
                    decodeMorse(endIndex,newWordsFound);
                }
            }
        }
    }
}

