package nl.mwensveen.adventofcode.year_2019.day_13;

import java.math.BigInteger;
import java.util.List;
import nl.mwensveen.adventofcode.year_2019.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2019.FileReadHelper;

public class CarePackageSolution extends AbstractTimedSolution {
    public static void main(String[] args) {
        CarePackageSolution solution = new CarePackageSolution();
        solution.run();
    }

    @Override
    protected void part1() {
        ScreenParser screenParser = new ScreenParser();
        List<GameInstruction> screen = screenParser.parseScreen(FileReadHelper.readCSVBigIntegers("Day13.txt"));
        long blocks = screenParser.countBlocks(screen);
        System.out.println("Number of blocks on screen = " + blocks);

    }

    @Override
    protected void part2() {
        List<BigInteger> input = FileReadHelper.readCSVBigIntegers("Day13.txt");
        input.set(0, BigInteger.valueOf(2));
        GamePayer gamePayer = new GamePayer(input);
        int score = gamePayer.playGame();
        System.out.println("Score after game = " + score);

    }

}
