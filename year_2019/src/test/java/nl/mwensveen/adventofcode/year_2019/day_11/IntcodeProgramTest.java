package nl.mwensveen.adventofcode.year_2019.day_11;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import org.junit.jupiter.api.Test;

public class IntcodeProgramTest {

    private List<BigInteger> result;

    @Test
    public void testProcess() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(asList(1002, 4, 3, 4, 33), OptionalInt.empty());
        List<BigInteger> result = prog.process(1);
        assertEquals(0, result.size());
    }

    private BigInteger getLast(List<BigInteger> result) {
        return result.get(result.size() - 1);
    }

    private List<BigInteger> asList(Integer... ints) {
        ArrayList<BigInteger> bigints = new ArrayList<>();
        for (Integer integer : ints) {
            bigints.add(BigInteger.valueOf(integer));
        }
        return bigints;
    }

    @Test
    public void testProcess2() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(asList(1002, 8, 3, 8, 3, 9, 4, 9, 33, 0), OptionalInt.empty());
        BigInteger result = getLast(prog.process(1));
        assertEquals(BigInteger.valueOf(1), result);
    }

    @Test
    public void testProcess1() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(asList(3, 0, 4, 0, 99), OptionalInt.empty());
        BigInteger result = getLast(prog.process(1));
        assertEquals(BigInteger.valueOf(1), result);
    }

    @Test
    public void testProgramInputEquals8PositionModeFalse() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(asList(3, 9, 8, 9, 10, 9, 4, 9, 99, -1, 8), OptionalInt.empty());
        BigInteger result = getLast(prog.process(1));
        assertEquals(BigInteger.valueOf(0), result);
    }

    @Test
    public void testProgramInputEquals8PositionModeTrue() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(asList(3, 9, 8, 9, 10, 9, 4, 9, 99, -1, 8), OptionalInt.empty());
        BigInteger result = getLast(prog.process(8));
        assertEquals(BigInteger.valueOf(1), result);
    }

    @Test
    public void testProgramInputLessThan8PositionModeFalse() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(asList(3, 9, 7, 9, 10, 9, 4, 9, 99, -1, 8), OptionalInt.empty());
        BigInteger result = getLast(prog.process(1));
        assertEquals(BigInteger.valueOf(1), result);
    }

    @Test
    public void testProgramInputLessThan8PositionModeTrue() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(asList(3, 9, 7, 9, 10, 9, 4, 9, 99, -1, 8), OptionalInt.empty());
        BigInteger result = getLast(prog.process(8));
        assertEquals(BigInteger.valueOf(0), result);
    }

    @Test
    public void testProgramInputEquals8ImmediateModeFalse() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(asList(3, 3, 1108, -1, 8, 3, 4, 3, 99), OptionalInt.empty());
        BigInteger result = getLast(prog.process(1));
        assertEquals(BigInteger.valueOf(0), result);
    }

    @Test
    public void testProgramInputEquals8ImmediateModeTrue() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(asList(3, 3, 1108, -1, 8, 3, 4, 3, 99), OptionalInt.empty());
        BigInteger result = getLast(prog.process(8));
        assertEquals(BigInteger.valueOf(1), result);
    }

    @Test
    public void testProgramInputLessThan8ImmediateModeFalse() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(asList(3, 3, 1107, -1, 8, 3, 4, 3, 99), OptionalInt.empty());
        BigInteger result = getLast(prog.process(1));
        assertEquals(BigInteger.valueOf(1), result);
    }

    @Test
    public void testProgramInputLessThan8ImmediateModeTrue() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(asList(3, 3, 1107, -1, 8, 3, 4, 3, 99), OptionalInt.empty());
        BigInteger result = getLast(prog.process(8));
        assertEquals(BigInteger.valueOf(0), result);
    }

    @Test
    public void testProgramInputEqualsPositionTrue() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(asList(3, 12, 6, 12, 15, 1, 13, 14, 13, 4, 13, 99, -1, 0, 1, 9), OptionalInt.empty());
        BigInteger result = getLast(prog.process(0));
        assertEquals(BigInteger.valueOf(0), result);
    }

    @Test
    public void testProgramInputEqualsImmediateTrue() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(asList(3, 3, 1105, -1, 9, 1101, 0, 0, 12, 4, 12, 99, 1), OptionalInt.empty());
        BigInteger result = getLast(prog.process(0));
        assertEquals(BigInteger.valueOf(0), result);
    }

    @Test
    public void testProgramInputEquals0PositionFalse() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(asList(3, 12, 6, 12, 15, 1, 13, 14, 13, 4, 13, 99, -1, 0, 1, 9), OptionalInt.empty());
        BigInteger result = getLast(prog.process(2));
        assertEquals(BigInteger.valueOf(1), result);
    }

    @Test
    public void testProgramInputEquals0ImmediateFalse() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(asList(3, 3, 1105, -1, 9, 1101, 0, 0, 12, 4, 12, 99, 1), OptionalInt.empty());
        BigInteger result = getLast(prog.process(2));
        assertEquals(BigInteger.valueOf(1), result);
    }

    @Test
    public void testProgramLargeBelow8() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(asList(3, 21, 1008, 21, 8, 20, 1005, 20, 22, 107, 8, 21, 20, 1006, 20, 31, 1106, 0, 36, 98, 0, 0, 1002, 21,
                125, 20, 4, 20, 1105, 1, 46, 104, 999, 1105, 1, 46, 1101, 1000, 1, 20, 4, 20, 1105, 1, 46, 98, 99), OptionalInt.of(3));
        BigInteger result = getLast(prog.process(7));
        assertEquals(BigInteger.valueOf(999), result);
    }

    @Test
    public void testProgramLargeEquals() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(asList(3, 21, 1008, 21, 8, 20, 1005, 20, 22, 107, 8, 21, 20, 1006, 20, 31, 1106, 0, 36, 98, 0, 0, 1002, 21,
                125, 20, 4, 20, 1105, 1, 46, 104, 999, 1105, 1, 46, 1101, 1000, 1, 20, 4, 20, 1105, 1, 46, 98, 99), OptionalInt.empty());
        BigInteger result = getLast(prog.process(8));
        assertEquals(BigInteger.valueOf(1000), result);
    }

    @Test
    public void testProgramLargeGreatherThan() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(asList(3, 21, 1008, 21, 8, 20, 1005, 20, 22, 107, 8, 21, 20, 1006, 20, 31, 1106, 0, 36, 98, 0, 0, 1002, 21,
                125, 20, 4, 20, 1105, 1, 46, 104, 999, 1105, 1, 46, 1101, 1000, 1, 20, 4, 20, 1105, 1, 46, 98, 99), OptionalInt.empty());
        BigInteger result = getLast(prog.process(9));
        assertEquals(BigInteger.valueOf(1001), result);
    }

    @Test
    public void testProgramRelativeOffset() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(asList(109, 1, 204, -1, 1001, 100, 1, 100, 1008, 100, 16, 101, 1006, 101, 0, 99), OptionalInt.empty());
        BigInteger result = getLast(prog.process(0));
        assertEquals(BigInteger.valueOf(99), result);
    }

    @Test
    public void testProgramRelativeOffset2() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(asList(1102, 34915192, 34915192, 7, 4, 7, 99, 0), OptionalInt.empty());
        BigInteger result = getLast(prog.process(0));
        assertTrue(result.compareTo(BigInteger.valueOf(1000000000000000L)) >= 0);
        assertTrue(result.compareTo(BigInteger.valueOf(9999999999999999L)) <= 0);
    }

    @Test
    public void testProgramRelativeOffset3() throws Exception {
        ArrayList<BigInteger> bigints = new ArrayList<>();
        bigints.add(BigInteger.valueOf(104));
        bigints.add(BigInteger.valueOf(1125899906842624L));
        bigints.add(BigInteger.valueOf(99));
        IntcodeProgram prog = new IntcodeProgram(bigints, OptionalInt.empty());
        BigInteger result = getLast(prog.process(0));
        assertTrue(result.compareTo(BigInteger.valueOf(1125899906842624L)) == 0);
    }

    @Test
    public void testProcessMoreOutput() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(asList(1002, 10, 3, 10, 3, 11, 4, 11, 4, 11, 33, 0), OptionalInt.of(2));
        result = prog.process(1);
        assertEquals(BigInteger.valueOf(1), result.get(0));
        assertEquals(BigInteger.valueOf(1), result.get(1));
    }

    @Test
    public void testProcessWithBreak() throws Exception {
        IntcodeProgram prog = new IntcodeProgram(asList(1002, 12, 3, 12, 3, 13, 4, 13, 3, 13, 4, 13, 33, 0), OptionalInt.of(1));
        result = prog.process(1);
        assertEquals(1, result.size());
        assertEquals(BigInteger.valueOf(1), result.get(0));
        assertEquals(1, result.size());
        result = prog.process(2);
        assertEquals(BigInteger.valueOf(2), result.get(0));
    }
}
