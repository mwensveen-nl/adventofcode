package nl.mwensveen.adventofcode.year_2019.day_07;

public enum Opcode {
    ADD(1, 3),
    MULTIPLY(2, 3),
    INPUT(3, 1),
    OUTPUT(4, 1),
    JUMP_IF_TRUE(5, 2),
    JUMP_IF_FALSE(6, 2),
    LESS_THEN(7, 3),
    EQUALS(8, 3),
    STOP(99, 0);

    private int code;
    private int numberOfParameters;

    Opcode(int i, int numberOfParameters) {
        this.code = i;
        this.numberOfParameters = numberOfParameters;
    }

    public static Opcode valueOf(int i) {
        for (Opcode op : Opcode.values()) {
            if (op.code == i) {
                return op;
            }
        }
        throw new RuntimeException("Unknown opcode " + i);
    }

    public int getNumberOfParameters() {
        return numberOfParameters;
    }

}
