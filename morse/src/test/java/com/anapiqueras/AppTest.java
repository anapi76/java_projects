package com.anapiqueras;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    Morse morse=new Morse();

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void checkConvertMorseToChar()
    {
        // Arrange
        String morseLetter = ".-";
        char letterExpected='A';
        // Act
        char letter = morse.convertMorseToChar(morseLetter);
        // Assert
        assertEquals(letterExpected,letter);
    }

    @Test
    public void checkConvertCharToMorse()
    {
        // Arrange
        String morseExpected = ".-";
        char letter='A';
        // Act
        String morseLetter = morse.convertCharToMorse(letter);
        // Assert
        assertEquals(morseExpected,morseLetter);
    }

    @Test
    public void checkConvertWordToMorse()
    {
        // Arrange
        String morseExpected = "----..-..-.--";
        String word="ONLY";
        // Act
        String morseWord = morse.convertWordToMorse(word);
        // Assert
        assertEquals(morseExpected,morseWord);
    }


}
