package nl.mwensveen.adventofcode.year_2024.day_05;

import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.List;

public class UpdatePrinter {

    public long checkUpdates(Multimap<Integer, Integer> rules, List<List<Integer>> updates) {
        return updates.stream().filter(l -> isValid(l, rules)).mapToInt(u -> u.get((u.size() - 1) / 2)).sum();
    }

    private boolean isValid(List<Integer> l, Multimap<Integer, Integer> rules) {
        for (int i = 1; i < l.size(); i++) {
            List<Integer> subList = l.subList(0, i);
            Collection<Integer> collection = rules.get(l.get(i));
            boolean noneMatch = collection.stream().noneMatch(r -> subList.contains(r));
            if (!noneMatch) {
                return false;
            }
        }

        return true;
    }
}
