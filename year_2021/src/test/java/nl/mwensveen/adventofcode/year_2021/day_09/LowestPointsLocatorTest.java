package nl.mwensveen.adventofcode.year_2021.day_09;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LowestPointsLocatorTest {

    @Test
    public void testLocateLowestPoints() {
        List<String> input = Arrays.asList("2199943210", "3987894921", "9856789892", "8767896789", "9899965678");
        LowestPointsLocator lowestPointsLocator = new LowestPointsLocator();
        Integer result = lowestPointsLocator.locateLowestPoints(input);
        assertEquals(15, result);
    }

    @Test
    public void testCalculateBasins() {
        List<String> input = Arrays.asList("2199943210", "3987894921", "9856789892", "8767896789", "9899965678");
        LowestPointsLocator lowestPointsLocator = new LowestPointsLocator();
        Integer result = lowestPointsLocator.calculateBasins(input);
        assertEquals(1134, result);
    }

}
