package tests;

// BoardTest.java
import main.Board;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    public void testIsCellEmpty() {
        Board board = new Board();

        assertTrue(board.isCellEmpty(0, 0));
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0,0));
    }

    @Test
    public void testIsFull() {
        Board board = new Board();

        assertFalse(board.isFull());


        assertTrue(board.isFull());
    }
    @Test
    public void testClear() {
        Board board = new Board();

        //Place test markler
        board.place(0,0, 'X');
        board.place(1, 1, 'O');

            //Clear board
        board.clear();

        //Check if clearing succeeded
        assertTrue(board.isCellEmpty(0,0));
        assertTrue(board.isCellEmpty(1, 1));
    }



}



