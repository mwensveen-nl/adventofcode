package nl.mwensveen.adventofcode.year_2024.day_10;

import com.google.common.collect.Table;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapParserTest {
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
    public void testMap() {
        Table<Long, Long, Integer> map = new MapParser().map(input.lines().toList());

        assertEquals(8, map.get(Long.valueOf(0), Long.valueOf(0)));
        assertEquals(3, map.get(Long.valueOf(0), Long.valueOf(7)));
        assertEquals(1, map.get(Long.valueOf(7), Long.valueOf(0)));
        assertEquals(2, map.get(Long.valueOf(7), Long.valueOf(7)));
    }

}
