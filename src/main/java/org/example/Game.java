package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
    private Board board;
    private Dice dice;
    private int noOfPlayers;
    static Scanner scanner;

    private Player[] players;

    void initializeBoard(){
        System.out.println("How many snakes do you want?");
        int noOfSnakes = scanner.nextInt();
        System.out.println("Enter head and tail positions for each snake. The values should be distinct and between 0-100");
        Map<Integer,Integer> snakeMap = new HashMap<>();
        while(noOfSnakes-- > 0){
            int head = scanner.nextInt();
            int tail = scanner.nextInt();

            snakeMap.put(head,tail);
        }


        System.out.println("How many ladders do you want?");
        int noOfLadders = scanner.nextInt();
        System.out.println("Enter start and end positions for each ladder. The values should be distinct and between 0-100");
        Map<Integer,Integer> ladderMap = new HashMap<>();
        while(noOfLadders-- > 0){
            int head = scanner.nextInt();
            int tail = scanner.nextInt();

            ladderMap.put(head,tail);
        }

        board = new Board(noOfSnakes, noOfLadders, snakeMap, ladderMap);
    }

    void registerPlayers(){
        System.out.println("How many players are playing?");
        noOfPlayers = scanner.nextInt();

        System.out.println("Enter name of players");
        players = new Player[noOfPlayers];

        int val = 0;
        for(int i=0; i<noOfPlayers; i++){
            players[val++] = new Player(scanner.next());
        }
    }

    void start(){
        dice = new Dice();
        int turn = 0;

        while(!Player.hasWon){
            System.out.println("Player " + (turn + 1) +" is rolling the dice.");
            int val = dice.roll();
            System.out.println("Dice roll : " + val);

            int currentPosition = players[turn].getPosition();
            //NEED TO HANDLE SNAKES, LADDERS
            currentPosition += val;
            if(board.getSnakePositions().containsKey(currentPosition)){
                currentPosition = board.getSnakePositions().get(currentPosition);
                players[turn].setPosition(currentPosition);
            }
            else if(board.getLadderPositions().containsKey(currentPosition)){
                currentPosition = board.getLadderPositions().get(currentPosition);
                players[turn].setPosition(currentPosition);
            }
            else {
                if (currentPosition <= 100) {
                    players[turn].setPosition(currentPosition);
                }
                else if(val == 6){
                    continue;
                }
            }

            if (players[turn].getPosition() == 100) {
                System.out.println("Player " + (turn + 1) + " has won the game!");
                Player.hasWon = true;
            }

            turn = (turn+1)%noOfPlayers;
        }
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        Game game = new Game();

        game.initializeBoard();
        game.registerPlayers();
        game.start();
    }
}
