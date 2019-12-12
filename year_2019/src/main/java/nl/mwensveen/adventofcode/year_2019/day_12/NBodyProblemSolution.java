package nl.mwensveen.adventofcode.year_2019.day_12;

import java.util.List;
import nl.mwensveen.adventofcode.year_2019.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2019.FileReadHelper;

public class NBodyProblemSolution extends AbstractTimedSolution {
    public static void main(String[] args) {
        NBodyProblemSolution solution = new NBodyProblemSolution();
        solution.run();
    }

    @Override
    protected void part1() {
        MoonParser moonParser = new MoonParser();
        List<Moon> moons = moonParser.parseMoons(FileReadHelper.readLines("Day12.txt"));

        MotionSimulator motionSimulator = new MotionSimulator(moons);
        int result = motionSimulator.simulate(1000);

        System.out.println("Total energy after 1000 step " + result);
    }

    @Override
    protected void part2() {
        // TODO Auto-generated method stub

    }

}
