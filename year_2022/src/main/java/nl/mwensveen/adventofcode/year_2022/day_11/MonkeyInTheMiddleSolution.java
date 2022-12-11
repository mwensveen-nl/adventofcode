package nl.mwensveen.adventofcode.year_2022.day_11;

import java.util.List;
import nl.mwensveen.adventofcode.year_2022.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2022.FileReadHelper;

public class MonkeyInTheMiddleSolution extends AbstractTimedSolution {

    private List<String> input;
    private Game game;
    private MonkeyParser monkeyParser = new MonkeyParser();

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("day11.txt");
    }

    @Override
    protected void part1() {
        List<Monkey> monkeys = monkeyParser.parseMonkeys(input);
        game = new Game();
        game.play(monkeys, 20);
        int monkeyBusiness = game.calculateMonkeyBusiness(monkeys);
        System.out.println("The level of monkey business after 20 rounds of stuff-slinging simian shenanigans: " + monkeyBusiness);
    }

    @Override
    protected void part2() {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        new MonkeyInTheMiddleSolution().run();
    }

}
