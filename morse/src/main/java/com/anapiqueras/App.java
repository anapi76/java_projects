package com.anapiqueras;

import java.util.ArrayList;

public class App 
{
    public static void main( String[] args )
    {
        Morse morse=new Morse();
        morse.decodeMorse(0,new ArrayList<>());
    }
}
