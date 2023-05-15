package org.example;

public class Dice {
    public int roll(){
        return ((int)((Math.random())*1000))%6 + 1;
    }
}
