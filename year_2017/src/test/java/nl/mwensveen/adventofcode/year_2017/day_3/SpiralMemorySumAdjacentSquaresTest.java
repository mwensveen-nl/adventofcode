package nl.mwensveen.adventofcode.year_2017.day_3;

import org.junit.Assert;
import org.junit.Test;

public class SpiralMemorySumAdjacentSquaresTest {
    @Test
    public void testOne() {
        SpiralMemorySumAdjacentSquares spiralMemorySumAdjacentSquares = new SpiralMemorySumAdjacentSquares(1);
        Assert.assertEquals(2, spiralMemorySumAdjacentSquares.calculate());
    }

    @Test
    public void testTwo() {
        SpiralMemorySumAdjacentSquares spiralMemorySumAdjacentSquares = new SpiralMemorySumAdjacentSquares(5);
        Assert.assertEquals(10, spiralMemorySumAdjacentSquares.calculate());
    }

    @Test
    public void testThree() {
        SpiralMemorySumAdjacentSquares spiralMemorySumAdjacentSquares = new SpiralMemorySumAdjacentSquares(12);
        Assert.assertEquals(23, spiralMemorySumAdjacentSquares.calculate());
    }

    @Test
    public void testFour() {
        SpiralMemorySumAdjacentSquares spiralMemorySumAdjacentSquares = new SpiralMemorySumAdjacentSquares(747);
        Assert.assertEquals(806, spiralMemorySumAdjacentSquares.calculate());
    }
}
