package nl.mwensveen.adventofcode.year_2017.day_13;

import org.junit.Assert;
import org.junit.Test;

public class PacketScannersTest {
    @Test
    public void testOne() {
        PacketScanners packetScanners = new PacketScanners("0: 3\n" +
                "1: 2\n" +
                "4: 4\n" +
                "6: 4");
        Assert.assertEquals(24, packetScanners.calculate());
        Assert.assertEquals(10, packetScanners.calculateDelay());
    }

}
