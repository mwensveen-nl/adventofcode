package nl.mwensveen.adventofcode.year_2021.day_20;

import java.util.List;
import nl.mwensveen.adventofcode.year_2021.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2021.FileReadHelper;

public class TrenchMapSolution extends AbstractTimedSolution {

    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("day_20.txt");
    }

    @Override
    protected void part1() {
        ImageEnhancer imageEnhancer = new ImageEnhancer();
        long result = imageEnhancer.enhanceImage(input, 2);
        System.out.println("Number of pixels that are lit in the resulting image: " + result);
    }

    @Override
    protected void part2() {
        ImageEnhancer imageEnhancer = new ImageEnhancer();
        long result = imageEnhancer.enhanceImage(input, 50);
        System.out.println("Number of pixels that are lit in the resulting image: " + result);

    }

    public static void main(String[] args) {
        new TrenchMapSolution().run();
    }
}
