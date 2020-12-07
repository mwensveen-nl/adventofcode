package nl.mwensveen.adventofcode.year_2020.day_07;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BagEncloserFinder {

    private static final String MY_BAG_COLOR = "shiny gold";

    public long findNumberOfEncloserBags(Collection<BagRule> rules) {
        Set<String> foundColors = new HashSet<>();
        foundColors.add(MY_BAG_COLOR);
        boolean found = true;
        while (found) {
            List<String> newFound = new ArrayList<>();
            found = false;
            for (String color : foundColors) {
                for (BagRule bagRule : rules) {
                    if (!foundColors.contains(bagRule.getColor()) && bagRule.containsColor(color)) {
                        newFound.add(bagRule.getColor());
                        found = true;
                    }
                }
            }
            foundColors.addAll(newFound);
        }
        foundColors.remove(MY_BAG_COLOR);
        return foundColors.size();
    }

    public long findNumberOfBagsInside(Map<String, BagRule> rules) {
        return countBags(MY_BAG_COLOR, rules);
    }

    private long countBags(String bagColor, Map<String, BagRule> rules) {
        long numberInBag = 0;
        BagRule bagRule = rules.get(bagColor);
        List<BagContents> bags = bagRule.getContains();
        for (BagContents bagContents : bags) {
            numberInBag += bagContents.getNumber();
            numberInBag += bagContents.getNumber() * countBags(bagContents.getColor(), rules);
        }

        return numberInBag;
    }
}
