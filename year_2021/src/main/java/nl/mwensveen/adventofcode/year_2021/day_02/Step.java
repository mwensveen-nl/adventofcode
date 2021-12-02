package nl.mwensveen.adventofcode.year_2021.day_02;

public record Step(Direction direction, int number) {

    public static Step parse(String in) {
        int i = in.indexOf(" ");
        return new Step(Direction.valueOf(in.substring(0, i).toUpperCase()), Integer.valueOf(in.substring(i + 1)));
    }

}
