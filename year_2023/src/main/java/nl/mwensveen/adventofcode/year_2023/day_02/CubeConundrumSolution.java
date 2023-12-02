package nl.mwensveen.adventofcode.year_2023.day_02;

import com.google.common.collect.Table;
import java.util.List;
import nl.mwensveen.adventofcode.year_2023.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2023.FileReadHelper;

public class CubeConundrumSolution extends AbstractTimedSolution {

    private Table<Integer, Integer, CubeGrab> games;

    @Override
    protected void init() {
        List<String> input = FileReadHelper.readLinesAsStrings("Day_02.txt");
        GameParser gameParser = new GameParser();
        games = gameParser.parseGames(input);
    }

    @Override
    protected void part1() {
        GameAnalyzer analyzer = new GameAnalyzer();
        long sum = analyzer.analyzePosibleGames(games);
        System.out.println("he sum of the IDs of the games that would have been possible if the bag had been loaded with only 12 red cubes, 13 green cubes, and 14 blue cubes: " + sum);
    }

    @Override
    protected void part2() {
        GameAnalyzer analyzer = new GameAnalyzer();
        long sum = analyzer.analyzePowerGames(games);
        System.out.println("The sum of the power of the minimum set of cubes that must have been present for each game: " + sum);
    }

    public static void main(String[] args) {
        new CubeConundrumSolution().run();
    }
}
