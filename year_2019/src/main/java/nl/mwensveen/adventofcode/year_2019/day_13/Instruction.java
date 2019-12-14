package nl.mwensveen.adventofcode.year_2019.day_13;

import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;
import java.math.BigInteger;

public class Instruction {

    String base;
    private Opcode opcode;
    private ParameterMode parameterMode1;
    private ParameterMode parameterMode2;
    private ParameterMode parameterMode3;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("base", base).add("opcode", opcode).add("parameterMode1", parameterMode1)
                .add("parameterMode2", parameterMode2).add("parameterMode3", parameterMode3).toString();
    }

    public Instruction(BigInteger baseValue) {
        this.base = Strings.padStart(baseValue.toString(), 5, '0');
        opcode = Opcode.valueOf(Integer.parseInt(this.base.substring(3)));
        parameterMode1 = ParameterMode.valueOf(Integer.parseInt(this.base.substring(2, 3)));
        parameterMode2 = ParameterMode.valueOf(Integer.parseInt(this.base.substring(1, 2)));
        parameterMode3 = ParameterMode.valueOf(Integer.parseInt(this.base.substring(0, 1)));
    }

    public Opcode getOpcode() {
        return opcode;
    }

    public ParameterMode getParameterMode1() {
        return parameterMode1;
    }

    public ParameterMode getParameterMode2() {
        return parameterMode2;
    }

    public ParameterMode getParameterMode3() {
        return parameterMode3;
    }

}
