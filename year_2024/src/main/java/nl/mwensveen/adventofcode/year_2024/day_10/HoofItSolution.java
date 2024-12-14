package nl.mwensveen.adventofcode.year_2024.day_10;

import com.google.common.collect.Table;
import java.util.List;
import nl.mwensveen.adventofcode.year_2024.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2024.FileReadHelper;

public class HoofItSolution extends AbstractTimedSolution {

    private List<String> input;
    private Table<Long, Long, Integer> map;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("Day_10.txt");
        map = new MapParser().map(input);
    }

    @Override
    protected void part1() {
        int result = new HikingTrailFinder().countTrails(map);
        System.out.println("the sum of the scores of all trailheads on the topographic map: " + result);
    }

    @Override
    protected void part2() {
        int result = new HikingRatingFinder().countRatings(map);
        System.out.println("the sum of the ratings of all trailheads: " + result);
    }

    public static void main(String[] args) {
        new HoofItSolution().run();

    }

}
