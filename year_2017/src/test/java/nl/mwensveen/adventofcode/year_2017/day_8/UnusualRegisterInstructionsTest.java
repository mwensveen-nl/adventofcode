package nl.mwensveen.adventofcode.year_2017.day_8;

import org.junit.Assert;
import org.junit.Test;

public class UnusualRegisterInstructionsTest {
    @Test
    public void testOne() {
        UnusualRegisterInstructions unusualRegisterInstructions = new UnusualRegisterInstructions("b inc 5 if a > 1\n" +
                "a inc 1 if b < 5\n" +
                "c dec -10 if a >= 1\n" +
                "c inc -20 if c == 10");
        Assert.assertEquals(Integer.valueOf(1), unusualRegisterInstructions.calculate());
        Assert.assertEquals(Integer.valueOf(10), unusualRegisterInstructions.calculatePartTwo());
        Assert.assertEquals(Integer.valueOf(1), unusualRegisterInstructions.calculate());
        Assert.assertEquals(Integer.valueOf(10), unusualRegisterInstructions.calculatePartTwo());
    }
}
