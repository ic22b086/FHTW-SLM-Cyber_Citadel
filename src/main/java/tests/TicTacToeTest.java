package tests;

// TicTacToeTest.java
import main.Player;
import main.TicTacToe;



import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

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


        // diagonal

        game.getBoard().clear();

        game.getBoard().place(0, 0, 'X');
        game.getBoard().place(1, 1, 'X');
        game.getBoard().place(2, 2, 'X');

        assertTrue(game.hasWinner());


        //Full and no winner:

        game.getBoard().clear();

        game.getBoard().place(0, 0, 'X');
        game.getBoard().place(0, 1, 'O');
        game.getBoard().place(0, 2, 'X');
        game.getBoard().place(1, 0, 'O');
        game.getBoard().place(1, 1, 'O');
        game.getBoard().place(1, 2, 'X');
        game.getBoard().place(2, 0, 'X');
        game.getBoard().place(2, 1, 'X');
        game.getBoard().place(2, 2, 'O');

        assertFalse(game.hasWinner());

    }




    @Test
    public void testValidateMoveRepeat(){
        Player playerX = new Player('X');
        Player playerO = new Player('O');
        TicTacToe game = new TicTacToe(playerX, playerO);

        game.validateMove(0, 0);
        game.validateMove(0, 0);

        assertEquals("This cell is already taken, Please choose another cell", outputStream.toString());

    }
    @Test
    public void testValidateMoveOOB(){
        Player playerX = new Player('X');
        Player playerO = new Player('O');
        TicTacToe game = new TicTacToe(playerX, playerO);

        game.validateMove(4,4);
        assertEquals("Invalid row. Please enter a number between 0 and 2.\n", outputStream.toString());


    }
    @Test
    public void testValidateMoveOOB2(){
        Player playerX = new Player('X');
        Player playerO = new Player('O');
        TicTacToe game = new TicTacToe(playerX, playerO);

        game.validateMove(0,4);
        assertEquals("Invalid column. Please enter a number between 0 and 2.\n", outputStream.toString());

    }


}
