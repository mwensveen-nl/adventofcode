package nl.mwensveen.adventofcode.year_2017.day_18;

import org.junit.Assert;
import org.junit.Test;

public class DuetTest {
    @Test
    public void testOne() {
        Duet duet = new Duet("set a 1\n" +
                "add a 2\n" +
                "mul a a\n" +
                "mod a 5\n" +
                "snd a\n" +
                "set a 0\n" +
                "rcv a\n" +
                "jgz a -1\n" +
                "set a 1\n" +
                "jgz a -2");
        Assert.assertEquals(Long.valueOf(4), duet.calculate());
    }

    @Test
    public void testTwo() {
        Duet duet = new Duet("snd 1\n" +
                "snd 2\n" +
                "snd p\n" +
                "rcv a\n" +
                "rcv b\n" +
                "rcv c\n" +
                "rcv d");
        Assert.assertEquals(Integer.valueOf(3), duet.calculateSendReceive());
    }
}
