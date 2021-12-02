package nl.mwensveen.adventofcode.year_2021.day_02;

public class Step {
    private final Direction direction;
    private final int number;

    public Step(String in) {
        int i = in.indexOf(" ");

        this.direction = Direction.valueOf(in.substring(0, i).toUpperCase());
        this.number = Integer.valueOf(in.substring(i + 1));
    }

    public Direction getDirection() {
        return direction;
    }

    public int getNumber() {
        return number;
    }

}
