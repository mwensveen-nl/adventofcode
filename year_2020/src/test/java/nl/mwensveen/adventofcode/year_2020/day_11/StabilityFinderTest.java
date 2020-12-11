package nl.mwensveen.adventofcode.year_2020.day_11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.common.collect.Table;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class StabilityFinderTest {

    @Test
    public void testFindOccupiedSeatsInStability() throws Exception {
        FloorPlanParser parser = new FloorPlanParser();
        Table<Long, Long, PositionState> input = parser.parse(Arrays.asList("L.LL.LL.LL", "LLLLLLL.LL", "L.L.L..L..", "LLLL.LL.LL", "L.LL.LL.LL", "L.LLLLL.LL",
                "..L.L.....", "LLLLLLLLLL", "L.LLLLLL.L", "L.LLLLL.LL"));

        StabilityFinder stabilityFinder = new StabilityFinder();
        int result = stabilityFinder.findOccupiedSeatsInStability(input, true);
        assertEquals(37, result);
    }

    @Test
    public void testFindOccupiedSeatsInStabilityAllDirections() throws Exception {
        FloorPlanParser parser = new FloorPlanParser();
        Table<Long, Long, PositionState> input = parser.parse(Arrays.asList("L.LL.LL.LL", "LLLLLLL.LL", "L.L.L..L..", "LLLL.LL.LL", "L.LL.LL.LL", "L.LLLLL.LL",
                "..L.L.....", "LLLLLLLLLL", "L.LLLLLL.L", "L.LLLLL.LL"));

        StabilityFinder stabilityFinder = new StabilityFinder();
        int result = stabilityFinder.findOccupiedSeatsInStability(input, false);
        assertEquals(26, result);
    }

}
