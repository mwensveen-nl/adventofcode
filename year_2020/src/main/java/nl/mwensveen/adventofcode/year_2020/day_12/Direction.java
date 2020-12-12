package nl.mwensveen.adventofcode.year_2020.day_12;

public enum Direction {
    NORTH("N"),
    EAST("E"),
    SOUTH("S"),
    WEST("W"),
    LEFT("L"),
    RIGHT("R"),
    FORWARD("F");

    private String code;

    Direction(String code) {
        this.code = code;
    }

    public static Direction find(String code) {
        for (Direction elem : Direction.values()) {
            if (elem.code.equals(code)) {
                return elem;
            }
        }
        throw new RuntimeException("Invalid Direction requested " + code);
    }

}
