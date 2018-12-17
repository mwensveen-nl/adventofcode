package nl.mwensveen.adventofcode.year_2018.day_10;

public class Point {
    private final Integer x;
    private final Integer y;
    private final Velocity velocity;

    public Point(Integer x, Integer y, Velocity velocity) {
        super();
        this.x = x;
        this.y = y;
        this.velocity = velocity;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Velocity getVelocity() {
        return velocity;
    }

}
