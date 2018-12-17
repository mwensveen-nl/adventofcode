package nl.mwensveen.adventofcode.year_2018.day_11;

import org.junit.Assert;
import org.junit.Test;

public class PowerCalculatorTest {

    @Test
    public void testCalculate() throws Exception {
        Assert.assertEquals(-5, PowerCalculator.calculate(122, 79, 57));
        Assert.assertEquals(0, PowerCalculator.calculate(217, 196, 39));
        Assert.assertEquals(4, PowerCalculator.calculate(101, 153, 71));
    }

}
