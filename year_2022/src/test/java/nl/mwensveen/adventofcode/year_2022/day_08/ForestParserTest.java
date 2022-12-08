package nl.mwensveen.adventofcode.year_2022.day_08;

import com.google.common.collect.Table;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ForestParserTest {
    String input = """
            30373
            25512
            65332
            33549
            35390
                        """;

    @Test
    public void testParse() {
        ForestParser forestParser = new ForestParser();
        Table<Integer, Integer, Tree> forest = forestParser.parse(input.lines().toList());
        assertEquals(5, forest.columnKeySet().size());
        assertEquals(5, forest.rowKeySet().size());

        assertEquals(3, forest.get(0, 0).getHeight());
        assertEquals(0, forest.get(0, 1).getHeight());
        assertEquals(0, forest.get(4, 4).getHeight());
        assertEquals(9, forest.get(4, 3).getHeight());
    }

}
