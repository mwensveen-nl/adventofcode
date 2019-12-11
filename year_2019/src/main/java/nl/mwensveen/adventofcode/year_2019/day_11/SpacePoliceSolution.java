package nl.mwensveen.adventofcode.year_2019.day_11;

import java.util.OptionalInt;
import nl.mwensveen.adventofcode.year_2019.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2019.FileReadHelper;

public class SpacePoliceSolution extends AbstractTimedSolution {
    public static void main(String[] args) {
        SpacePoliceSolution solution = new SpacePoliceSolution();
        solution.run();
    }

    @Override
    protected void part1() {
        IntcodeProgram intcodeProgram = new IntcodeProgram(FileReadHelper.readCSVBigIntegers("Day11.txt"), OptionalInt.of(2));
        Robot robot = new Robot(intcodeProgram);
        int result = robot.emergencyHullPainting(Color.BLACK);
        System.out.println("Number of unique panels painted " + result);
    }

    @Override
    protected void part2() {
        IntcodeProgram intcodeProgram = new IntcodeProgram(FileReadHelper.readCSVBigIntegers("Day11.txt"), OptionalInt.of(2));
        Robot robot = new Robot(intcodeProgram);
        robot.emergencyHullPainting(Color.WHITE);
        ExternalShipCamera camera = new ExternalShipCamera(robot.getHull());
        camera.showHull();
    }

}
