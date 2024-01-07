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

    @Test
    public void testPlaceAndGet() {
        Board board = new Board();

        //PLace initial markers
        board.place(0,0, 'X');
        board.place(1, 1, 'O');
        board.place(2,2,'X');

            //Check if markers are correctly read
        assertEquals('X', board.getCell(0,0));
        assertEquals('O', board.getCell(1, 1));
        assertEquals('X', board.getCell(2,2));
    }

    @Test
    public void testInvalidPlacement() {
        Board board = new Board();

                    //Place initial marker
        assertTrue(board.place(0, 0, 'X'));

        //try replacing Marker
        assertFalse(board.place(0, 0, 'O'));

            //testing out of bounds
        assertFalse(board.place(3, 3, 'O'));

        //Check for bioard changes
        assertEquals('X', board.getCell(0, 0));
        assertEquals(' ', board.getCell(1, 1));
    }

}



