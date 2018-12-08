package nl.mwensveen.adventofcode.year_2018.day_8;

import org.junit.Assert;
import org.junit.Test;

public class NodeCalculatorTest {

    @Test
    public void testCalculate() throws Exception {
        NodeCalculator calculator = new NodeCalculator("2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2");
        Assert.assertEquals(138, calculator.calculate().intValue());
    }

    @Test
    public void testCalculateComplex() throws Exception {
        NodeCalculator calculator = new NodeCalculator("2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2");
        Assert.assertEquals(66, calculator.calculateComplex().intValue());
    }

    @Test
    public void testCalculateSimpleAndComplex() throws Exception {
        NodeCalculator calculator = new NodeCalculator("2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2");
        Assert.assertEquals(138, calculator.calculate().intValue());
        Assert.assertEquals(66, calculator.calculateComplex().intValue());
    }

}
