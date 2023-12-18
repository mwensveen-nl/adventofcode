package nl.mwensveen.adventofcode.year_2023.day_13;

import com.google.common.collect.Table;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PatternAnalyzerTest {
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
    public void testAnalyze() {
        PatternParser parser = new PatternParser();
        List<Table<Integer, Integer, Symbol>> list = parser.parse(input.lines().toList());

        PatternAnalyzer patternAnalyzer = new PatternAnalyzer();
        long result = patternAnalyzer.analyze(list);
        assertEquals(405, result);

    }

}
