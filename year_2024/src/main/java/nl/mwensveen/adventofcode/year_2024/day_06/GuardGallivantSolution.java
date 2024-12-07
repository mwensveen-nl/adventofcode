package nl.mwensveen.adventofcode.year_2024.day_06;

import com.google.common.collect.Table;
import java.util.List;
import nl.mwensveen.adventofcode.year_2024.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2024.FileReadHelper;

public class GuardGallivantSolution extends AbstractTimedSolution {

    private List<String> input;
    private Guard guard;
    private Table<Integer, Integer, Cell> lm;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("Day_06.txt");
        LabMapParser lmp = new LabMapParser();
        lm = lmp.parse(input);
        guard = lmp.findGuard(lm);

    }

    @Override
    protected void part1() {
        GuardMover guardMover = new GuardMover();
        int result = guardMover.moveGuard(lm, guard);
        System.out.println("Number of distinct positions that the guard will have visit before leaving the mapped area: " + result);
    }

    @Override
    protected void part2() {
        Table<Integer, Integer, Cell> lmMoved = lm;
        init();

        GuardMover guardMover = new GuardMover();

        int count = guardMover.placeObstructionsAndMove(lmMoved, guard);
        System.out.println("Number of different positions you can choose for this obstruction: " + count);
    }

    public static void main(String[] args) {
        new GuardGallivantSolution().run();

    }
}
