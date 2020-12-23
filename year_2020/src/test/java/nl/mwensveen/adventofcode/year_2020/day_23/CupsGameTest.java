package nl.mwensveen.adventofcode.year_2020.day_23;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CupsGameTest {

    @Test
    public void testPlayGame() throws Exception {
        List<Integer> input = Arrays.asList(3, 8, 9, 1, 2, 5, 4, 6, 7);
        CupsGame game = new CupsGame();
        String result = game.playGame(input, 10);
        assertEquals("92658374", result);
    }

    @Test
    public void testPlayGame2() throws Exception {
        List<Integer> input = Arrays.asList(3, 8, 9, 1, 2, 5, 4, 6, 7);
        CupsGame game = new CupsGame();
        String result = game.playGame(input, 100);
        assertEquals("67384529", result);
    }

}
