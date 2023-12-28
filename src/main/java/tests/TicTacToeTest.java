package tests;

// TicTacToeTest.java
import main.Player;
import main.TicTacToe;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

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

        // Implement the board state that leads to a win
        game.getBoard().place(0, 0, 'X');
        game.getBoard().place(0, 1, 'X');
        game.getBoard().place(0, 2, 'X');

        assertTrue(game.hasWinner());
    }

    // Add more tests based on your game logic and requirements
}
