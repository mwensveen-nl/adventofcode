package nl.mwensveen.adventofcode.year_2021.day_22;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InitProcessor {

    Long processInitialization(List<Step> steps) {
        Table<Integer, Integer, Set<Integer>> reactor = HashBasedTable.create();

        steps.forEach(s -> processInitStep(s, reactor));

        return reactor.values().stream().collect(Collectors.summingLong(s -> s.size()));
    }

    private void processInitStep(Step s, Table<Integer, Integer, Set<Integer>> reactor) {
        for (int x = Math.max(-50, s.getStartX()); x <= Math.min(50, s.getEndX()); x++) {
            for (int y = Math.max(-50, s.getStartY()); y <= Math.min(50, s.getEndY()); y++) {
                for (int z = Math.max(-50, s.getStartZ()); z <= Math.min(50, s.getEndZ()); z++) {
                    if (s.getOnOff().equals("on")) {
                        Set<Integer> set = getSet(reactor, x, y);
                        set.add(z);
                    } else {
                        Set<Integer> set = getSet(reactor, x, y);
                        set.remove(z);
                    }
                }

            }

        }
    }

    private Set<Integer> getSet(Table<Integer, Integer, Set<Integer>> reactor, int x, int y) {
        Set<Integer> set = reactor.get(x, y);
        if (set == null) {
            set = new HashSet<>();
            reactor.put(x, y, set);
        }
        return set;
    }
}
