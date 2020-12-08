package nl.mwensveen.adventofcode.year_2020.day_08;

public enum Instruction {
    ACC("acc"),
    JMP("jmp"),
    NOP("nop");

    private String code;

    Instruction(String code) {
        this.code = code;
    }

    public static Instruction find(String code) {
        for (Instruction elem : Instruction.values()) {
            if (elem.code.equals(code)) {
                return elem;
            }
        }
        throw new RuntimeException("Invalid Instruction requested " + code);
    }
}
