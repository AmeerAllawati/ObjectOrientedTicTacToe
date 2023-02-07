package org.ObjectOrientedTicTacToe;

public class Board {
    private char[][] board = { { '1', '2', '3' }, { '4', '5', '6' }, { '7', '8', '9' } };

    public void copyABoard(Board loadedBoard) {
        this.board = loadedBoard.board.clone();
    }

    public void setAMove(int place, Player player) {
        int row_index = (int) Math.ceil(((double)place)/3) - 1;
        int column_index = ((place-1)%3) ;

        board[row_index][column_index] = player.getPlayerSymbol().getSymbol();
    }

    public void print_board() {
        for (int i = 0; i < board.length; ++i) {
            System.out.println(board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i != board.length - 1) {
                System.out.println("---------");
            }
        }

    }

    public boolean valid_move(int place) {
        int row_index = (int) Math.ceil(((double)place)/3) - 1;
        int column_index = ((place-1)%3);

        return board[row_index][column_index] ==  Integer.toString(place).charAt(0);
    }

    public boolean boardFull() {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == '1' || board[i][j] == '2' || board[i][j] == '3' || board[i][j] == '4'
                        || board[i][j] == '5' || board[i][j] == '6' || board[i][j] == '7' || board[i][j] == '8'
                        || board[i][j] == '9') {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean gameEnded(Player player1, Player player2) {
        char player1Symbol = player1.getPlayerSymbol().getSymbol();
        char player2Symbol = player2.getPlayerSymbol().getSymbol();
        boolean player1_win = board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][0] == player1Symbol
                || // Horizontal
                board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][0] == player1Symbol
                || board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][0] == player1Symbol
                || board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[0][0] == player1Symbol || // Vertical
                board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[0][1] == player1Symbol
                || board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[0][2] == player1Symbol
                || board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] == player1Symbol || // Diagonals
                board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] == player1Symbol;

        boolean player2_win = board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][0] == player2Symbol
                || // Horizontal
                board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][0] == player2Symbol
                || board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][0] == player2Symbol
                || board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[0][0] == player2Symbol || // Vertical
                board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[0][1] == player2Symbol
                || board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[0][2] == player2Symbol
                || board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] == player2Symbol
                || board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] == player2Symbol;
        if (player1_win) {
            System.out.println(player1.getName() + " won!");
            return true;
        } else if (player2_win) {
            System.out.println(player2.getName() + " won!");
            return true;
        } else {
            if (boardFull()) {
                System.out.println("It is a tie!");
                return true;
            } else {
                return false;
            }
        }
    }
}
