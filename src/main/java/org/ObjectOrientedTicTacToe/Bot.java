package org.ObjectOrientedTicTacToe;

import java.util.Random;

public class Bot extends Player{
    Bot() {
        this.setName("Bot");
        this.setPlayerSymbol('B');
    }
    @Override
    public int askForAMove(Board board) {
        int botMove;
        do {
            Random rand = new Random();
            botMove = rand.nextInt(0, 9);
        } while (!board.valid_move(botMove));
        return botMove;
    }
}
