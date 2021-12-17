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
        Table<Integer, Integer, RiskLevel> result = parser.parseInput(input, 1);
        assertEquals(new RiskLevel(0, 0, 1), result.get(0, 0));
        assertEquals(new RiskLevel(0, 9, 2), result.get(0, 9));
        assertEquals(new RiskLevel(9, 0, 2), result.get(9, 0));
        assertEquals(new RiskLevel(9, 9, 1), result.get(9, 9));

        RiskLevel riskLevel = result.get(1, 1);
        assertEquals(result.get(0, 1), riskLevel.getUp());
        assertEquals(result.get(2, 1), riskLevel.getDown());
        assertEquals(result.get(1, 0), riskLevel.getLeft());
        assertEquals(result.get(1, 2), riskLevel.getRight());
    }

    @Test
    public void testParseInput5() {
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
        Table<Integer, Integer, RiskLevel> result = parser.parseInput(input, 5);

        System.out.println(result);
        assertEquals(new RiskLevel(0, 0, 1), result.get(0, 0));
        assertEquals(new RiskLevel(0, 9, 2), result.get(0, 9));

        assertEquals(new RiskLevel(0, 10, 2), result.get(0, 10));
        assertEquals(new RiskLevel(0, 49, 5), result.get(0, 49));
        assertEquals(new RiskLevel(0, 47, 2), result.get(0, 47));

        assertEquals(new RiskLevel(9, 0, 2), result.get(9, 0));
        assertEquals(new RiskLevel(9, 9, 1), result.get(9, 9));
        assertEquals(new RiskLevel(49, 49, 9), result.get(49, 49));

        RiskLevel riskLevel = result.get(1, 1);
        assertEquals(result.get(0, 1), riskLevel.getUp());
        assertEquals(result.get(2, 1), riskLevel.getDown());
        assertEquals(result.get(1, 0), riskLevel.getLeft());
        assertEquals(result.get(1, 2), riskLevel.getRight());
    }

}
