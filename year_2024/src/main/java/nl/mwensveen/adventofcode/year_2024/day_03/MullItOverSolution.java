package nl.mwensveen.adventofcode.year_2024.day_03;

import java.util.List;
import nl.mwensveen.adventofcode.year_2024.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2024.FileReadHelper;

public class MullItOverSolution extends AbstractTimedSolution {

    private List<Mutiply> multipliers;
    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("Day_03.txt");
        System.out.println(input);
    }

    @Override
    protected void part1() {
        MultiplyParser multiplyParser = new MultiplyParser();
        String all = String.join("", input);
        multipliers = multiplyParser.parseProgram(all);
        MultiplyProgram multiplyProgram = new MultiplyProgram();
        long result = multiplyProgram.multiply(multipliers);
        System.out.println("Result when you add up all of the results of the multiplications: " + result);

    }

    @Override
    protected void part2() {
        MultiplyParser multiplyParser = new MultiplyParser();
        String all = String.join("", input);
        multipliers = multiplyParser.parseProgramDoDont(all);
        MultiplyProgram multiplyProgram = new MultiplyProgram();
        long result = multiplyProgram.multiply(multipliers);
        System.out.println("Result when you add up all of the results of the enabled multiplications: " + result);
    }

    public static void main(String[] args) {
        new MullItOverSolution().run();

    }

}
