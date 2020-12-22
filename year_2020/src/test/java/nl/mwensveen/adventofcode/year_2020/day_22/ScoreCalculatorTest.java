package nl.mwensveen.adventofcode.year_2020.day_22;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ScoreCalculatorTest {

    @Test
    public void testCalculateScore() throws Exception {
        List<String> input = Arrays.asList("Player 1:", "9", "2", "6", "3", "1", "", "Player 2:", "5", "8", "4", "7", "10");
        InputParser inputParser = new InputParser();
        List<Player> players = inputParser.parse(input);

        CombatGame game = new CombatGame();
        Player winner = game.playGame(players);

        ScoreCalculator scoreCalculator = new ScoreCalculator();
        long result = scoreCalculator.calculateScore(winner);
        assertEquals(306, result);
    }

    @Test
    public void testCalculateScore2() throws Exception {
        List<String> input = Arrays.asList("Player 1:", "7", "5", "6", "2", "4", "1", "10", "8", "9", "3");
        InputParser inputParser = new InputParser();
        List<Player> players = inputParser.parse(input);

        ScoreCalculator scoreCalculator = new ScoreCalculator();
        long result = scoreCalculator.calculateScore(players.get(0));
        assertEquals(291, result);
    }

}
