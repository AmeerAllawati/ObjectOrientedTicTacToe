package org.ObjectOrientedTicTacToe;

import java.util.Scanner;

public class Player {
    private String name;
    private Symbol playerSymbol = new Symbol();
    private static int playerNumber = 0;
    private boolean inTurn;

    Player() {
        this.playerNumber++;
    }
    Player(boolean loaded) {
        this.playerNumber++;

        if (loaded == false) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Player " + playerNumber + " please enter your name: ");
            this.name = sc.nextLine();
            System.out.print(name + " please enter your symbol: ");
            char inputSymbol = sc.nextLine().charAt(0);
            playerSymbol.setSymbol(inputSymbol);
        }
    }

    public void copyAPlayer(Player loadedPlayer) {
        this.name = loadedPlayer.name;
        this.playerSymbol.setSymbol(loadedPlayer.getPlayerSymbol().getSymbol());
        this.inTurn = loadedPlayer.inTurn;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getPlayerSymbol() {
        return playerSymbol;
    }

    public int askForAMove(Board board){
        Scanner s = new Scanner(System.in);
        int move;

        do {
            System.out.print(this.name + " please enter your move: ");
            move = s.nextInt();
            s.nextLine();
        } while (!board.valid_move(move));

        return move;
    }


    public boolean isInTurn() {
        return inTurn;
    }

    public void setInTurn(boolean inTurn) {
        this.inTurn = inTurn;
    }
}
