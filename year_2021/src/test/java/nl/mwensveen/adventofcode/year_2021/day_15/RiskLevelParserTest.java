package nl.mwensveen.adventofcode.year_2021.day_15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.common.collect.Table;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RiskLevelParserTest {

    @Test
    public void testParseInput() {
        List<String> input = Arrays.asList("1163751742",
                "1381373672",
                "2136511328",
                "3694931569",
                "7463417111",
                "1319128137",
                "1359912421",
                "3125421639",
                "1293138521",
                "2311944581");

        RiskLevelParser parser = new RiskLevelParser();
        Table<Integer, Integer, RiskLevel> result = parser.parseInput(input);
        assertEquals(new RiskLevel(0, 0, 1), result.get(0, 0));
        assertEquals(new RiskLevel(0, 9, 2), result.get(0, 9));
        assertEquals(new RiskLevel(9, 0, 2), result.get(9, 0));
        assertEquals(new RiskLevel(9, 9, 1), result.get(9, 9));
    }

}
