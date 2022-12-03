package nl.mwensveen.adventofcode.year_2022.day_03;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Optional;

public class RucksackInspector {

    private static final int VALUE_UPPERCASE = 'A';
    private static final int VALUE_LOWERCASE = 'a';

    public int inspectSingleRucksacks(List<String> input) {
        return input.stream().mapToInt(this::inspectRucksackCompartments).sum();
    }

    public int inspectTripleRucksacks(List<String> input) {
        List<List<String>> partitions = Lists.partition(input, 3);
        return partitions.stream().mapToInt(p -> this.inspectRucksackTriple(p.get(0), p.get(1), p.get(2))).sum();
    }

    public int inspectRucksackCompartments(String contents) {
        String first = contents.substring(0, contents.length() / 2);
        String second = contents.substring(contents.length() / 2);

        Optional<String> both = first.chars().mapToObj(c -> String.valueOf((char) c)).filter(s -> second.contains(s)).findFirst();
        return getPriority(both.get());
    }

    public int inspectRucksackTriple(String contents1, String contents2, String contents3) {
        Optional<String> all = contents1.chars().mapToObj(c -> String.valueOf((char) c)).filter(s -> contents2.contains(s)).filter(s -> contents3.contains(s)).findFirst();
        return getPriority(all.get());
    }

    private int getPriority(String item) {
        char c = item.charAt(0);
        if (Character.isUpperCase(c)) {
            return 27 + c - VALUE_UPPERCASE;
        }
        return 1 + c - VALUE_LOWERCASE;
    }
}
