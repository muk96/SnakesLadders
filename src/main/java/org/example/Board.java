package org.example;

import java.util.Map;

public class Board {
    private final int noOfSnakes;
    private final int noOfLadders;

    private final Map<Integer,Integer> snakePositions;
    private final Map<Integer,Integer> ladderPositions;

    public Board(int noOfSnakes, int noOfLadders,
                 Map<Integer, Integer> snakePositions,
                 Map<Integer, Integer> ladderPositions) {
        this.noOfSnakes = noOfSnakes;
        this.noOfLadders = noOfLadders;
        this.snakePositions = snakePositions;
        this.ladderPositions = ladderPositions;
    }

    public int getNoOfSnakes() {
        return noOfSnakes;
    }

    public int getNoOfLadders() {
        return noOfLadders;
    }

    public Map<Integer, Integer> getSnakePositions() {
        return snakePositions;
    }

    public Map<Integer, Integer> getLadderPositions() {
        return ladderPositions;
    }

}
