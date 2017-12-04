package nl.mwensveen.adventofcode.year_2017.day_3;

import org.junit.Assert;
import org.junit.Test;

public class SpiralMemoryTest {

    @Test
    public void testOne() {
        SpiralMemory spiralMemory = new SpiralMemory(1);
        Assert.assertEquals(0, spiralMemory.calculate());
    }

    @Test
    public void testTwo() {
        SpiralMemory spiralMemory = new SpiralMemory(12);
        Assert.assertEquals(3, spiralMemory.calculate());
    }

    @Test
    public void testThree() {
        SpiralMemory spiralMemory = new SpiralMemory(23);
        Assert.assertEquals(2, spiralMemory.calculate());
    }

    @Test
    public void testFour() {
        SpiralMemory spiralMemory = new SpiralMemory(1024);
        Assert.assertEquals(31, spiralMemory.calculate());
    }
}
