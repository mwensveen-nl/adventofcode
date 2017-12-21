package nl.mwensveen.adventofcode.year_2017.day_19;

import org.junit.Assert;
import org.junit.Test;

public class SeriesofTubesTest {

    @Test
    public void testOne() {
        SeriesofTubes seriesofTubes = new SeriesofTubes("     |          \n" +
                "     |  +--+    \n" +
                "     A  |  C    \n" +
                " F---|----E|--+ \n" +
                "     |  |  |  D \n" +
                "     +B-+  +--+ \n" +
                "");
        Assert.assertEquals("ABCDEF", seriesofTubes.calculate());
        Assert.assertEquals(38, seriesofTubes.calculateSteps());
    }
}
