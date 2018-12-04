package nl.mwensveen.adventofcode.year_2018.day_3;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class FabricClaimAnalyserTest {

    @Test
    public void testGetTotals() throws Exception {
        FabricClaimAnalyser analyser = new FabricClaimAnalyser(Arrays.asList("#1 @ 1,3: 4x4", "#2 @ 3,1: 5x4", "#3 @ 5,5: 2x2"));
        Assert.assertEquals(new Integer(7), analyser.getTotalHeight());
        Assert.assertEquals(new Integer(8), analyser.getTotalWide());
    }

    @Test
    public void testCalculateOverlap() throws Exception {
        FabricClaimAnalyser analyser = new FabricClaimAnalyser(Arrays.asList("#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2"));
        Assert.assertEquals(4, analyser.calculateOverlap());
    }

    @Test
    public void testFindClaimWithoutOverlap() throws Exception {
        FabricClaimAnalyser analyser = new FabricClaimAnalyser(Arrays.asList("#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2"));
        Assert.assertEquals(new Integer(3), analyser.findClaimWithoutOverlap());
    }

}
