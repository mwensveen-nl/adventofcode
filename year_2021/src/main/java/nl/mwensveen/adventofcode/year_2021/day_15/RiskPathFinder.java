package nl.mwensveen.adventofcode.year_2021.day_15;

import com.google.common.collect.Table;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class RiskPathFinder {

    long findShortestPath(List<String> input, int times) {
        RiskLevelParser parser = new RiskLevelParser();
        Table<Integer, Integer, RiskLevel> cave = parser.parseInput(input, times);
        RiskLevel last = cave.get(cave.rowKeySet().size() - 1, cave.columnKeySet().size() - 1);
        Queue<RiskLevel> unvisited = new PriorityQueue<>(Comparator.comparingLong(rl -> rl.getDistance()));
        unvisited.add(cave.get(0, 0));
        RiskLevel current = unvisited.poll();
        while (current != null) {
            processCurrent(current, cave, unvisited);
            current = unvisited.poll();
        }

        return last.getDistance();
    }

    private void processCurrent(RiskLevel current, Table<Integer, Integer, RiskLevel> cave, Queue<RiskLevel> unvisited) {
        List<RiskLevel> adjents = current.notVisitedAdjents();
        adjents.stream().filter(rl -> rl.getDistance() != Long.MAX_VALUE).forEach(rl -> unvisited.remove(rl));
        adjents.forEach(a -> setDistance(a, current.getDistance()));
        adjents.forEach(rl -> unvisited.add(rl));
        current.setVisited(true);
    }

    private void setDistance(RiskLevel a, long distance) {
        a.setDistance(Math.min(a.getDistance(), distance + a.getRisk()));
    }
}
