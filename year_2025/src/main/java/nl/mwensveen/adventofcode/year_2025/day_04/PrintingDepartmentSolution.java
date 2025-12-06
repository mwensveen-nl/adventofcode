package nl.mwensveen.adventofcode.year_2025.day_04;

import com.google.common.collect.Table;
import java.util.List;
import nl.mwensveen.adventofcode.year_2025.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2025.FileReadHelper;

public class PrintingDepartmentSolution extends AbstractTimedSolution {

    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("day_04.txt");
    }

    @Override
    protected void part1() {
        Table<Integer, Integer, Character> diagram = new PaperRollDiagramInputParser().parse(input);
        int accessable = new ForkliftsAccessFinder().findAccessable(diagram);
        System.out.println("Number of rolls of paper that can be accessed by a forklift: " + accessable);
    }

    @Override
    protected void part2() {
        Table<Integer, Integer, Character> diagram = new PaperRollDiagramInputParser().parse(input);
        int accessable = new ForkliftsAccessFinder().findAccessableWithRemove(diagram);
        System.out.println("Number of rolls of paper in total that can be removed by the Elves and their forklifts: " + accessable);

    }

    public static void main(String[] args) {
        new PrintingDepartmentSolution().run();
    }

}
