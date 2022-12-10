package nl.mwensveen.adventofcode.year_2022.day_10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgramExecutionTest {
    private static String input = """
            addx 15
            addx -11
            addx 6
            addx -3
            addx 5
            addx -1
            addx -8
            addx 13
            addx 4
            noop
            addx -1
            addx 5
            addx -1
            addx 5
            addx -1
            addx 5
            addx -1
            addx 5
            addx -1
            addx -35
            addx 1
            addx 24
            addx -19
            addx 1
            addx 16
            addx -11
            noop
            noop
            addx 21
            addx -15
            noop
            noop
            addx -3
            addx 9
            addx 1
            addx -3
            addx 8
            addx 1
            addx 5
            noop
            noop
            noop
            noop
            noop
            addx -36
            noop
            addx 1
            addx 7
            noop
            noop
            noop
            addx 2
            addx 6
            noop
            noop
            noop
            noop
            noop
            addx 1
            noop
            noop
            addx 7
            addx 1
            noop
            addx -13
            addx 13
            addx 7
            noop
            addx 1
            addx -33
            noop
            noop
            noop
            addx 2
            noop
            noop
            noop
            addx 8
            noop
            addx -1
            addx 2
            addx 1
            noop
            addx 17
            addx -9
            addx 1
            addx 1
            addx -3
            addx 11
            noop
            noop
            addx 1
            noop
            addx 1
            noop
            noop
            addx -13
            addx -19
            addx 1
            addx 3
            addx 26
            addx -30
            addx 12
            addx -1
            addx 3
            addx 1
            noop
            noop
            noop
            addx -9
            addx 18
            addx 1
            addx 2
            noop
            noop
            addx 9
            noop
            noop
            noop
            addx -1
            addx 2
            addx -37
            addx 1
            addx 3
            noop
            addx 15
            addx -21
            addx 22
            addx -6
            addx 1
            noop
            addx 2
            addx 1
            noop
            addx -10
            noop
            noop
            addx 20
            addx 1
            addx 2
            addx 2
            addx -6
            addx -11
            noop
            noop
            noop
                        """;
    private ProgramExecution programExecution = new ProgramExecution();

    @Test
    public void testExecuteInstruction() {
        Cycle c = new Cycle(0, 0, 1, 1);

        c = programExecution.executeInstruction("noop", c);

        assertEquals(1, c.begin());
        assertEquals(1, c.end());
        assertEquals(1, c.beginValue());
        assertEquals(1, c.endValue());

        c = programExecution.executeInstruction("addx 3", c);

        assertEquals(2, c.begin());
        assertEquals(3, c.end());
        assertEquals(1, c.beginValue());
        assertEquals(4, c.endValue());

        c = programExecution.executeInstruction("addx -5", c);

        assertEquals(4, c.begin());
        assertEquals(5, c.end());
        assertEquals(4, c.beginValue());
        assertEquals(-1, c.endValue());

    }

    @Test
    public void testEvaluateCycleBegin() {
        Cycle c = new Cycle(20, 22, 4, 5);

        EvaluateCycle evalCycle = new EvaluateCycle();
        assertEquals(20, evalCycle.getCycleNumber());
        evalCycle = programExecution.evaluateCycle(c, evalCycle);
        assertEquals(80, evalCycle.getSum());
        assertEquals(60, evalCycle.getCycleNumber());
    }

    @Test
    public void testEvaluateCycleMiddle() {
        Cycle c = new Cycle(19, 21, 4, 5);

        EvaluateCycle evalCycle = new EvaluateCycle();
        assertEquals(20, evalCycle.getCycleNumber());
        evalCycle = programExecution.evaluateCycle(c, evalCycle);
        assertEquals(80, evalCycle.getSum());
        assertEquals(60, evalCycle.getCycleNumber());
    }

    @Test
    public void testEvaluateCycleEnd() {
        Cycle c = new Cycle(19, 20, 4, 5);

        EvaluateCycle evalCycle = new EvaluateCycle();
        assertEquals(20, evalCycle.getCycleNumber());
        evalCycle = programExecution.evaluateCycle(c, evalCycle);
        assertEquals(80, evalCycle.getSum());
        assertEquals(60, evalCycle.getCycleNumber());

    }

    @Test
    public void testExecuteSummingProgram() {
        int sum = programExecution.executeSummingProgram(input.lines().toList());
        assertEquals(13140, sum);
    }

    @Test
    public void testExecuteDrawingProgram() {
        CRTscreen crtScreen = programExecution.executeDrawingProgram(input.lines().toList());
        assertEquals("##..##..##..##..##..##..##..##..##..##..", crtScreen.getRow(0));
        assertEquals("###...###...###...###...###...###...###.", crtScreen.getRow(1));
        assertEquals("####....####....####....####....####....", crtScreen.getRow(2));
        assertEquals("#####.....#####.....#####.....#####.....", crtScreen.getRow(3));
        assertEquals("######......######......######......####", crtScreen.getRow(4));
        assertEquals("#######.......#######.......#######.....", crtScreen.getRow(5));
    }
}
