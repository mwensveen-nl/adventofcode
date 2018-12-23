package nl.mwensveen.adventofcode.year_2018.day_16;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class ADDITest {

    @Test
    public void testPerform() throws Exception {
        List<Integer> regIn = Arrays.asList(1, 2, 4, 8);
        List<Integer> inst = Arrays.asList(1, 1, 3, 3);
        ADDI addi = new ADDI();
        Assert.assertEquals(Arrays.asList(1, 2, 4, 5), addi.perform(regIn, inst));
        inst = Arrays.asList(1, 2, 1, 0);
        Assert.assertEquals(Arrays.asList(5, 2, 4, 8), addi.perform(regIn, inst));
    }

}
