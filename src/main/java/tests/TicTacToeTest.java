package tests;

// TicTacToeTest.java
import main.Player;
import main.TicTacToe;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp(){
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void closeStream(){
        System.setOut(standardOut);
    }

    @Test
    public void testSwitchCurrentPlayer() {
        Player playerX = new Player('X');
        Player playerO = new Player('O');
        TicTacToe game = new TicTacToe(playerX, playerO);

        assertEquals(playerX, game.getCurrentPlayer());
        game.switchCurrentPlayer();
        assertEquals(playerO, game.getCurrentPlayer());
        game.switchCurrentPlayer();
        assertEquals(playerX, game.getCurrentPlayer());
    }

    @Test
    public void testHasWinner() {
        Player playerX = new Player('X');
        Player playerO = new Player('O');
        TicTacToe game = new TicTacToe(playerX, playerO);


        game.getBoard().place(0, 0, 'X');
        game.getBoard().place(0, 1, 'X');
        game.getBoard().place(0, 2, 'X');

        assertTrue(game.hasWinner());
    }


    @Test
    public void testValidateMove(){
        Player playerX = new Player('X');
        Player playerO = new Player('O');
        TicTacToe game = new TicTacToe(playerX, playerO);

        game.getBoard().place(0, 0, 'X');
        game.getBoard().place(0, 0, 'X');

        assertEquals("This cell is already taken, Please choose another cell", outputStream.toString());

        game.getBoard().place(4, 4, 'X');
        assertEquals("Invalid row. Please enter a number between 0 and 2.", outputStream.toString());

        game.getBoard().place(0, 4, 'X');
        assertEquals("Invalid column. Please enter a number between 0 and 2.", outputStream.toString());

    }

    // todo add further tests
}
