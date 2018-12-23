package nl.mwensveen.adventofcode.year_2018.day_16;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class ADDRTest {

    @Test
    public void testPerform() throws Exception {
        List<Integer> regIn = Arrays.asList(1, 2, 4, 8);
        List<Integer> inst = Arrays.asList(1, 1, 3, 3);
        OpCode opCode = new ADDR();
        Assert.assertEquals(Arrays.asList(1, 2, 4, 10), opCode.perform(regIn, inst));
        inst = Arrays.asList(1, 2, 1, 0);
        Assert.assertEquals(Arrays.asList(6, 2, 4, 8), opCode.perform(regIn, inst));
    }

}
