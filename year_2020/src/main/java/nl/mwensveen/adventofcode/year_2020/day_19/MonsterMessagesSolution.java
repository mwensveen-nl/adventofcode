package nl.mwensveen.adventofcode.year_2020.day_19;

import java.util.Collection;
import java.util.List;
import nl.mwensveen.adventofcode.year_2020.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2020.FileReadHelper;

public class MonsterMessagesSolution extends AbstractTimedSolution {

    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("Day_19.txt");
    }

    @Override
    protected void part1() {
        InputProcessor inputProcessor = new InputProcessor();
        Collection<String> rules = inputProcessor.processRules(input);
        Collection<String> messages = inputProcessor.processMessages(input);
        RuleValidator validator = new RuleValidator();
        long result = validator.validate(rules, messages);
        System.out.println("Number of messages completely match rule 0 = " + result);

    }

    @Override
    protected void part2() {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        new MonsterMessagesSolution().run();
    }

}
