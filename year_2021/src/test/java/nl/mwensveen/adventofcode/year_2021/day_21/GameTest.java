package nl.mwensveen.adventofcode.year_2021.day_21;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testPlayGame2() {
        List<String> input = Arrays.asList("Player 1 starting position: 4",
                "Player 2 starting position: 8");

        Game game = new Game();
        long result = game.playGame(input, 1000);
        assertEquals(739785L, result);
    }

    @Test
    public void testPlayGameQuantum() {
        List<String> input = Arrays.asList("Player 1 starting position: 4",
                "Player 2 starting position: 8");

        Game game = new Game();
        long result = game.playGameQuantum(input, 21);
        assertEquals(444356092776315L, result);
    }

}
