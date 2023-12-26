package org.example;

public class Board {

    char[][] cells;

    public Board() {
        cells = new char[3][3];
        clear();
    }

public boolean isCellEmpty(int x, int y)
{
    return cells[x][y] == '\u0000'; // Check if cell is empty (null character)
}

    public void place(int x, int y, char marker) {
        cells[x][y] = marker;
    }

    public boolean isFull() {
        for (char[] row : cells) {
            for (char cell : row) {
                if (cell == '\u0000') {
                    return false; // Board is not full
                }
            }
        }
        return true; // Board is full
    }

    public void clear() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = '\u0000'; // Clear the board
            }
        }
    }

    public void print() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                System.out.print(cells[i][j] == '\u0000' ? " |" : cells[i][j] + "|");
            }
            System.out.println("\n--------");
        }
    }



}
