package org.example;

public class Player {
    private final String name;
    private int position = 0;

    static boolean hasWon = false;
    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
