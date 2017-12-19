package nl.mwensveen.adventofcode.year_2017.day_18;

public enum InstructionCommand {
    SND("snd"),
    SET("set"),
    INCREASE("add"),
    MULTIPLY("mul"),
    REMAINDER("mod"),
    RCV("rcv"),
    JUMP("jgz");
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
