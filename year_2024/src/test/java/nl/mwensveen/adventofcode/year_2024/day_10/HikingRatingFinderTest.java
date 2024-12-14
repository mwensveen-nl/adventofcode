package nl.mwensveen.adventofcode.year_2024.day_10;

import com.google.common.collect.Table;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HikingRatingFinderTest {

    private static final String input = """
            89010123
            78121874
            87430965
            96549874
            45678903
            32019012
            01329801
            10456732
                    """;

    @Test
    public void testCountRatings() {
        Table<Long, Long, Integer> map = new MapParser().map(input.lines().toList());
        int trails = new HikingRatingFinder().countRatings(map);
        assertEquals(81, trails);
    }

}
