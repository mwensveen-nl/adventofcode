package nl.mwensveen.adventofcode.year_2020.day_08;

import java.util.List;
import java.util.stream.Collectors;
import nl.mwensveen.adventofcode.year_2020.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2020.FileReadHelper;
import nl.mwensveen.adventofcode.year_2020.day_08.BootCodeRunner.Result;

public class HandheldHaltingSolution extends AbstractTimedSolution {
    private List<ProgramStatement> programStatements;

    private BootCodeRunner bootCodeRunner = new BootCodeRunner();

    public static void main(String[] args) {
        new HandheldHaltingSolution().run();
    }

    @Override
    protected void init() {
        List<String> input = FileReadHelper.readLinesAsStrings("Day_08.txt");
        ProgramStatementParser parser = new ProgramStatementParser();
        programStatements = input.stream().map(parser::parse).collect(Collectors.toList());
    }

    @Override
    protected void part1() {
        Result result = bootCodeRunner.runBootCode(programStatements);
        System.out.println("Value in the accumulator after infinite loop:  " + result.getAccumulator());
    }

    @Override
    protected void part2() {
        Result result = bootCodeRunner.findWrongStatement(programStatements);
        System.out.println("Value in the accumulator after program termination: " + result.getAccumulator());
    }

}
