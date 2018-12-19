package nl.mwensveen.adventofcode.year_2018.day_13;

import org.junit.Assert;
import org.junit.Test;

public class TurnTest {

    @Test
    public void testMakeTurn() throws Exception {
        Assert.assertEquals(Direction.LEFT, Turn.LEFT.makeTurn(Direction.UP));
        Assert.assertEquals(Direction.RIGHT, Turn.RIGHT.makeTurn(Direction.UP));
        Assert.assertEquals(Direction.UP, Turn.STRAIGHT.makeTurn(Direction.UP));

        Assert.assertEquals(Direction.UP, Turn.LEFT.makeTurn(Direction.LEFT));
        Assert.assertEquals(Direction.DOWN, Turn.RIGHT.makeTurn(Direction.LEFT));
        Assert.assertEquals(Direction.LEFT, Turn.STRAIGHT.makeTurn(Direction.LEFT));

        Assert.assertEquals(Direction.RIGHT, Turn.LEFT.makeTurn(Direction.DOWN));
        Assert.assertEquals(Direction.LEFT, Turn.RIGHT.makeTurn(Direction.DOWN));
        Assert.assertEquals(Direction.DOWN, Turn.STRAIGHT.makeTurn(Direction.DOWN));

        Assert.assertEquals(Direction.RIGHT, Turn.LEFT.makeTurn(Direction.DOWN));
        Assert.assertEquals(Direction.LEFT, Turn.RIGHT.makeTurn(Direction.DOWN));
        Assert.assertEquals(Direction.DOWN, Turn.STRAIGHT.makeTurn(Direction.DOWN));

        Assert.assertEquals(Direction.DOWN, Turn.LEFT.makeTurn(Direction.RIGHT));
        Assert.assertEquals(Direction.UP, Turn.RIGHT.makeTurn(Direction.RIGHT));
        Assert.assertEquals(Direction.RIGHT, Turn.STRAIGHT.makeTurn(Direction.RIGHT));
    }

    @Test
    public void testNextTurn() throws Exception {
        Assert.assertEquals(Turn.LEFT, Turn.RIGHT.nextTurn());
        Assert.assertEquals(Turn.RIGHT, Turn.STRAIGHT.nextTurn());
        Assert.assertEquals(Turn.STRAIGHT, Turn.LEFT.nextTurn());
    }

}
