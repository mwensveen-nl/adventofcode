package nl.mwensveen.adventofcode.year_2020.day_03;

import java.util.List;
import nl.mwensveen.adventofcode.year_2020.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2020.FileReadHelper;

public class TobogganTrajectorySolution extends AbstractTimedSolution {

    private TobogganTrajectoryCalculator tobogganTrajectoryCalculator;

    public static void main(String[] args) {
        new TobogganTrajectorySolution().run();
    }

    public TobogganTrajectorySolution() {
        List<String> input = FileReadHelper.readLinesAsStrings("Day_03.txt");
        tobogganTrajectoryCalculator = new TobogganTrajectoryCalculator(input);
    }

    @Override
    protected void part1() {
        long numberOfTrees = tobogganTrajectoryCalculator.countNumberOfTrees(3, 1);
        System.out.println("Number of trees encountered " + numberOfTrees);
    }

    @Override
    protected void part2() {
        long numberOfTrees1 = tobogganTrajectoryCalculator.countNumberOfTrees(1, 1);
        long numberOfTrees2 = tobogganTrajectoryCalculator.countNumberOfTrees(3, 1);
        long numberOfTrees3 = tobogganTrajectoryCalculator.countNumberOfTrees(5, 1);
        long numberOfTrees4 = tobogganTrajectoryCalculator.countNumberOfTrees(7, 1);
        long numberOfTrees5 = tobogganTrajectoryCalculator.countNumberOfTrees(1, 2);

        long multi = numberOfTrees1 * numberOfTrees2 * numberOfTrees3 * numberOfTrees4 * numberOfTrees5;
        System.out.println("multipled together the number of trees encountered on each of the listed slopes: " + multi);
    }

}
