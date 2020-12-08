package nl.mwensveen.adventofcode.year_2020.day_08;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import nl.mwensveen.adventofcode.year_2020.day_08.BootCodeRunner.Result;
import org.junit.jupiter.api.Test;

public class BootCodeRunnerTest {

    @Test
    public void testRunBootCode() throws Exception {
        ProgramStatementParser parser = new ProgramStatementParser();
        List<ProgramStatement> sts = Arrays.asList(
                parser.parse("nop +0"),
                parser.parse("acc +1"),
                parser.parse("jmp +4"),
                parser.parse("acc +3"),
                parser.parse("jmp -3"),
                parser.parse("acc -99"),
                parser.parse("acc +1"),
                parser.parse("jmp -4"),
                parser.parse("acc +6"));
        BootCodeRunner bootCodeRunner = new BootCodeRunner();
        Result result = bootCodeRunner.runBootCode(sts);
        assertEquals(5, result.getAccumulator());
        assertTrue(result.isInfiniteLoop());
    }

    @Test
    public void testFindWrongStatement() throws Exception {
        ProgramStatementParser parser = new ProgramStatementParser();
        List<ProgramStatement> sts = Arrays.asList(
                parser.parse("nop +0"),
                parser.parse("acc +1"),
                parser.parse("jmp +4"),
                parser.parse("acc +3"),
                parser.parse("jmp -3"),
                parser.parse("acc -99"),
                parser.parse("acc +1"),
                parser.parse("jmp -4"),
                parser.parse("acc +6"));
        BootCodeRunner bootCodeRunner = new BootCodeRunner();
        Result result = bootCodeRunner.findWrongStatement(sts);
        assertEquals(8, result.getAccumulator());
        assertFalse(result.isInfiniteLoop());
    }

}
