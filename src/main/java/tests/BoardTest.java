package tests;

// BoardTest.java
import main.Board;
import main.Player;
import main.TicTacToe;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    public void testIsCellEmpty() {
        Board board = new Board();

        assertTrue(board.isCellEmpty(0, 0));
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    public void testIsFull() {

        //Fall empty
        Board board = new Board();

        assertFalse(board.isFull());


        //assertTrue(board.isFull());

        //Fall Voll



       board.place(0, 0, 'X');
       board.place(0, 1, 'O');
       board.place(0, 2, 'X');
       board.place(1, 0, 'O');
       board.place(1, 1, 'O');
       board.place(1, 2, 'X');
       board.place(2, 0, 'X');
       board.place(2, 1, 'X');
       board.place(2, 2, 'O');

        assertTrue(board.isFull());

    }

    @Test
    public void testClear(){
        Board board = new Board();

        board.place(0, 0, 'X');
        board.place(0, 1, 'O');
        board.place(0, 2, 'X');
        board.place(1, 0, 'O');
        board.place(1, 1, 'O');
        board.place(1, 2, 'X');
        board.place(2, 0, 'X');
        board.place(2, 1, 'X');
        board.place(2, 2, 'O');

        assertTrue(board.isFull());
        board.clear();
        assertFalse(board.isFull());

    }

    // todo implement further game logic
}

