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
        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    public void testIsFull() {
        Board board = new Board();

        assertFalse(board.isFull());


        assertTrue(board.isFull());
    }

    // todo implement further game logic
}

