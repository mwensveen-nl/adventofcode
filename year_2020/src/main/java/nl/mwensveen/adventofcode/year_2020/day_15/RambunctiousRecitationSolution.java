package nl.mwensveen.adventofcode.year_2020.day_15;

import java.util.Arrays;
import java.util.List;
import nl.mwensveen.adventofcode.year_2020.AbstractTimedSolution;

public class RambunctiousRecitationSolution extends AbstractTimedSolution {

    private List<Long> input;

    public static void main(String[] args) {
        new RambunctiousRecitationSolution().run();
    }

    @Override
    protected void init() {
        input = Arrays.asList(19L, 0L, 5L, 1L, 10L, 13L);
    }

    @Override
    protected void part1() {
        GamePlayer gamePlayer = new GamePlayer();
        Long result = gamePlayer.findNumber(2020, input);
        System.out.println("The 2020th number spoken = " + result);
    }

    @Override
    protected void part2() {
        GamePlayer gamePlayer = new GamePlayer();
        Long result = gamePlayer.findNumber(30000000, input);
        System.out.println("The 30000000th number spoken = " + result);
    }

}
