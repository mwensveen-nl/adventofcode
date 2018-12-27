package nl.mwensveen.adventofcode.year_2018.day_19;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;

public class EQRI implements OpCode {

    @Override
    public List<Integer> perform(List<Integer> registersIn, List<Integer> instruction) {
        List<Integer> registersOut = new ArrayList<>(registersIn);
        registersOut.set(getTargetRegister(instruction), getFromRegister(registersIn, instruction, A).equals(getImmediate(instruction, B)) ? 1 : 0);
        return registersOut;

    }

    @Override
    public boolean equals(final Object other) {
        return other.getClass().equals(this.getClass());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getClass().getName());
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}
