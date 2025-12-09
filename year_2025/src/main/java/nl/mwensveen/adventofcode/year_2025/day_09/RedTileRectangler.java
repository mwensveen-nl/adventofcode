package nl.mwensveen.adventofcode.year_2025.day_09;

import java.util.ArrayList;
import java.util.List;

public class RedTileRectangler {

    public long find(List<Tile> tiles) {
        var size = tiles.size();
        List<Rectangle> floor = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                floor.add(new Rectangle(tiles.get(i), tiles.get(j)));
            }
        }
        floor.sort((a, b) -> Long.compare(a.area(), b.area()));
        return floor.getLast().area();
    }
}
