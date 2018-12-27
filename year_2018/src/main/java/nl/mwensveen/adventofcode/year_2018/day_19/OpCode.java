package nl.mwensveen.adventofcode.year_2018.day_19;

import java.util.List;

public interface OpCode {
    static final int A = 0;
    static final int B = 1;
    static final int C = 2;

    List<Integer> perform(List<Integer> registersIn, List<Integer> instruction);

    default Integer getFromRegister(List<Integer> registersIn, List<Integer> instruction, int index) {
        return registersIn.get(instruction.get(index));
    }

    default Integer getImmediate(List<Integer> instruction, int index) {
        return instruction.get(index);
    }

    default int getTargetRegister(List<Integer> instruction) {
        return instruction.get(C);
    }

    default String name() {
        return this.getClass().getSimpleName();
    }
}
