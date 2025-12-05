package nl.mwensveen.adventofcode.year_2025.day_01;

import java.util.List;
import nl.mwensveen.adventofcode.year_2025.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2025.FileReadHelper;

public class SecretEntranceSolution extends AbstractTimedSolution {

    private List<Rotation> input;

    @Override
    protected void init() {
        List<String> raw = FileReadHelper.readLinesAsStrings("day_01.txt");
        input = raw.stream().map(Rotation::new).toList();
    }

    @Override
    protected void part1() {
        long pwd = new PasswordCalculator().calculate(input);
        System.out.println("The actual password to open the door is: " + pwd);
    }

    @Override
    protected void part2() {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        new SecretEntranceSolution().run();

    }

}
