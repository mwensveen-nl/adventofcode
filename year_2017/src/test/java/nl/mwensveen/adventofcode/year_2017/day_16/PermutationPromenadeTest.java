package nl.mwensveen.adventofcode.year_2017.day_16;

import java.util.Date;
import org.junit.Assert;
import org.junit.Test;

public class PermutationPromenadeTest {

    @Test
    public void testOne() {
        System.out.println(new Date());
        PermutationPromenade permutationPromenade = new PermutationPromenade("s1,x3/4,pe/b", 5);
        Assert.assertEquals("baedc", permutationPromenade.calculate());
        System.out.println(new Date());
    }

    @Test
    public void testTwo() {
        PermutationPromenade permutationPromenade = new PermutationPromenade("s1,x3/4,pe/b", 5);
        Assert.assertEquals("ceadb", permutationPromenade.calculateRepeating(2));
    }
}
