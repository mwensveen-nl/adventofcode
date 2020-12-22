package nl.mwensveen.adventofcode.year_2020.day_22;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CombatGameTest {

    @Test
    public void testPlayGame() throws Exception {
        List<String> input = Arrays.asList("Player 1:", "9", "2", "6", "3", "1", "", "Player 2:", "5", "8", "4", "7", "10");
        InputParser inputParser = new InputParser();
        List<Player> players = inputParser.parse(input);

        CombatGame game = new CombatGame();
        Player winner = game.playGame(players);
        assertEquals("2", winner.getName());
        assertEquals(Integer.valueOf(3), winner.getTopSpaceCard());
        assertEquals(Integer.valueOf(2), winner.getTopSpaceCard());
        assertEquals(Integer.valueOf(10), winner.getTopSpaceCard());
        assertEquals(Integer.valueOf(6), winner.getTopSpaceCard());
        assertEquals(Integer.valueOf(8), winner.getTopSpaceCard());
        assertEquals(Integer.valueOf(5), winner.getTopSpaceCard());
        assertEquals(Integer.valueOf(9), winner.getTopSpaceCard());
        assertEquals(Integer.valueOf(4), winner.getTopSpaceCard());
        assertEquals(Integer.valueOf(7), winner.getTopSpaceCard());
        assertEquals(Integer.valueOf(1), winner.getTopSpaceCard());

    }

}
