package nl.mwensveen.adventofcode.year_2020.day_12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class InstructionParserTest {

    @Test
    public void testParseInstruction() throws Exception {
        InstructionParser instructionParser = new InstructionParser();
        Instruction instruction = instructionParser.parseInstruction("F10");
        assertEquals(Direction.FORWARD, instruction.getAction());
        assertEquals(Integer.valueOf(10), instruction.getValue());
    }

    @Test
    public void testParseInstructions() throws Exception {
        List<String> input = Arrays.asList("F10", "N3", "F7", "R90", "F11");
        InstructionParser instructionParser = new InstructionParser();
        List<Instruction> instructions = instructionParser.parseInstructions(input);
        assertEquals(5, instructions.size());
    }

}
