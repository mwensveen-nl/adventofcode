package nl.mwensveen.adventofcode.year_2019.day_13;

public enum Tile {

    EMPTY(0, "."),
    WALL(1, "#"),
    BLOCK(2, "*"),
    HORIZONTALPADDLE(3, "-"),
    BALL(4, "o");

    private int number;
    private String icon;

    private Tile(int number, String icon) {
        this.number = number;
        this.icon = icon;
    }

    public static Tile valueOf(int n) {
        for (Tile elem : Tile.values()) {
            if (elem.number == n) {
                return elem;
            }
        }
        throw new RuntimeException("Invalid tile number " + n);
    }

    public String getIcon() {
        return icon;
    }
}
