package nl.mwensveen.adventofcode.year_2021.day_17;

import java.util.List;
import nl.mwensveen.adventofcode.year_2021.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2021.FileReadHelper;

public class TrickShotSolution extends AbstractTimedSolution {

    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("day_17.txt");
    }

    @Override
    protected void part1() {
        Trajectory trajectory = new Trajectory();
        int result = trajectory.findHightsTrajectory(input.get(0));
        System.out.println("Highest y position the probe reaches on this trajectory: " + result);
    }

    @Override
    protected void part2() {
        Trajectory trajectory = new Trajectory();
        int result = trajectory.findNumberOfVelocities(input.get(0));
        System.out.println("Number ofdistinct initial velocity values cause the probe to be within the target area after any step: " + result);
    }

    public static void main(String[] args) {
        new TrickShotSolution().run();
    }

}
