package nl.mwensveen.adventofcode.year_2020.day_19;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputProcessor {
    private Pattern AB = Pattern.compile("^[ab]+$");

    public Multimap<Integer, String> processRules(List<String> input) {
        Multimap<Integer, String> rules = ArrayListMultimap.create();
        input.stream().filter(s -> s.contains(":")).forEach(s -> addRule(s, rules));

        while (hasNotOnlyChars(rules.values())) {
            Collection<Entry<Integer, String>> entries = rules.entries();
            Multimap<Integer, String> newRules = ArrayListMultimap.create();
            for (Entry<Integer, String> entry : entries) {
                newRules.putAll(processEntry(rules, entry));
            }
            newRules.keySet().forEach(i -> {
                rules.removeAll(i);
                rules.putAll(i, newRules.get(i));
            });
        }
        return rules;
    }

    private Multimap<Integer, String> processEntry(Multimap<Integer, String> rules, Entry<Integer, String> entry) {
        Integer key = entry.getKey();
        String rule = entry.getValue();
        if (AB.matcher(rule).find()) {
            return newSingleRule(key, rule);
        }

        String[] ruleValues = rule.split(" ");
        boolean hasNumbers = !canReplace(rules, ruleValues);
        if (hasNumbers) {
            return newSingleRule(key, rule);
        }

        List<StringBuilder> sbs = new ArrayList<>();
        sbs.add(new StringBuilder());
        for (String rv : ruleValues) {
            List<StringBuilder> temp = new ArrayList<>();
            Collection<String> replacers = rules.get(Integer.parseInt(rv));
            for (StringBuilder sb : sbs) {
                replacers.forEach(rs -> temp.add(new StringBuilder().append(sb.toString()).append(rs)));
            }
            sbs = temp;
        }

        Multimap<Integer, String> newRules = ArrayListMultimap.create();
        sbs.forEach(sb -> newRules.put(key, sb.toString()));
        return newRules;
    }

    private Multimap<Integer, String> newSingleRule(Integer key, String rule) {
        Multimap<Integer, String> newRules = ArrayListMultimap.create();
        newRules.put(key, rule);
        return newRules;
    }

    private boolean canReplace(Multimap<Integer, String> rules, String[] split) {
        List<String> replaceRules = new ArrayList<>();
        for (String s : split) {
            replaceRules.addAll(rules.get(Integer.parseInt(s)));
        }
        return !hasNotOnlyChars(replaceRules);
    }

    private boolean hasNotOnlyChars(Collection<String> replaceRules) {
        return replaceRules.stream().filter(r -> !AB.matcher(r).matches()).findAny().isPresent();
    }

    private void addRule(String s, Multimap<Integer, String> rules) {
        int index = s.indexOf(":");
        Integer key = Integer.valueOf(s.substring(0, index));

        String rule = s.substring(index + 2);
        if (rule.contains("\"")) {
            rules.put(key, rule.substring(1, 2));
        } else {
            String[] ruleStrings = rule.split("\\|");
            for (String rs : ruleStrings) {
                rules.put(key, rs.trim());
            }
        }
    }

    public Collection<String> processMessages(List<String> input) {
        return input.stream().filter(s -> !s.contains(":") && !s.isEmpty()).collect(Collectors.toList());

    }

}
