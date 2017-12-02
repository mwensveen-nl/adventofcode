package nl.mwensveen.adventofcode.year_2017.day_2;

import org.junit.Assert;
import org.junit.Test;

public class CorruptionChecksumEvenlyDivisibleValuesTest {
    private static final String INPUT = "5 9 2 8\n" +
            "9 4 7 3\n" +
            "3 8 6 5";

    @Test
    public void testOne() {
        CorruptionChecksumEvenlyDivisibleValues checksumEvenlyDivisibleValues = new CorruptionChecksumEvenlyDivisibleValues(INPUT);
        Assert.assertEquals(Integer.valueOf(9), checksumEvenlyDivisibleValues.calculate());
    }
}
