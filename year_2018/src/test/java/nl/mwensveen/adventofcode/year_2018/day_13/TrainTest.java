package nl.mwensveen.adventofcode.year_2018.day_13;

import org.junit.Assert;
import org.junit.Test;

public class TrainTest {

    @Test
    public void testMoveUpVertical() throws Exception {
        Train t = new Train(1, 1, Direction.UP);
        Assert.assertEquals(new Position(1, 0), t.move(TrackPart.STRAIGHT_VERTICAL));
    }

    @Test
    public void testMoveDownVertical() throws Exception {
        Train t = new Train(1, 1, Direction.DOWN);
        Assert.assertEquals(new Position(1, 2), t.move(TrackPart.STRAIGHT_VERTICAL));
    }

    @Test
    public void testMoveLeftHorizontal() throws Exception {
        Train t = new Train(1, 1, Direction.LEFT);
        Assert.assertEquals(new Position(0, 1), t.move(TrackPart.STRAIGHT_HORIZONTAL));
    }

    @Test
    public void testMoveRightHorizontal() throws Exception {
        Train t = new Train(1, 1, Direction.RIGHT);
        Assert.assertEquals(new Position(2, 1), t.move(TrackPart.STRAIGHT_HORIZONTAL));
    }

    @Test
    public void testMoveUpCurveLeft() throws Exception {
        Train t = new Train(2, 2, Direction.UP);
        Assert.assertEquals(new Position(1, 2), t.move(TrackPart.CURVE_LEFT));
        Assert.assertEquals(new Position(0, 2), t.move(TrackPart.STRAIGHT_HORIZONTAL));
    }

    @Test
    public void testMoveUpCurveRight() throws Exception {
        Train t = new Train(2, 2, Direction.UP);
        Assert.assertEquals(new Position(3, 2), t.move(TrackPart.CURVE_RIGHT));
        Assert.assertEquals(new Position(4, 2), t.move(TrackPart.STRAIGHT_HORIZONTAL));
    }

    @Test
    public void testMoveRightCurveLeft() throws Exception {
        Train t = new Train(2, 2, Direction.RIGHT);
        Assert.assertEquals(new Position(2, 3), t.move(TrackPart.CURVE_LEFT));
        Assert.assertEquals(new Position(2, 4), t.move(TrackPart.STRAIGHT_VERTICAL));
    }

    @Test
    public void testMoveRightCurveRight() throws Exception {
        Train t = new Train(2, 2, Direction.RIGHT);
        Assert.assertEquals(new Position(2, 1), t.move(TrackPart.CURVE_RIGHT));
        Assert.assertEquals(new Position(2, 0), t.move(TrackPart.STRAIGHT_VERTICAL));
    }

    @Test
    public void testMoveRightCrossing() throws Exception {
        Train t = new Train(4, 4, Direction.RIGHT);
        Assert.assertEquals(new Position(4, 3), t.move(TrackPart.CROSSING));
        Assert.assertEquals(new Position(4, 2), t.move(TrackPart.STRAIGHT_VERTICAL));
        Assert.assertEquals(new Position(4, 1), t.move(TrackPart.CROSSING));
        Assert.assertEquals(new Position(4, 0), t.move(TrackPart.STRAIGHT_VERTICAL));
        Assert.assertEquals(new Position(5, 0), t.move(TrackPart.CROSSING));
        Assert.assertEquals(new Position(6, 0), t.move(TrackPart.STRAIGHT_HORIZONTAL));
    }

    @Test
    public void testCollision() throws Exception {
        Train t1 = new Train(2, 3, Direction.UP);
        Train t2 = new Train(3, 2, Direction.UP);
        Assert.assertFalse(t1.collision(t2));

        Train t3 = new Train(2, 3, Direction.DOWN);
        Assert.assertTrue(t1.collision(t3));

        Assert.assertFalse(t1.collision(t1));
    }

}
