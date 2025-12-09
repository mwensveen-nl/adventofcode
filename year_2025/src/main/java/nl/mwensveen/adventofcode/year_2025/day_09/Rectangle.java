package nl.mwensveen.adventofcode.year_2025.day_09;

public record Rectangle(Tile one, Tile two, long area) {

    public Rectangle(Tile one, Tile two) {
        this(one, two, area(one, two));
    }

    private static long area(Tile tileOne, Tile tileTwo) {
        int side1 = Math.abs(tileOne.x() - tileTwo.x()) + 1;
        int side2 = Math.abs(tileOne.y() - tileTwo.y()) + 1;
        return 1L * side1 * side2;
    }

}
