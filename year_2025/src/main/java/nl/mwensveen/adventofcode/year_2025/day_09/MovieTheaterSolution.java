package nl.mwensveen.adventofcode.year_2025.day_09;

import java.util.List;
import nl.mwensveen.adventofcode.year_2025.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2025.FileReadHelper;

public class MovieTheaterSolution extends AbstractTimedSolution {

    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("day_09.txt");
    }

    @Override
    protected void part1() {
        var tiles = input.stream().map(Tile::new).toList();
        long size = new RedTileRectangler().find(tiles);
        System.out.println("The largest area of any rectangle you can make is: " + size);
    }

    @Override
    protected void part2() {
        var tiles = input.stream().map(Tile::new).toList();
        long size = new RedGreenTileRectangler().find(tiles);
        System.out.println("The largest area of any rectangle you can make using only red and green tiles is: " + size);
    }

    public static void main(String[] args) {
        new MovieTheaterSolution().run();
    }

}
