package nl.mwensveen.adventofcode.year_2023.day_02;

import com.google.common.collect.Table;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameAnalyzerTest {
    String input = """
            Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
            Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
            Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
            Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
            Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
                    """;

    @Test
    public void testAnalyzePosibleGames() {
        GameParser gameParser = new GameParser();
        Table<Integer, Integer, CubeGrab> games = gameParser.parseGames(input.lines().toList());

        GameAnalyzer gameAnalyzer = new GameAnalyzer();
        long l = gameAnalyzer.analyzePosibleGames(games);
        assertEquals(8, l);
    }

    @Test
    public void testAnalyzePowerGames() {
        GameParser gameParser = new GameParser();
        Table<Integer, Integer, CubeGrab> games = gameParser.parseGames(input.lines().toList());

        GameAnalyzer gameAnalyzer = new GameAnalyzer();
        long l = gameAnalyzer.analyzePowerGames(games);
        assertEquals(2286, l);
    }

}
