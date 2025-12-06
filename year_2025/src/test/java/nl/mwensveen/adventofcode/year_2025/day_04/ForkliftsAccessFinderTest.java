package nl.mwensveen.adventofcode.year_2025.day_04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.common.collect.Table;
import org.junit.jupiter.api.Test;

class ForkliftsAccessFinderTest {
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
    public void findAccessable() {
        Table<Integer, Integer, Character> diagram = new PaperRollDiagramInputParser().parse(input.lines().toList());
        int accessable = new ForkliftsAccessFinder().findAccessable(diagram);
        assertEquals(13, accessable);
    }

    @Test
    public void findAccessableWithRemove() {
        Table<Integer, Integer, Character> diagram = new PaperRollDiagramInputParser().parse(input.lines().toList());
        int accessable = new ForkliftsAccessFinder().findAccessableWithRemove(diagram);
        assertEquals(43, accessable);
    }

}
