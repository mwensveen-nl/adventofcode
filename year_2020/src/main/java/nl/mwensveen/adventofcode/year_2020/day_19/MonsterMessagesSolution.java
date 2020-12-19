package nl.mwensveen.adventofcode.year_2020.day_19;

import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.List;
import nl.mwensveen.adventofcode.year_2020.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2020.FileReadHelper;

public class MonsterMessagesSolution extends AbstractTimedSolution {

    private List<String> input;
    private Multimap<Integer, String> rules;
    private Collection<String> messages;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("Day_19.txt");
        InputProcessor inputProcessor = new InputProcessor();
        rules = inputProcessor.processRules(input);
        messages = inputProcessor.processMessages(input);
    }

    @Override
    protected void part1() {
        RuleValidator validator = new RuleValidator();
        long result = validator.validate(rules.get(Integer.valueOf(0)), messages);
        System.out.println("Number of messages completely match rule 0 = " + result);

    }

    @Override
    protected void part2() {
        RuleValidator validator = new RuleValidator();
        long result = validator.validateInfinite(rules, messages);
        System.out.println("Number of messages completely match rule 0 with Infinity = " + result);
    }

    public static void main(String[] args) {
        new MonsterMessagesSolution().run();
    }

}
