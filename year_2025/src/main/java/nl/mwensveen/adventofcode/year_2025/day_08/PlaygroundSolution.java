package nl.mwensveen.adventofcode.year_2025.day_08;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;
import nl.mwensveen.adventofcode.year_2025.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2025.FileReadHelper;

public class PlaygroundSolution extends AbstractTimedSolution {

    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("day_08.txt");
    }

    @Override
    protected void part1() {
        var parser = new JunctionBoxesParser();
        var coords = parser.parse(input);
        List<Distance> distances = parser.toDistance(coords);

        CircuitCalculator circuitCalculator = new CircuitCalculator();
        List<? extends Set<Coordinate>> circuits = circuitCalculator.calculate(distances, coords, 1000);
        BigInteger result = circuitCalculator.multiplyLargest(circuits, 3);
        System.out.println("If you multiply together the sizes of the three largest circuits, you get: " + result);
    }

    @Override
    protected void part2() {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        new PlaygroundSolution().run();
    }

}
