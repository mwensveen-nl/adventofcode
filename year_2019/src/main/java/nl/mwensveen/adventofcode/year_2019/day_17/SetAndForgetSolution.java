package nl.mwensveen.adventofcode.year_2019.day_17;

import com.google.common.collect.Table;
import java.math.BigInteger;
import java.util.List;
import java.util.OptionalInt;
import nl.mwensveen.adventofcode.year_2019.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2019.FileReadHelper;

public class SetAndForgetSolution extends AbstractTimedSolution {

    @Override
    protected void part1() {
        IntcodeProgram intcodeProgram = new IntcodeProgram(FileReadHelper.readCSVBigIntegers("Day17.txt"), OptionalInt.of(1));
        CameraViewer cameraViewer = new CameraViewer(intcodeProgram);
        Table<Integer, Integer, OutputView> table = cameraViewer.view();

        ScaffoldProcessor scaffoldProcessor = new ScaffoldProcessor();
        int sumAlignmentParameters = scaffoldProcessor.sumAlignmentParameters(table);
        System.out.println("Sum of Alignment Parameters " + sumAlignmentParameters);

    }

    @Override
    protected void part2() {
        List<BigInteger> bigIntegers = FileReadHelper.readCSVBigIntegers("Day17.txt");
        bigIntegers.set(0, BigInteger.TWO);
        IntcodeProgram intcodeProgram = new IntcodeProgram(bigIntegers, OptionalInt.of(Integer.MAX_VALUE));
        VacuumRobotMover vacuumRobotMover = new VacuumRobotMover(intcodeProgram);
        BigInteger dust = vacuumRobotMover.visitScaffolds();
        System.out.println("Collected dust " + dust);
    }

    public static void main(String[] args) {
        SetAndForgetSolution solution = new SetAndForgetSolution();
        solution.run();
    }

}
