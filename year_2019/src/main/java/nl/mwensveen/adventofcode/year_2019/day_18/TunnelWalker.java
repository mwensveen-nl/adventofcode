package nl.mwensveen.adventofcode.year_2019.day_18;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Table;
import java.util.Collections;
import java.util.List;
import nl.mwensveen.adventofcode.year_2019.day_18.MapParser.MapParserResult;

public class TunnelWalker {
    private final Table<Integer, Integer, MapEntry> map;
    private final int numberOfKeys;
    private final int maxX;
    private final int maxY;
    private final int entryX;
    private final int entryY;
    private Integer minSteps = Integer.MAX_VALUE;

    public TunnelWalker(MapParserResult r) {
        map = r.getMap();
        numberOfKeys = r.getNumberOfKeys();
        maxX = r.getMaxX();
        maxY = r.getMaxY();
        entryX = r.getEntryX();
        entryY = r.getEntryY();
    }

    public int findAllKeys() {
        int x = entryX;
        int y = entryY;
        String keysfound = "";
        Integer steps = 0;
        walk(x, y, keysfound, steps, ImmutableList.<Point>builder().add(new Point(x, y)).build());
        return minSteps;
    }

    private void walk(int x, int y, String keysfound, Integer steps, List<Point> visitedPoints) {
        if (steps >= minSteps) {
            return;
        }
        MapEntry mapEntry = map.get(x, y);
        Element element = mapEntry.getElement();

        if (element == Element.WALL) {
            return;
        }
        if (element == Element.DOOR) {
            if (keysfound.indexOf(Character.toLowerCase(mapEntry.getSymbol())) < 0) {
                return;
            }
        }
        if (element == Element.KEY && keysfound.indexOf(mapEntry.getSymbol()) < 0) {
            keysfound = keysfound + mapEntry.getSymbol();
            if (keysfound.length() == numberOfKeys) {
                minSteps = steps;
                return;
            }
            System.out.println(keysfound);
            visitedPoints = Collections.EMPTY_LIST;
        }
        if (y - 1 >= 0) {
            visitedPoints = nextWalk(x, y - 1, keysfound, steps, visitedPoints);
        }
        if (x + 1 <= maxX) {
            visitedPoints = nextWalk(x + 1, y, keysfound, steps, visitedPoints);
        }
        if (y + 1 <= maxY) {
            visitedPoints = nextWalk(x, y + 1, keysfound, steps, visitedPoints);
        }
        if (x - 1 >= 0) {
            visitedPoints = nextWalk(x - 1, y, keysfound, steps, visitedPoints);
        }
        return;
    }

    private List<Point> nextWalk(int x, int y, String keysfound, Integer steps, List<Point> visitedPoints) {
        Point p = new Point(x, y);
        if (!visitedPoints.contains(p)) {
            ImmutableList<Point> ps = ImmutableList.<Point>builder().addAll(visitedPoints).add(p).build();
            walk(x, y, keysfound, steps + 1, ps);
            return ps;
        }
        return visitedPoints;
    }
}
