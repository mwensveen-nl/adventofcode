package nl.mwensveen.adventofcode.year_2020.day_07;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import nl.mwensveen.adventofcode.year_2020.day_07.BagRule.Builder;

public class BagRuleParser {

    private static final String BAGS_CONTAIN = "bags contain";
    private static final String BAG = "bag";
    private static final String NO_BAGS = "no other bags";

    public Map<String, BagRule> parseBagRules(List<String> input) {
        List<BagRule> list = input.stream().map(s -> parse(s)).collect(Collectors.toList());

        Map<String, BagRule> ruleMap = new HashMap<>();
        list.forEach(br -> ruleMap.put(br.getColor(), br));
        return ruleMap;
    }

    public BagRule parse(String input) {
        Builder builder = BagRule.builder();
        int i = input.indexOf(BAGS_CONTAIN);
        builder.withColor(input.substring(0, i).trim());

        String containsString = input.substring(i + BAGS_CONTAIN.length()).trim();
        if (!containsString.startsWith(NO_BAGS)) {
            parseContains(builder, containsString);
        }
        return builder.build();
    }

    private void parseContains(Builder builder, String containsString) {
        String[] splittedContains = containsString.split(",");
        for (String sc : splittedContains) {
            sc = sc.trim();
            int number = Integer.valueOf(sc.substring(0, 1));
            int i2 = sc.indexOf(BAG);
            String color = sc.substring(1, i2).trim();
            builder.addContains(BagContents.builder().withNumber(number).withColor(color).build());
        }
    }
}
