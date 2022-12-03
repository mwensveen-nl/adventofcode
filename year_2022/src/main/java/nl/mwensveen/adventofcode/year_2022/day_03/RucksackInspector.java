package nl.mwensveen.adventofcode.year_2022.day_03;

import java.util.List;
import java.util.Optional;

public class RucksackInspector {

    private static final int VALUE_UPPERCASE = 'A';
    private static final int VALUE_LOWERCASE = 'a';

    public int inspectRucksacks(List<String> input) {
        return input.stream().mapToInt(this::inspectRucksackCompartments).sum();
    }

    public int inspectRucksackCompartments(String contents) {
        String first = contents.substring(0, contents.length() / 2);
        String second = contents.substring(contents.length() / 2);

        Optional<String> both = first.chars().mapToObj(c -> String.valueOf((char) c)).filter(s -> second.contains(s)).findFirst();
        return getPriority(both.get());
    }

    private int getPriority(String item) {
        char c = item.charAt(0);
        if (Character.isUpperCase(c)) {
            return 27 + c - VALUE_UPPERCASE;
        }
        return 1 + c - VALUE_LOWERCASE;
    }
}
