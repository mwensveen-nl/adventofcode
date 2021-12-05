package nl.mwensveen.adventofcode.year_2021.day_05;

public record Line(int x1, int y1, int x2, int y2) {

    public boolean isHorizontal() {
        return this.x1 == x2;
    }

    public boolean isVertical() {
        return this.y1 == y2;
    }
}
