package nl.mwensveen.adventofcode.year_2018.day_18;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class LumberCollectionTest {

    @Test
    public void testExample() throws Exception {
        List<String> input = Arrays.asList(".#.#...|#.", ".....#|##|", ".|..|...#.", "..|#.....#", "#.#|||#|#|", "...#.||...", ".|....|...", "||...#|.#|",
                "|.||||..|.", "...#.|..|.");

        LumberCollection lumberCollection = new LumberCollection(input);
        Assert.assertEquals(1147, lumberCollection.performMagicChanges(10));
    }

}
