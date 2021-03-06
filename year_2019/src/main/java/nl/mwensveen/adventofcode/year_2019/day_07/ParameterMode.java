package nl.mwensveen.adventofcode.year_2019.day_07;

public enum ParameterMode {
    POSITION(0),
    IMMEDIATE(1);

    private int number;

    private ParameterMode(int number) {
        this.number = number;
    }

    public static ParameterMode valueOf(int i) {
        for (ParameterMode element : ParameterMode.values()) {
            if (element.number == i) {
                return element;
            }
        }
        throw new RuntimeException("ParameterMode not found " + i);
    }
}
