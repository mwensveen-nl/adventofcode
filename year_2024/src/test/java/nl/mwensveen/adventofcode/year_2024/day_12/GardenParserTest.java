package nl.mwensveen.adventofcode.year_2024.day_12;

import com.google.common.collect.Table;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GardenParserTest {
    private static final String input = """
            RRRRIICCFF
            RRRRIICCCF
            VVRRRCCFFF
            VVRCCCJFFF
            VVVVCJJCFE
            VVIVCCJJEE
            VVIIICJJEE
            MIIIIIJJEE
            MIIISIJEEE
            MMMISSJEEE
                    """;

    @Test
    public void testParse() {
        Table<Long, Long, String> table = new GardenParser().parse(input.lines().toList());
        assertEquals("R", table.get(0L, 0L));
    }

}
