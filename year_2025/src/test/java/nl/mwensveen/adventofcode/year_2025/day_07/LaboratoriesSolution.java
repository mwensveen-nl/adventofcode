package nl.mwensveen.adventofcode.year_2025.day_07;

import java.util.List;
import nl.mwensveen.adventofcode.year_2025.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2025.FileReadHelper;

public class LaboratoriesSolution extends AbstractTimedSolution {

    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("day_07.txt");
    }

    @Override
    protected void part1() {
        var tmp = new TachyonManifoldParser();
        var manifold = tmp.parse(input);
        var start = tmp.findStart(manifold);

        var mover = new TachyonBeamMover();
        var result = mover.moveDown(manifold, start);
        System.out.println("The number of times the beam will be split: " + result);
    }

    @Override
    protected void part2() {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        new LaboratoriesSolution().run();
    }

}
