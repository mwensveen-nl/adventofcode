package nl.mwensveen.adventofcode.year_2020.day_22;

import java.util.List;
import nl.mwensveen.adventofcode.year_2020.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2020.FileReadHelper;

public class CrabCombatSolution extends AbstractTimedSolution {

    private List<Player> players;

    @Override
    protected void init() {
        List<String> input = FileReadHelper.readLinesAsStrings("Day_22.txt");
        InputParser inputParser = new InputParser();
        players = inputParser.parse(input);
    }

    @Override
    protected void part1() {
        CombatGame game = new CombatGame();
        Player winner = game.playGame(players);

        ScoreCalculator scoreCalculator = new ScoreCalculator();
        long result = scoreCalculator.calculateScore(winner);

        System.out.println("The winning player's score: " + result);
    }

    @Override
    protected void part2() {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        new CrabCombatSolution().run();
    }

}
