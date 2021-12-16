package nl.mwensveen.adventofcode.year_2021.day_15;

import com.google.common.collect.Table;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class RiskPathFinder {

    long findShortestPath(List<String> input) {
        RiskLevelParser parser = new RiskLevelParser();
        Table<Integer, Integer, RiskLevel> caveGrid = parser.parseInput(input);

        Optional<Integer> maxRow = caveGrid.rowKeySet().stream().max(Comparator.comparingInt(i -> i));
        Optional<Integer> maxColumn = caveGrid.columnKeySet().stream().max(Comparator.comparingInt(i -> i));

        RiskPath riskPath = new RiskPath();
        RiskPathStatistics riskPathStatistics = new RiskPathStatistics(maxRow.get(), maxColumn.get());
        findRiskPath(0, 0, riskPath, caveGrid, riskPathStatistics);
        return riskPathStatistics.getMinPath();
    }

    private void findRiskPath(int r, int c, RiskPath riskPath, Table<Integer, Integer, RiskLevel> caveGrid, RiskPathStatistics riskPathStatistics) {
        // System.out.println(r + " " + c);
        // does not exist
        if (!caveGrid.contains(r, c)) {
            return;
        }
        RiskLevel riskLevel = caveGrid.get(r, c);

        // already visited
        if (riskPath.contains(riskLevel)) {
            return;
        }

        riskPath.addRiskLevel(riskLevel);

        // larger then current minPath
        if (riskPath.getTotalRisk() >= riskPathStatistics.getMinPath()) {
            return;
        }
        if ((riskPathStatistics.getMaxRow() - r) + (riskPathStatistics.getMaxColumn() - c) + riskPath.getTotalRisk() >= riskPathStatistics.getMinPath()) {
            return;
        }

        // reach end
        if (riskPathStatistics.getMaxRow() == riskLevel.getRow() && riskPathStatistics.getMaxColumn() == riskLevel.getColumn()) {
            riskPathStatistics.setMinPath(riskPath.getTotalRisk());
            return;
        }

        findRiskPath(r + 1, c, riskPath.copy(), caveGrid, riskPathStatistics);
        findRiskPath(r, c + 1, riskPath.copy(), caveGrid, riskPathStatistics);
        findRiskPath(r, c - 1, riskPath.copy(), caveGrid, riskPathStatistics);
        findRiskPath(r - 1, c, riskPath.copy(), caveGrid, riskPathStatistics);
    }
}
