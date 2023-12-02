package nl.mwensveen.adventofcode.year_2023.day_02;

import com.google.common.collect.Table;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameParserTest {
    String input = """
            Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
            Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
            Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
            Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
            Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
                    """;

    @Test
    public void testParseGames() {
        GameParser gameParser = new GameParser();
        Table<Integer, Integer, CubeGrab> games = gameParser.parseGames(input.lines().toList());

        CubeGrab grab = games.get(1, 0);
        assertEquals(3, grab.blue());
        assertEquals(4, grab.red());
        assertEquals(0, grab.green());

        grab = games.get(1, 1);
        assertEquals(6, grab.blue());
        assertEquals(1, grab.red());
        assertEquals(2, grab.green());

        grab = games.get(1, 2);
        assertEquals(0, grab.blue());
        assertEquals(0, grab.red());
        assertEquals(2, grab.green());

        grab = games.get(5, 0);
        assertEquals(1, grab.blue());
        assertEquals(6, grab.red());
        assertEquals(3, grab.green());
    }

}
