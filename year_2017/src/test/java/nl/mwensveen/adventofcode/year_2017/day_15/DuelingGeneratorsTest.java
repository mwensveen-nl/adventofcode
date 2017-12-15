package nl.mwensveen.adventofcode.year_2017.day_15;

import org.junit.Assert;
import org.junit.Test;

public class DuelingGeneratorsTest {

    @Test
    public void testOne() {
        DuelingGenerators duelingGenerators = new DuelingGenerators(65, 8921);
        Assert.assertEquals(588, duelingGenerators.calculate());
    }

    @Test
    public void testTwo() {
        DuelingGenerators duelingGenerators = new DuelingGenerators(65, 8921);
        Assert.assertEquals(309, duelingGenerators.calculateWithCriteria());
    }
}
