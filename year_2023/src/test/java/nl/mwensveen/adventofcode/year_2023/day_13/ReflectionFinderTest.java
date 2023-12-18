package nl.mwensveen.adventofcode.year_2023.day_13;

import com.google.common.collect.Table;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReflectionFinderTest {
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
    private String input2 = """
            ..##.##.#....
            .##########..
            .##########..
            ..##.##.#.#..
            .######..##..
            ###..#.####..
            #...#.#..##..
            .#.#...#..###
            #.##.#.####..
            ..#####...###
            ..#..##....##
            .#.####.##...
            #.########.##
                        """;

    @Test
    public void testFind() {
        PatternParser parser = new PatternParser();
        List<Table<Integer, Integer, Symbol>> list = parser.parse(input.lines().toList());

        ReflectionFinder reflectionFinder = new ReflectionFinder();
        int i = reflectionFinder.find(list.get(0));
        assertEquals(5, i);
    }

    @Test
    public void testFind2() {
        PatternParser parser = new PatternParser();
        List<Table<Integer, Integer, Symbol>> list = parser.parse(input.lines().toList());

        ReflectionFinder reflectionFinder = new ReflectionFinder();
        int i = reflectionFinder.find(list.get(1));
        assertEquals(400, i);
    }

    @Test
    public void testFind3() {
        PatternParser parser = new PatternParser();
        List<Table<Integer, Integer, Symbol>> list = parser.parse(input2.lines().toList());

        ReflectionFinder reflectionFinder = new ReflectionFinder();
        int i = reflectionFinder.find(list.get(0));
        assertEquals(12, i);
    }

}
