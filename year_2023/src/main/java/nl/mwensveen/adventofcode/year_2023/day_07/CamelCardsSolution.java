package nl.mwensveen.adventofcode.year_2023.day_07;

import java.util.List;
import nl.mwensveen.adventofcode.year_2023.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2023.FileReadHelper;

public class CamelCardsSolution extends AbstractTimedSolution {

    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("Day_06.txt");
    }

    @Override
    protected void part1() {
        List<HandBid> handBids = new GameParser().parse(input);
        long result = new GamePlayer().playGame(handBids);
        System.out.println("The total winnings: " + result);

    }

    @Override
    protected void part2() {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        new CamelCardsSolution().run();
    }

}
