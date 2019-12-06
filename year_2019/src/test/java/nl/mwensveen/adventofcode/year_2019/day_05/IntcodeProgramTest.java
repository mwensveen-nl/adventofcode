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
        assertEquals(1, result);
    }

    @Test
    public void testProgramInputLessThan8PositionModeTrue() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(8);
        Integer result = prog.process(Arrays.asList(3, 9, 7, 9, 10, 9, 4, 9, 99, -1, 8));
        assertEquals(0, result);
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
        assertEquals(1, result);
    }

    @Test
    public void testProgramInputLessThan8ImmediateModeTrue() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(8);
        Integer result = prog.process(Arrays.asList(3, 3, 1107, -1, 8, 3, 4, 3, 99));
        assertEquals(0, result);
    }

    @Test
    public void testProgramInputEqualsPositionTrue() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(0);
        Integer result = prog.process(Arrays.asList(3, 12, 6, 12, 15, 1, 13, 14, 13, 4, 13, 99, -1, 0, 1, 9));
        assertEquals(0, result);
    }

    @Test
    public void testProgramInputEqualsImmediateTrue() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(0);
        Integer result = prog.process(Arrays.asList(3, 3, 1105, -1, 9, 1101, 0, 0, 12, 4, 12, 99, 1));
        assertEquals(0, result);
    }

    @Test
    public void testProgramInputEquals0PositionFalse() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(2);
        Integer result = prog.process(Arrays.asList(3, 12, 6, 12, 15, 1, 13, 14, 13, 4, 13, 99, -1, 0, 1, 9));
        assertEquals(1, result);
    }

    @Test
    public void testProgramInputEquals0ImmediateFalse() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(2);
        Integer result = prog.process(Arrays.asList(3, 3, 1105, -1, 9, 1101, 0, 0, 12, 4, 12, 99, 1));
        assertEquals(1, result);
    }

    @Test
    public void testProgramLargeBelow8() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(7);
        Integer result = prog.process(Arrays.asList(3, 21, 1008, 21, 8, 20, 1005, 20, 22, 107, 8, 21, 20, 1006, 20, 31, 1106, 0, 36, 98, 0, 0, 1002, 21, 125,
                20, 4, 20, 1105, 1, 46, 104, 999, 1105, 1, 46, 1101, 1000, 1, 20, 4, 20, 1105, 1, 46, 98, 99));
        assertEquals(999, result);
    }

    @Test
    public void testProgramLargeEquals() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(8);
        Integer result = prog.process(Arrays.asList(3, 21, 1008, 21, 8, 20, 1005, 20, 22, 107, 8, 21, 20, 1006, 20, 31, 1106, 0, 36, 98, 0, 0, 1002, 21, 125,
                20, 4, 20, 1105, 1, 46, 104, 999, 1105, 1, 46, 1101, 1000, 1, 20, 4, 20, 1105, 1, 46, 98, 99));
        assertEquals(1000, result);
    }

    @Test
    public void testProgramLargeGreatherThan() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(9);
        Integer result = prog.process(Arrays.asList(3, 21, 1008, 21, 8, 20, 1005, 20, 22, 107, 8, 21, 20, 1006, 20, 31, 1106, 0, 36, 98, 0, 0, 1002, 21, 125,
                20, 4, 20, 1105, 1, 46, 104, 999, 1105, 1, 46, 1101, 1000, 1, 20, 4, 20, 1105, 1, 46, 98, 99));
        assertEquals(1001, result);
    }
}
