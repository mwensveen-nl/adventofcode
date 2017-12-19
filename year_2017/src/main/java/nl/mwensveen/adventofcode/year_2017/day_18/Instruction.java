package nl.mwensveen.adventofcode.year_2017.day_18;

import com.google.common.base.MoreObjects;

public class Instruction {
    private final InstructionCommand command;
    private final String register;
    private final String value;

    public Instruction(InstructionCommand command, String register, String value) {
        super();
        this.command = command;
        this.register = register;
        this.value = value;
    }

    public InstructionCommand getCommand() {
        return command;
    }

    public String getRegister() {
        return register;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("command", command).add("register", register).add("value", value).toString();
    }

}
