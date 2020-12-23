package nl.mwensveen.adventofcode.year_2020.day_23;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import nl.mwensveen.adventofcode.year_2020.AbstractTimedSolution;

public class CrabCupsSolution extends AbstractTimedSolution {

    private List<Integer> input;

    @Override
    protected void init() {
        String inputString = "398254716";
        input = Arrays.asList(inputString.split("")).stream().map(Integer::valueOf).collect(Collectors.toList());

    }

    @Override
    protected void part1() {
        CupsGame cupsGame = new CupsGame();
        String result = cupsGame.playGame(input, 100);
        System.out.println("The labels on the cups after cup 1: " + result);
    }

    @Override
    protected void part2() {
        CupsGame cupsGame = new CupsGame();
        long result = cupsGame.playGameMillion(input, 10000000);
        System.out.println("Multiplication of the two cups that end up immediately clockwise of cup 1 gives: " + result);
    }

    public static void main(String[] args) {
        new CrabCupsSolution().run();
    }

}
