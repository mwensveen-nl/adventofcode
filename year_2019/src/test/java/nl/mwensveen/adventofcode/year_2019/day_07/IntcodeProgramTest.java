package nl.mwensveen.adventofcode.year_2019.day_07;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class IntcodeProgramTest {

    @Test
    public void testProcess1() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(1, Arrays.asList(3, 0, 4, 0, 99));
        Integer result = prog.process(false, 2);
        assertEquals(1, result);
    }

    @Test
    public void testProcess2() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(1, Arrays.asList(3, 0, 4, 0, 3, 0, 4, 0, 99));
        Integer result = prog.process(false, 2);
        assertEquals(2, result);
    }

    @Test
    public void testProcess3() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(1, Arrays.asList(3, 0, 4, 0, 3, 0, 4, 0, 3, 0, 4, 0, 99));
        Integer result = prog.process(false, 2);
        assertEquals(2, result);
    }

    @Test
    public void testProcessPausing() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(1, Arrays.asList(3, 0, 4, 0, 3, 0, 4, 0, 99));
        Integer result = prog.process(true, 2);
        assertEquals(1, result);
        assertFalse(prog.isExit());
        result = prog.process(true, 3);
        assertEquals(3, result);
        assertFalse(prog.isExit());
        result = prog.process(true, 4);
        assertEquals(3, result);
        assertTrue(prog.isExit());
    }
}
