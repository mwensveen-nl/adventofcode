package nl.mwensveen.adventofcode.year_2017.day_2;

import org.junit.Assert;
import org.junit.Test;

public class CorruptionChecksumMinMaxTest {

    @Test
    public void testPartOneOne() {
        String input = "5 1 9 5\n" +
                "7 5 3\n" +
                "2 4 6 8";

        CorruptionChecksumMinMax corruptionChecksum = new CorruptionChecksumMinMax(input);
        Assert.assertEquals(Integer.valueOf(18), corruptionChecksum.calculate());
    }

}
