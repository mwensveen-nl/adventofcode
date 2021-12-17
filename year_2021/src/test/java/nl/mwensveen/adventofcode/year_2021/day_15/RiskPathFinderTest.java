package nl.mwensveen.adventofcode.year_2021.day_15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RiskPathFinderTest {

    @Test
    public void testFindShortestPath() {
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

        RiskPathFinder riskPathFinder = new RiskPathFinder();
        long result = riskPathFinder.findShortestPath(input, 1);
        assertEquals(40L, result);
    }

    @Test
    public void testFindShortestPath5() {
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

        RiskPathFinder riskPathFinder = new RiskPathFinder();
        long result = riskPathFinder.findShortestPath(input, 5);
        assertEquals(315L, result);
    }

}
