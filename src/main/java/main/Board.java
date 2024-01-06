package main;
import java.util.Arrays;

public class Board {

    char[][] cells;

    public Board() {
        cells = new char[3][3];
        clear();
    }

public boolean isCellEmpty(int x, int y)
{
    return cells[x][y] == ' '; // Check if cell is empty (null character)
}

    public void place(int x, int y, char marker) {
        cells[x][y] = marker;
    }

    public boolean isFull() {
        for (char[] row : cells) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false; // Board is not full
                }
            }
        }
        return true; // Board is full
    }

    public void clear() {
        for (char[] cell : cells) {
            // Clear the board
            Arrays.fill(cell, ' ');
        }
    }

    public void print() {// Display Board State
        System.out.println("\n--------");
        for (char[] cell : cells) {
            System.out.print("| ");
            for (char c : cell) {
                System.out.print(c + " | ");
            }
            System.out.println();
        }
        System.out.println("\n--------");
    }

}
