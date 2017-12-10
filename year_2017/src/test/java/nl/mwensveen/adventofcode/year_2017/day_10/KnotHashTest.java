package nl.mwensveen.adventofcode.year_2017.day_10;

import org.junit.Assert;
import org.junit.Test;

public class KnotHashTest {
    @Test
    public void testOne() {
        KnotHash knotHash = new KnotHash("3,4,1,5", 5);
        Assert.assertEquals(12, knotHash.Calculate());
    }
}
