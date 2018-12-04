package nl.mwensveen.adventofcode.year_2018.day_3;

import org.junit.Assert;
import org.junit.Test;

public class FabricClaimTest {

    @Test
    public void testParsing() {
        String txt = "#1323 @ 393,116: 1216x245";
        System.out.println(txt);
        FabricClaim fabricClaim = new FabricClaim(txt);
        Assert.assertEquals(new Integer(1323), fabricClaim.getId());
        Assert.assertEquals(new Integer(393), fabricClaim.getFromLeft());
        Assert.assertEquals(new Integer(116), fabricClaim.getFromTop());
        Assert.assertEquals(new Integer(1216), fabricClaim.getWide());
        Assert.assertEquals(new Integer(245), fabricClaim.getHeight());
        Assert.assertEquals(new Integer(1608), fabricClaim.getEndFromLeft());
        Assert.assertEquals(new Integer(360), fabricClaim.getEndFromTop());

    }
}
