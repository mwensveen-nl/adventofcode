package nl.mwensveen.adventofcode.year_2022.day_08;

import com.google.common.collect.Table;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScenicScoreFinderTest {
    String input = """
            30373
            25512
            65332
            33549
            35390
                        """;

    @Test
    public void testFindScenicScore() {
        ForestParser forestParser = new ForestParser();
        Table<Integer, Integer, Tree> forest = forestParser.parse(input.lines().toList());
        ScenicScoreFinder scenicScoreFinder = new ScenicScoreFinder();
        int scenicScore = scenicScoreFinder.findScenicScore(forest);
        assertEquals(8, scenicScore);
    }

}
