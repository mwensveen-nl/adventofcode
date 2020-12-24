package nl.mwensveen.adventofcode.year_2020.day_24;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class FloorInstaller {

    public long installTilesOnFloor(List<String> input) {
        Map<String, AtomicInteger> floor = new HashMap<>();
        TileNameCreator tileNameCreator = new TileNameCreator();
        input.stream().map(code -> tileNameCreator.createTileName(code)).forEach(name -> putOnFloor(name, floor));

        return floor.values().stream().filter(ai -> ai.get() % 2 == 1).count();
    }

    private void putOnFloor(String name, Map<String, AtomicInteger> floor) {
        if (floor.containsKey(name)) {
            floor.get(name).incrementAndGet();
        } else {
            floor.put(name, new AtomicInteger(1));
        }
    }
}
