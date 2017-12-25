package nl.mwensveen.adventofcode.year_2017.day_24;

import org.junit.Assert;
import org.junit.Test;

public class ElectromagneticMoatTest {

    @Test
    public void testOne() {
        ElectromagneticMoat electromagneticMoat = new ElectromagneticMoat("0/2\n" +
                "2/2\n" +
                "2/3\n" +
                "3/4\n" +
                "3/5\n" +
                "0/1\n" +
                "10/1\n" +
                "9/10");
        Assert.assertEquals(31, electromagneticMoat.calculate());
    }
}
