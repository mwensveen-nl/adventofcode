package nl.mwensveen.adventofcode.year_2021.day_04;

import java.util.List;
import nl.mwensveen.adventofcode.year_2021.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2021.FileReadHelper;

public class GiantSquidSolution extends AbstractTimedSolution {

    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("day_04.txt");
    }

    @Override
    protected void part1() {
        BingoGame bingoGame = new BingoGame();
        Integer result = bingoGame.playGameToWin(input);
        System.out.println("Final score of winning board: " + result);
    }

    @Override
    protected void part2() {
        BingoGame bingoGame = new BingoGame();
        Integer result = bingoGame.playGameToLose(input);
        System.out.println("Final score of last board to win: " + result);
    }

    public static void main(String[] args) {
        new GiantSquidSolution().run();
    }

}
