package nl.mwensveen.adventofcode.year_2025.day_04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.common.collect.Table;
import org.junit.jupiter.api.Test;

class PaperRollDiagramInputParserTest {
    private String input = """
            ..@@.@@@@.
            @@@.@.@.@@
            @@@@@.@.@@
            @.@@@@..@.
            @@.@@@@.@@
            .@@@@@@@.@
            .@.@.@.@@@
            @.@@@.@@@@
            .@@@@@@@@.
            @.@.@@@.@.
                    """;

    @Test
    public void parse() {
        Table<Integer, Integer, Character> diagram = new PaperRollDiagramInputParser().parse(input.lines().toList());
        assertEquals(10, diagram.rowKeySet().size());
        assertEquals(10, diagram.columnKeySet().size());
        assertEquals('@', diagram.get(0, 2));
        assertEquals('.', diagram.get(0, 0));
        assertEquals('.', diagram.get(9, 9));
    }

}
