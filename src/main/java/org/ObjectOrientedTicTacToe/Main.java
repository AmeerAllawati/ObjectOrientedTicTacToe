package org.ObjectOrientedTicTacToe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileManager gameFile = new FileManager();
        Board mainBoard = new Board();
        Player player1;
        Player player2;
        Player playerInTurn;

        if (gameFile.gameExists()) {
            player1 = new Player();
            player2 = new Player();
            gameFile.loadGameState(mainBoard, player1, player2);
            if (player1.isInTurn()) {
                playerInTurn = player1;
            } else {
                playerInTurn = player2;
            }
        } else {
            System.out.println("Do you want to play against a bot? ");
            Scanner sc = new Scanner(System.in);
            String playingAgainstBot = sc.nextLine();
            player1 = new Player(false);
            if(playingAgainstBot.contains("yes")) {
                player2 = new Bot();
                player2.setBot(true);
            } else {
                player2 = new Player(false);
            }

            playerInTurn = player1;
        }



        while(!mainBoard.gameEnded(player1, player2)) {
            mainBoard.print_board();
            int move = playerInTurn.askForAMove(mainBoard);
            mainBoard.setAMove(move, playerInTurn);

            if(playerInTurn == player1) {
                playerInTurn = player2;
                player1.setInTurn(false);
                player2.setInTurn(true);
            } else {
                playerInTurn = player1;
                player1.setInTurn(true);
                player2.setInTurn(false);
            }

            gameFile.saveGameState(mainBoard, player1, player2);
        }
    }
}