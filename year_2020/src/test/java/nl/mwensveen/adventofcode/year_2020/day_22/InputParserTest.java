package nl.mwensveen.adventofcode.year_2020.day_22;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class InputParserTest {

    @Test
    public void testParse() throws Exception {
        List<String> input = Arrays.asList("Player 1:", "9", "2", "6", "3", "1", "", "Player 2:", "5", "8", "4", "7", "10");
        InputParser inputParser = new InputParser();
        List<Player> result = inputParser.parse(input);

        assertEquals(2, result.size());

        Player player = result.get(0);
        assertEquals("1", player.getName());
        assertEquals(Integer.valueOf(9), player.getTopSpaceCard());
        assertEquals(Integer.valueOf(2), player.getTopSpaceCard());
        assertEquals(Integer.valueOf(6), player.getTopSpaceCard());
        assertEquals(Integer.valueOf(3), player.getTopSpaceCard());
        assertEquals(Integer.valueOf(1), player.getTopSpaceCard());
        assertFalse(player.hasSpaceCards());

        player = result.get(1);
        assertEquals("2", player.getName());
        assertEquals(Integer.valueOf(5), player.getTopSpaceCard());
        assertEquals(Integer.valueOf(8), player.getTopSpaceCard());
        assertEquals(Integer.valueOf(4), player.getTopSpaceCard());
        assertEquals(Integer.valueOf(7), player.getTopSpaceCard());
        assertEquals(Integer.valueOf(10), player.getTopSpaceCard());
        assertFalse(player.hasSpaceCards());
    }

}
