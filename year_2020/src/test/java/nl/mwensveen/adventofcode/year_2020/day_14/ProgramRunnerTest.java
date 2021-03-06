package nl.mwensveen.adventofcode.year_2020.day_14;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ProgramRunnerTest {

    @Test
    public void testRunProgramVersionOne() throws Exception {
        List<String> input = Arrays.asList("mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X", "mem[8] = 11", "mem[7] = 101", "mem[8] = 0");
        ProgramRunner programRunner = new ProgramRunner();
        BigInteger result = programRunner.runProgramVersionOne(input);
        assertEquals(165L, result.longValue());
    }

    @Test
    public void testRunProgramVersionOne2() throws Exception {
        List<String> input = Arrays.asList("mask = 111000000110X1010010011XX100X0000001", "mem[12805] = 6015", "mem[20190] = 106469491", "mem[11123] = 8571",
                "mem[16350] = 3024", "mem[37958] = 29213622");
        ProgramRunner programRunner = new ProgramRunner();
        BigInteger result = programRunner.runProgramVersionOne(input);
        assertEquals(301186426117L, result.longValue());
    }

    @Test
    public void testRunProgramVersionTwo() throws Exception {
        List<String> input = Arrays.asList("mask = 000000000000000000000000000000X1001X",
                "mem[42] = 100",
                "mask = 00000000000000000000000000000000X0XX",
                "mem[26] = 1");
        ProgramRunner programRunner = new ProgramRunner();
        BigInteger result = programRunner.runProgramVersionTwo(input);
        assertEquals(208L, result.longValue());
    }

}
