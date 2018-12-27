package nl.mwensveen.adventofcode.year_2018.day_19;

import java.util.List;

public class Instruction {
    private final OpCode opCode;
    private final List<Integer> numbers;

    public Instruction(OpCode opCode, List<Integer> numbers) {
        super();
        this.opCode = opCode;
        this.numbers = numbers;
    }

    public OpCode getOpCode() {
        return opCode;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
