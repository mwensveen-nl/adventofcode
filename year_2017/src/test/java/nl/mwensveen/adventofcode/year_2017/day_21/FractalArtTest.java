package nl.mwensveen.adventofcode.year_2017.day_21;

import org.junit.Assert;
import org.junit.Test;

public class FractalArtTest {

    @Test
    public void testOne() {
        FractalArt fractalArt = new FractalArt("../.# => ##./#../...\n" +
                ".#./..#/### => #..#/..../..../#..#");
        Assert.assertEquals(12, fractalArt.calculate(2));
    }

}
