package nl.mwensveen.adventofcode.year_2024.day_05;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PrinterParser {

    public Multimap<Integer, Integer> parseRules(List<String> input) {
        Multimap<Integer, Integer> result = HashMultimap.create();
        input.stream().takeWhile(Predicate.not(String::isEmpty)).forEach(s -> {
            String[] split = s.split("\\|");
            result.put(Integer.valueOf(split[0]), Integer.valueOf(split[1]));
        });
        return result;
    }

    public List<List<Integer>> parseUpdates(List<String> input) {
        List<List<Integer>> result = new ArrayList<>();

        input.stream().dropWhile(Predicate.not(String::isEmpty)).skip(1).forEach(s -> result.add(toList(s)));
        return result;
    }

    private List<Integer> toList(String s) {
        String[] split = s.split(",");
        return Arrays.stream(split).map(Integer::valueOf).toList();
    }
}
