package nl.mwensveen.adventofcode.year_2020.day_12;

import java.util.List;
import java.util.stream.Collectors;

public class InstructionParser {

    public List<Instruction> parseInstructions(List<String> input) {
        return input.stream().map(this::parseInstruction).collect(Collectors.toList());
    }

    public Instruction parseInstruction(String input) {
        return Instruction.builder().withActions(Direction.find(input.substring(0, 1))).withValue(Integer.valueOf(input.substring(1))).build();
    }
}
