package nl.mwensveen.adventofcode.year_2017.day_14;

import org.junit.Assert;
import org.junit.Test;

public class DiskDefragmentationTest {

    @Test
    public void testOne() {
        DiskDefragmentation diskDefragmentation = new DiskDefragmentation("flqrgnkx");
        Assert.assertEquals(8108L, diskDefragmentation.calculate());
    }

    @Test
    public void testTwee() {
        DiskDefragmentation diskDefragmentation = new DiskDefragmentation("flqrgnkx");
        Assert.assertEquals(1242, diskDefragmentation.calculateGroups());
    }
}
