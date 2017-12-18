package nl.mwensveen.adventofcode.year_2017.day_17;

import org.junit.Assert;
import org.junit.Test;

public class SpinlockTest {
    @Test
    public void testOne() {
        Spinlock spinlock = new Spinlock("3");
        Assert.assertEquals(638, spinlock.calculate(2017));
        Assert.assertEquals(1226, spinlock.calculateAfterZero(2017));
    }
}
