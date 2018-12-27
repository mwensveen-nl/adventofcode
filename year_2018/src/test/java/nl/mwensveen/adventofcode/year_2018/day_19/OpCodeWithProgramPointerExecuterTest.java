package nl.mwensveen.adventofcode.year_2018.day_19;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class OpCodeWithProgramPointerExecuterTest {

    @Test
    public void testExecuteInstructions() throws Exception {
        List<String> input = Arrays.asList("seti 5 0 1", "seti 6 0 2", "addi 0 1 0", "addr 1 2 3", "setr 1 0 0", "seti 8 0 4", "seti 9 0 5");
        OpCodeWithProgramPointerExecuter executer = new OpCodeWithProgramPointerExecuter("#ip 0", input);
        Assert.assertEquals(6, executer.executeInstructions().intValue());
    }

}
