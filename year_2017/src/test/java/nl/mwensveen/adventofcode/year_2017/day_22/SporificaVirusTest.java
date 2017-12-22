package nl.mwensveen.adventofcode.year_2017.day_22;

import org.junit.Assert;
import org.junit.Test;

public class SporificaVirusTest {

    @Test
    public void testOne() {
        SporificaVirus sporificaVirus = new SporificaVirus("..#\n" +
                "#..\n" +
                "...");
        Assert.assertEquals(5, sporificaVirus.calculate(7));
    }

    @Test
    public void testTwo() {
        SporificaVirus sporificaVirus = new SporificaVirus("..#\n" +
                "#..\n" +
                "...");
        Assert.assertEquals(41, sporificaVirus.calculate(70));
    }

    @Test
    public void testThree() {
        SporificaVirus sporificaVirus = new SporificaVirus("..#\n" +
                "#..\n" +
                "...");
        Assert.assertEquals(5587, sporificaVirus.calculate(10000));
    }

    @Test
    public void testFour() {
        SporificaVirus sporificaVirus = new SporificaVirus("..#\n" +
                "#..\n" +
                "...");
        Assert.assertEquals(26, sporificaVirus.calculateEvolved(100));
    }

    @Test
    public void testFive() {
        SporificaVirus sporificaVirus = new SporificaVirus("..#\n" +
                "#..\n" +
                "...");
        Assert.assertEquals(2511944, sporificaVirus.calculateEvolved(10000000));
    }
}
