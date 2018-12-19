package nl.mwensveen.adventofcode.year_2018.day_12;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class PotsCalculatorTest {

    @Test
    public void testCalculatePots() throws Exception {
        PotsCalculator potsCalculator = new PotsCalculator("#..#.#..##......###...###", Arrays.asList("...## => #", "..#.. => #", ".#... => #", ".#.#. => #",
                ".#.## => #", ".##.. => #", ".#### => #", "#.#.# => #", "#.### => #", "##.#. => #", "##.## => #", "###.. => #", "###.# => #", "####. => #"));
        Assert.assertEquals(325, potsCalculator.calculatePots(20));
    }

}
