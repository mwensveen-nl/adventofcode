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

    @Test
    public void testProgramInputEquals8PositionModeFalse() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(1);
        Integer result = prog.process(Arrays.asList(3, 9, 8, 9, 10, 9, 4, 9, 99, -1, 8));
        assertEquals(0, result);
    }

    @Test
    public void testProgramInputEquals8PositionModeTrue() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(8);
        Integer result = prog.process(Arrays.asList(3, 9, 8, 9, 10, 9, 4, 9, 99, -1, 8));
        assertEquals(1, result);
    }

    @Test
    public void testProgramInputLessThan8PositionModeFalse() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(1);
        Integer result = prog.process(Arrays.asList(3, 9, 7, 9, 10, 9, 4, 9, 99, -1, 8));
        assertEquals(0, result);
    }

    @Test
    public void testProgramInputLessThan8PositionModeTrue() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(8);
        Integer result = prog.process(Arrays.asList(3, 9, 7, 9, 10, 9, 4, 9, 99, -1, 8));
        assertEquals(1, result);
    }

    @Test
    public void testProgramInputEquals8ImmediateModeFalse() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(1);
        Integer result = prog.process(Arrays.asList(3, 3, 1108, -1, 8, 3, 4, 3, 99));
        assertEquals(0, result);
    }

    @Test
    public void testProgramInputEquals8ImmediateModeTrue() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(8);
        Integer result = prog.process(Arrays.asList(3, 3, 1108, -1, 8, 3, 4, 3, 99));
        assertEquals(1, result);
    }

    @Test
    public void testProgramInputLessThan8ImmediateModeFalse() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(1);
        Integer result = prog.process(Arrays.asList(3, 3, 1107, -1, 8, 3, 4, 3, 99));
        assertEquals(0, result);
    }

    @Test
    public void testProgramInputLessThan8ImmediateModeTrue() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(8);
        Integer result = prog.process(Arrays.asList(3, 3, 1107, -1, 8, 3, 4, 3, 99));
        assertEquals(1, result);
    }

}
