package nl.mwensveen.adventofcode.year_2017.day_11;

public enum Step {
    n(2, 0),
    ne(1, 1),
    se(-1, 1),
    s(-2, 0),
    sw(-1, -1),
    nw(1, -1);

    private final int x;
    private final int y;

    private Step(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

}
