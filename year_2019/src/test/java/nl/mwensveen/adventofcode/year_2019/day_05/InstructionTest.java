package nl.mwensveen.adventofcode.year_2019.day_05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class InstructionTest {

    @Test
    public void testInstruction() throws Exception {
        Instruction inst = new Instruction(1002);
        assertEquals(Opcode.MULTIPLY, inst.getOpcode());
        assertEquals(ParameterMode.POSITION, inst.getParameterMode1());
        assertEquals(ParameterMode.IMMEDIATE, inst.getParameterMode2());
        assertEquals(ParameterMode.POSITION, inst.getParameterMode3());
    }

    @Test
    public void testInstruction2() throws Exception {
        Instruction inst = new Instruction(10102);
        assertEquals(Opcode.MULTIPLY, inst.getOpcode());
        assertEquals(ParameterMode.IMMEDIATE, inst.getParameterMode1());
        assertEquals(ParameterMode.POSITION, inst.getParameterMode2());
        assertEquals(ParameterMode.IMMEDIATE, inst.getParameterMode3());
    }

    @Test
    public void testInstruction3() throws Exception {
        Instruction inst = new Instruction(3);
        assertEquals(Opcode.INPUT, inst.getOpcode());
        assertEquals(ParameterMode.POSITION, inst.getParameterMode1());
        assertEquals(ParameterMode.POSITION, inst.getParameterMode2());
        assertEquals(ParameterMode.POSITION, inst.getParameterMode3());
    }

}
