package nl.mwensveen.adventofcode.year_2020.day_08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ProgramStatementParserTest {

    @Test
    public void testParse() throws Exception {
        ProgramStatementParser parser = new ProgramStatementParser();
        ProgramStatement programStatement = parser.parse("nop +0");
        assertEquals(Instruction.NOP, programStatement.getInstruction());
        assertEquals(0, programStatement.getArgument());
    }

    @Test
    public void testParse1() throws Exception {
        ProgramStatementParser parser = new ProgramStatementParser();
        ProgramStatement programStatement = parser.parse("acc +1");
        assertEquals(Instruction.ACC, programStatement.getInstruction());
        assertEquals(1, programStatement.getArgument());
    }

    @Test
    public void testParse2() throws Exception {
        ProgramStatementParser parser = new ProgramStatementParser();
        ProgramStatement programStatement = parser.parse("jmp -34");
        assertEquals(Instruction.JMP, programStatement.getInstruction());
        assertEquals(-34, programStatement.getArgument());
    }

}
