package nl.mwensveen.adventofcode.year_2021.day_15;

import com.google.common.collect.Table;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class RiskPathFinder {

    long findShortestPath(List<String> input, int times) {
        RiskLevelParser parser = new RiskLevelParser();
        Table<Integer, Integer, RiskLevel> cave = parser.parseInput(input, times);
        RiskLevel last = cave.get(cave.rowKeySet().size() - 1, cave.columnKeySet().size() - 1);

        Collection<RiskLevel> unvisited = new HashSet<>(cave.values());
        Optional<RiskLevel> current = unvisited.stream().min(Comparator.comparingLong(rl -> rl.getDistance()));
        while (current.isPresent()) {
            processCurrent(current.get(), cave);
            unvisited.remove(current.get());
            current = unvisited.stream().min(Comparator.comparingLong(rl -> rl.getDistance()));
        }

        return last.getDistance();
    }

    private void processCurrent(RiskLevel current, Table<Integer, Integer, RiskLevel> cave) {
        current.notVisitedAdjents().forEach(a -> setDistance(a, current.getDistance()));
        current.setVisited(true);
    }

    private void setDistance(RiskLevel a, long distance) {
        a.setDistance(Math.min(a.getDistance(), distance + a.getRisk()));
    }
}
