package nl.mwensveen.adventofcode.year_2019.day_11;

public enum Color {
    BLACK(0),
    WHITE(1);

    private final int number;

    private Color(int number) {
        this.number = number;
    }

    public static Color find(int colorNumber) {
        for (Color element : Color.values()) {
            if (element.number == colorNumber) {
                return element;
            }
        }
        throw new RuntimeException("Unknown color " + colorNumber);
    }

    public int getNumber() {
        return number;
    }

}
