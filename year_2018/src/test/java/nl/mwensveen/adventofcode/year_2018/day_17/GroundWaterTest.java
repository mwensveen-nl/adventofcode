package nl.mwensveen.adventofcode.year_2018.day_17;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class GroundWaterTest {

    @Test
    public void testGroundWater() throws Exception {
        List<String> input = Arrays.asList("x=495, y=2..7", "y=7, x=495..501", "x=501, y=3..7", "x=498, y=2..4", "x=506, y=1..2", "x=498, y=10..13",
                "x=504, y=10..13", "y=13, x=498..504");
        GroundWater groundWater = new GroundWater(input);
        Assert.assertEquals(57, groundWater.flowWater());
    }

    @Test
    public void testGroundWater2() throws Exception {
        List<String> input = Arrays.asList("y= 10, x=470..474", "y= 10, x=510..514", "x=475, y=29..42", "x=503, y=30..42", "x=486, y=32..38", "x=484, y=32..38",
                "y=38, x=484..486", "y=42, x=475..503");
        GroundWater groundWater = new GroundWater(input);
        Assert.assertEquals(370, groundWater.flowWater());
    }

}
