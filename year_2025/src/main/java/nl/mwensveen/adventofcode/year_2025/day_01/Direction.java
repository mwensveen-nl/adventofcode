package nl.mwensveen.adventofcode.year_2025.day_01;

public enum Direction {
    LEFT("L"),
    RIGHT("R");

    private String value;

    Direction(String value) {
        this.value = value;
    }

    public static Direction find(String value) {
        for (Direction elem : Direction.values()) {
            if (elem.value.equals(value)) {
                return elem;
            }
        }
        throw new RuntimeException("Invalid Direction requested " + value);
    }

}
