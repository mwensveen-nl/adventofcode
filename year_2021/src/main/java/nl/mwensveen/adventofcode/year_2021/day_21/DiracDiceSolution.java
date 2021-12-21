package nl.mwensveen.adventofcode.year_2021.day_21;

import java.util.List;
import nl.mwensveen.adventofcode.year_2021.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2021.FileReadHelper;

public class DiracDiceSolution extends AbstractTimedSolution {

    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("day_21.txt");
    }

    @Override
    protected void part1() {
        Game game = new Game();
        long result = game.playGame(input, 1000);
        System.out.println("Result of multiply the score of the losing player by the number of times the die was rolled during the game: " + result);
    }

    @Override
    protected void part2() {
        Game game = new Game();
        long result = game.playGameQuantum(input, 21);
        System.out.println("The number of universes he wining player wins in: " + result);
    }

    public static void main(String[] args) {
        new DiracDiceSolution().run();
    }

}
