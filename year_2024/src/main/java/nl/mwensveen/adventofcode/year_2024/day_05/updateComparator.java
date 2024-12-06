package nl.mwensveen.adventofcode.year_2024.day_05;

import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.Comparator;

public class updateComparator implements Comparator<Integer> {

    private Multimap<Integer, Integer> rules;

    public updateComparator(Multimap<Integer, Integer> rules) {
        this.rules = rules;
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        Collection<Integer> collection = rules.get(o1);
        if (collection.isEmpty()) {
            return 0;
        }

        if (collection.contains(o2)) {
            return -1;
        }
        return 1;
    }

}
