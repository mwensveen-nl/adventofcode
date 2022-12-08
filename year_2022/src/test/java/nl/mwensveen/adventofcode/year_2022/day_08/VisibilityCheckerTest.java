package nl.mwensveen.adventofcode.year_2022.day_08;

import com.google.common.collect.Table;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VisibilityCheckerTest {
    String input = """
            30373
            25512
            65332
            33549
            35390
                        """;

    @Test
    public void testCheckVisibility() {
        ForestParser forestParser = new ForestParser();
        Table<Integer, Integer, Tree> forest = forestParser.parse(input.lines().toList());

        VisibilityChecker visibilityChecker = new VisibilityChecker();
        long visibility = visibilityChecker.checkVisibility(forest);

        assertEquals(21, visibility);

        assertTrue(forest.get(0, 0).isVisible());
        assertTrue(forest.get(4, 0).isVisible());
        assertTrue(forest.get(4, 4).isVisible());
        assertTrue(forest.get(0, 4).isVisible());
        assertTrue(forest.get(1, 0).isVisible());
        assertTrue(forest.get(0, 1).isVisible());

        assertTrue(forest.get(1, 1).isVisible());
        assertTrue(forest.get(1, 2).isVisible());
        assertFalse(forest.get(1, 3).isVisible());

    }

}
