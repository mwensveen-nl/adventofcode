package nl.mwensveen.adventofcode.year_2020.day_22;

import java.util.List;
import nl.mwensveen.adventofcode.year_2020.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2020.FileReadHelper;

public class CrabCombatSolution extends AbstractTimedSolution {

    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("Day_22.txt");
    }

    @Override
    protected void part1() {
        InputParser inputParser = new InputParser();
        List<Player> players = inputParser.parse(input);

        CombatGame game = new CombatGame();
        Player winner = game.playGame(players);

        ScoreCalculator scoreCalculator = new ScoreCalculator();
        long result = scoreCalculator.calculateScore(winner);

        System.out.println("The winning player's score: " + result);
    }

    @Override
    protected void part2() {
        InputParser inputParser = new InputParser();
        List<Player> players = inputParser.parse(input);

        RecursiveCombatGame game = new RecursiveCombatGame();
        Player winner = game.playGame(players);

        ScoreCalculator scoreCalculator = new ScoreCalculator();
        long result = scoreCalculator.calculateScore(winner);

        System.out.println("The winning player's score: " + result);

    }

    public static void main(String[] args) {
        new CrabCombatSolution().run();
    }

}
