package nl.mwensveen.adventofcode.year_2017.day_12;

import org.junit.Assert;
import org.junit.Test;

public class DigitalPlumberTest {

    @Test
    public void testOne() {
        DigitalPlumber digitalPlumber = new DigitalPlumber("0 <-> 2\n" +
                "1 <-> 1\n" +
                "2 <-> 0, 3, 4\n" +
                "3 <-> 2, 4\n" +
                "4 <-> 2, 3, 6\n" +
                "5 <-> 6\n" +
                "6 <-> 4, 5");
        Assert.assertEquals(6, digitalPlumber.calculate());
        Assert.assertEquals(2, digitalPlumber.calculateGroups());
    }
}
