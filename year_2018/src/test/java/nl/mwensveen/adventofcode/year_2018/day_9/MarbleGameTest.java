package nl.mwensveen.adventofcode.year_2018.day_9;

import org.junit.Assert;
import org.junit.Test;

public class MarbleGameTest {

    @Test
    public void testPlayGame() throws Exception {
        MarbleGame marbleGame = new MarbleGame(10, 25);
        Assert.assertEquals(32, marbleGame.PlayGame().intValue());
        Assert.assertEquals(32, marbleGame.calculateGame().intValue());
    }

    @Test
    public void testPlayGameExample2() throws Exception {
        MarbleGame marbleGame = new MarbleGame(10, 1618);
        Assert.assertEquals(8317, marbleGame.PlayGame().intValue());
        Assert.assertEquals(8317, marbleGame.calculateGame().intValue());
    }

    @Test
    public void testPlayGameExample3() throws Exception {
        MarbleGame marbleGame = new MarbleGame(13, 7999);
        Assert.assertEquals(146373, marbleGame.PlayGame().intValue());
        Assert.assertEquals(146373, marbleGame.calculateGame().intValue());
    }

    @Test
    public void testPlayGameExample4() throws Exception {
        MarbleGame marbleGame = new MarbleGame(17, 1104);
        Assert.assertEquals(2764, marbleGame.PlayGame().intValue());
        Assert.assertEquals(2764, marbleGame.calculateGame().intValue());
    }

    @Test
    public void testPlayGameExample5() throws Exception {
        MarbleGame marbleGame = new MarbleGame(21, 6111);
        Assert.assertEquals(54718, marbleGame.PlayGame().intValue());
        Assert.assertEquals(54718, marbleGame.calculateGame().intValue());
    }

    @Test
    public void testPlayGameExample6() throws Exception {
        MarbleGame marbleGame = new MarbleGame(30, 5807);
        Assert.assertEquals(37305, marbleGame.PlayGame().intValue());
        Assert.assertEquals(37305, marbleGame.calculateGame().intValue());
    }

}
