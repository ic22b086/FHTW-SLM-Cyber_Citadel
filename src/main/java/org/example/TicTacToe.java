package org.example;

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
        // Implement game logic here
    }

    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean hasWinner() {
        // Implement winning conditions here
        return false;
    }

    public static void main(String[] args) {
        Player playerX = new Player('X');
        Player playerO = new Player('O');
        TicTacToe game = new TicTacToe(playerX, playerO);

        // Display initial state
        game.board.print();
    }
}
