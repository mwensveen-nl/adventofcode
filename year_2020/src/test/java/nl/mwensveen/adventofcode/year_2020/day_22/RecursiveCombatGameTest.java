package nl.mwensveen.adventofcode.year_2020.day_22;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RecursiveCombatGameTest {

    @Test
    public void testPlayGame() throws Exception {
        List<String> input = Arrays.asList("Player 1:", "43", "19", "", "Player 2:", "2", "29", "14");
        InputParser inputParser = new InputParser();
        List<Player> players = inputParser.parse(input);
        RecursiveCombatGame game = new RecursiveCombatGame();
        Player winner = game.playGame(players);
        assertEquals("1", winner.getName());
    }

    @Test
    public void testPlayGame2() throws Exception {
        List<String> input = Arrays.asList("Player 1:", "9", "2", "6", "3", "1", "", "Player 2:", "5", "8", "4", "7", "10");
        InputParser inputParser = new InputParser();
        List<Player> players = inputParser.parse(input);
        RecursiveCombatGame game = new RecursiveCombatGame();
        Player winner = game.playGame(players);
        assertEquals("2", winner.getName());

        assertEquals(7, winner.getTopSpaceCard());
        assertEquals(5, winner.getTopSpaceCard());
        assertEquals(6, winner.getTopSpaceCard());
        assertEquals(2, winner.getTopSpaceCard());
        assertEquals(4, winner.getTopSpaceCard());
        assertEquals(1, winner.getTopSpaceCard());
        assertEquals(10, winner.getTopSpaceCard());
        assertEquals(8, winner.getTopSpaceCard());
        assertEquals(9, winner.getTopSpaceCard());
        assertEquals(3, winner.getTopSpaceCard());
    }

}
