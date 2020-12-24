package nl.mwensveen.adventofcode.year_2020.day_24;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.List;

public class FloorCreator {

    public Table<Integer, Integer, Tile> createFloor(List<String> input) {
        Table<Integer, Integer, Tile> floor = HashBasedTable.create();
        input.stream().map(s -> new Tile(s)).forEach(t -> placeOnFloor(floor, t));
        return floor;
    }

    private void placeOnFloor(Table<Integer, Integer, Tile> floor, Tile t) {
        if (floor.contains(t.getSn(), t.getEw())) {
            floor.get(t.getSn(), t.getEw()).flip();
        } else {
            t.flip();
            floor.put(t.getSn(), t.getEw(), t);
        }

    }
}
