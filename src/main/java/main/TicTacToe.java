package main;

import java.util.Scanner;

// TicTacToe.java
public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.board = new Board();
    }

    public void start() {
        //todo
    }

    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean hasWinner() {
        for (int i = 0; i < board.cells.length; i++) {
            if(board.cells[i][0] == board.cells[i][1] && board.cells[i][0] == board.cells[i][2] && !board.isCellEmpty(i, 0)) // Checking each row
                return true;
            if(board.cells[0][i] == board.cells[1][i] && board.cells[0][i] == board.cells[2][i] && !board.isCellEmpty(0, i)) // Checking each col
                return true;
        }
        if(board.cells[0][0] == board.cells[1][1] && board.cells[0][0] == board.cells[2][2] && !board.isCellEmpty(0, 0))
            return true;
        return board.cells[0][2] == board.cells[1][1] && board.cells[0][2] == board.cells[2][0] && !board.isCellEmpty(0, 2);
    }


    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public static void main(String[] args) {
        Player player1 = new Player('X');
        Player player2 = new Player('O');
        TicTacToe game = new TicTacToe(player1, player2);

        game.start();

    }

    public Board getBoard() {
        return board;
    }


    public void validateMove(int row, int col){

        if (row < 0 || row > 2) {
            System.out.printf("Invalid row. Please enter a number between 0 and 2.\n");
            return;
        }

        if (col < 0 || col > 2) {
            System.out.printf("Invalid column. Please enter a number between 0 and 2.\n");
            return;

        }
        if (!board.isCellEmpty(row, col)){
            System.out.printf("This cell is already taken, Please choose another cell\n");
            return;
        }

        board.place(row, col, currentPlayer.getMarker());
        switchCurrentPlayer();

    }
}
