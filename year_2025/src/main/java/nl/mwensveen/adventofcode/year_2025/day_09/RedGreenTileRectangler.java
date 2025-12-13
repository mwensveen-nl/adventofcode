package nl.mwensveen.adventofcode.year_2025.day_09;

import java.util.ArrayList;
import java.util.List;

public class RedGreenTileRectangler {

    public long find(List<Tile> tiles) {
        var size = tiles.size();
        List<Rectangle> floor = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                floor.add(new Rectangle(tiles.get(i), tiles.get(j)));
            }
        }
        floor.sort((a, b) -> Long.compare(a.area(), b.area()) * -1);

        PolygonCheck polygonCheck = new PolygonCheck(tiles);
        boolean found = false;
        Rectangle r = null;
        System.out.println(floor.size());
        for (int i = 12000; !found && i < floor.size(); i++) {
            if (i % 10 == 0) {
                System.out.println(i);
            }
            r = floor.get(i);
            found = polygonCheck.isRectangleInPolygon(r);
        }
        return r.area();
    }
}
