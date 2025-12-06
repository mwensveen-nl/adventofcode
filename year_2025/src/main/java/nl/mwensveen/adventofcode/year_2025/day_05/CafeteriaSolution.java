package nl.mwensveen.adventofcode.year_2025.day_05;

import java.util.List;
import nl.mwensveen.adventofcode.year_2025.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2025.FileReadHelper;
import org.javatuples.Pair;

public class CafeteriaSolution extends AbstractTimedSolution {

    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("day_05.txt");
    }

    @Override
    protected void part1() {
        Pair<List<IngredientRange>, List<Long>> pair = new IngredientListParser().parse(input);
        long fresh = new FreshIngredientFinder().findFresh(pair);
        System.out.println("The number of the available ingredient IDs that are fresh " + fresh);
    }

    @Override
    protected void part2() {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        new CafeteriaSolution().run();
    }

}
