package nl.mwensveen.adventofcode.year_2019.day_05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class IntcodeProgramTest {

    @Test
    public void testProcess() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(1);
        Integer result = prog.process(Arrays.asList(1002, 4, 3, 4, 33));
        assertEquals(Integer.MIN_VALUE, result);
    }

    @Test
    public void testProcess2() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(1);
        Integer result = prog.process(Arrays.asList(1002, 8, 3, 8, 3, 9, 4, 9, 33, 0));
        assertEquals(1, result);
    }

    @Test
    public void testProcess1() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(1);
        Integer result = prog.process(Arrays.asList(3, 0, 4, 0, 99));
        assertEquals(1, result);
    }

}
