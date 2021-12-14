package nl.mwensveen.adventofcode.year_2021.day_14;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.IntStream;
import org.javatuples.Pair;

public class PolymerRulesProcessor {

    long process(Pair<String, List<InsertionRule>> input, int steps) {
        String templateIn = input.getValue0();
        List<InsertionRule> rules = input.getValue1();
        Map<String, Long> template = init(templateIn);

        for (int i = 0; i < steps; i++) {
            Map<String, Long> newTemplate = new HashMap<>();
            for (InsertionRule rule : rules) {
                if (template.containsKey(rule.getInsertBetween())) {
                    merge(rule, template.get(rule.getInsertBetween()).longValue(), newTemplate);
                }
            }
            template = newTemplate;
        }

        addTemplate(template, templateIn.substring(0, 1));
        addTemplate(template, templateIn.substring(templateIn.length() - 1));

        Map<String, Long> countChars = countChars(template);
        Entry<String, Long> max = countChars.entrySet().stream().max(Comparator.comparingLong(e -> e.getValue())).get();
        Entry<String, Long> min = countChars.entrySet().stream().min(Comparator.comparingLong(e -> e.getValue())).get();
        long maxLong = max.getValue() / 2;
        long minLong = min.getValue() / 2;
        // if (max.getKey().equals(templateIn.subSequence(0, templateIn.length())) || max.getKey().equals(templateIn.substring(templateIn.length() - 1))) {
        // maxLong++;
        // }
        // if (min.getKey().equals(templateIn.subSequence(0, templateIn.length())) || min.getKey().equals(templateIn.substring(templateIn.length() - 1))) {
        // minLong++;
        // }
        return maxLong - minLong;
    }

    private Map<String, Long> countChars(Map<String, Long> template) {
        Map<String, Long> charMap = new HashMap<>();
        template.entrySet().forEach(entry -> addtoCharMap(entry, charMap));
        return charMap;
    }

    private void addtoCharMap(Entry<String, Long> entry, Map<String, Long> charMap) {
        String key = entry.getKey();
        charMap.merge(key.substring(0, 1), entry.getValue().longValue(), (v1, v2) -> v1.longValue() + v2.longValue());
        if (key.length() == 2) {
            charMap.merge(key.substring(1), entry.getValue().longValue(), (v1, v2) -> v1.longValue() + v2.longValue());
        }
    }

    private Map<String, Long> init(String templateIn) {
        Map<String, Long> template = new HashMap<>();
        IntStream.range(0, templateIn.length() - 1).forEach(i -> addTemplate(template, templateIn.substring(i, i + 2)));
        return template;
    }

    private void merge(InsertionRule rule, long count, Map<String, Long> newTemplate) {
        newTemplate.merge(rule.getBecomes().get(0), count, (prev, newCount) -> prev + newCount);
        newTemplate.merge(rule.getBecomes().get(1), count, (prev, newCount) -> prev + newCount);
    }

    private void addTemplate(Map<String, Long> template, String letters) {
        template.merge(letters, 1L, (prev, nextCount) -> prev + nextCount);
    }
}
