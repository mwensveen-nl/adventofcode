package nl.mwensveen.adventofcode.year_2018.day_13;

import org.junit.Assert;
import org.junit.Test;

public class DirectionTest {

    @Test
    public void testMove() throws Exception {
        Assert.assertEquals(new Position(1, 1), Direction.UP.move(new Position(1, 2)));
        Assert.assertEquals(new Position(1, 1), Direction.DOWN.move(new Position(1, 0)));
        Assert.assertEquals(new Position(1, 1), Direction.RIGHT.move(new Position(0, 1)));
        Assert.assertEquals(new Position(1, 1), Direction.LEFT.move(new Position(2, 1)));
    }

}
