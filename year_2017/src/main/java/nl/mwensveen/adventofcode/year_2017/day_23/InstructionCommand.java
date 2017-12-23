package nl.mwensveen.adventofcode.year_2017.day_23;

public enum InstructionCommand {
    SET("set"),
    DECREASE("sub"),
    MULTIPLY("mul"),
    JUMP("jnz");
    private final String abbrivation;

    private InstructionCommand(String abbrivation) {
        this.abbrivation = abbrivation;
    }

    public static InstructionCommand find(String a) {
        for (InstructionCommand ic : InstructionCommand.values()) {
            if (ic.abbrivation.equals(a)) {
                return ic;
            }
        }
        throw new RuntimeException("InstructionCommand not found: " + a);
    }
}
