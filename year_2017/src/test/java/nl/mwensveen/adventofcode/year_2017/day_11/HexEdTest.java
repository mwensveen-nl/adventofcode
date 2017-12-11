package nl.mwensveen.adventofcode.year_2017.day_11;

import org.junit.Assert;
import org.junit.Test;

public class HexEdTest {

    @Test
    public void testOne() {
        HexEd hexEd = new HexEd("ne,ne,ne");
        Assert.assertEquals(3, hexEd.calculate());
    }

    @Test
    public void testTwo() {
        HexEd hexEd = new HexEd("ne,ne,sw,sw");
        Assert.assertEquals(0, hexEd.calculate());
    }

    @Test
    public void testThree() {
        HexEd hexEd = new HexEd("ne,ne,s,s");
        Assert.assertEquals(2, hexEd.calculate());
    }

    @Test
    public void testFour() {
        HexEd hexEd = new HexEd("se,sw,se,sw,sw");
        Assert.assertEquals(3, hexEd.calculate());
    }

    @Test
    public void testFive() {
        HexEd hexEd = new HexEd("n,n");
        Assert.assertEquals(2, hexEd.calculate());
    }

    @Test
    public void testSix() {
        HexEd hexEd = new HexEd("n,n,se");
        Assert.assertEquals(2, hexEd.calculate());
    }

}
