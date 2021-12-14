package nl.mwensveen.adventofcode.year_2021.day_14;

import java.util.List;
import org.javatuples.Pair;

public class InputParser {

    Pair<String, List<InsertionRule>> parseInput(List<String> input) {
        return Pair.with(input.get(0), input.stream().skip(2).map(s -> createInsertionRule(s)).toList());
    }

    private InsertionRule createInsertionRule(String s) {
        String[] split = s.split("->");
        return new InsertionRule(split[0].trim(), split[1].trim());
    }
}
