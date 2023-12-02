package nl.mwensveen.adventofcode.year_2023.day_02;

import com.google.common.collect.Table;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class GameAnalyzer {

    private CubeGrab max = new CubeGrab(14, 12, 13);

    public long analyzePosibleGames(Table<Integer, Integer, CubeGrab> games) {
        return games.rowKeySet().stream().filter(r -> isPossible(games.row(r))).collect(Collectors.summingLong(Integer::longValue));
    }

    public long analyzePowerGames(Table<Integer, Integer, CubeGrab> games) {
        return games.rowKeySet().stream().map(r -> power(games.row(r))).collect(Collectors.summingLong(Integer::longValue));
    }

    private int power(Map<Integer, CubeGrab> row) {
        CubeGrab max = new CubeGrab(0, 0, 0);
        Collection<CubeGrab> collection = row.values();
        for (CubeGrab cubeGrab : collection) {
            max = cubeGrab.max(max);
        }
        return max.blue() * max.green() * max.red();
    }

    private boolean isPossible(Map<Integer, CubeGrab> row) {
        boolean b = row.values().stream().allMatch(grab -> grab.isAllowed(max));
        return b;
    }
}
