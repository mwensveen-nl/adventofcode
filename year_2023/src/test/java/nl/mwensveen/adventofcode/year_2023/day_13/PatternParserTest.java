package nl.mwensveen.adventofcode.year_2023.day_13;

import com.google.common.collect.Table;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PatternParserTest {
    private String input = """
            #.##..##.
            ..#.##.#.
            ##......#
            ##......#
            ..#.##.#.
            ..##..##.
            #.#.##.#.

            #...##..#
            #....#..#
            ..##..###
            #####.##.
            #####.##.
            ..##..###
            #....#..#
                    """;

    @Test
    public void testParse() {
        PatternParser parser = new PatternParser();
        List<Table<Integer, Integer, Symbol>> list = parser.parse(input.lines().toList());

        assertEquals(2, list.size());

        Table<Integer, Integer, Symbol> table = list.get(0);
        assertEquals(7, table.rowKeySet().size());
        assertEquals(Symbol.ROCK, table.get(1, 1));
        assertEquals(Symbol.ASH, table.get(1, 2));
        assertEquals(Symbol.ROCK, table.get(1, 3));
        assertEquals(Symbol.ASH, table.get(1, 2));
        assertEquals(Symbol.ASH, table.get(1, 9));
        table = list.get(1);
        assertEquals(Symbol.ROCK, table.get(1, 1));
        assertEquals(Symbol.ROCK, table.get(1, 9));

    }

}
