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
        //todo
        return false;
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
            System.out.println("Invalid row. Please enter a number between 0 and 2.");
            return;
        }

        if (col < 0 || col > 2) {
            System.out.println("Invalid column. Please enter a number between 0 and 2.");
            return;

        }
        if (!board.isCellEmpty(row, col)){
            System.out.println("This cell is already taken, Please choose another cell");
            return;
        }

        board.place(row, col, currentPlayer.getMarker());
        switchCurrentPlayer();

    }
}
