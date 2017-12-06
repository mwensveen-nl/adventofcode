package nl.mwensveen.adventofcode.year_2017.day_6;

import org.junit.Assert;
import org.junit.Test;

public class MemoryReallocationTest {
    @Test
    public void testOne() {
        MemoryReallocation memoryReallocation = new MemoryReallocation("0 2 7 0");
        LoopStats loopStats = memoryReallocation.calculate();
        Assert.assertEquals(5, loopStats.getLoopCounter());
        Assert.assertEquals(4, loopStats.getLoopSize());
    }
}
