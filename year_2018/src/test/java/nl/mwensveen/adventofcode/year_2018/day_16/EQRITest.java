package nl.mwensveen.adventofcode.year_2018.day_16;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class EQRITest {

    @Test
    public void testPerform() throws Exception {
        OpCode opCode = new EQRI();
        List<Integer> regIn = Arrays.asList(1, 3, 4, 8);
        List<Integer> inst = Arrays.asList(1, 3, 2, 3);
        Assert.assertEquals(Arrays.asList(1, 3, 4, 0), opCode.perform(regIn, inst));
        inst = Arrays.asList(1, 1, 3, 0);
        Assert.assertEquals(Arrays.asList(1, 3, 4, 8), opCode.perform(regIn, inst));
    }

}
