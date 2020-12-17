package nl.mwensveen.adventofcode.year_2020.day_17;

import java.util.HashMap;
import java.util.Map;

public class Grid {

    private Map<Integer, Map<Integer, Map<Integer, State>>> dimensions = new HashMap<>();

    private int minX = 0;
    private int maxX = 0;
    private int minY = 0;
    private int maxY = 0;
    private int minZ = 0;
    private int maxZ = 0;

    public int getMinX() {
        return minX;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMinY() {
        return minY;
    }

    public int getMaxY() {
        return maxY;
    }

    public int getMinZ() {
        return minZ;
    }

    public int getMaxZ() {
        return maxZ;
    }

    public void activate(int x, int y, int z) {
        Map<Integer, State> xy = get(x, y);
        xy.put(z, State.ACTIVE);
        minMax(x, y, z);
    }

    public void deActivate(int x, int y, int z) {
        Map<Integer, State> xy = get(x, y);
        xy.put(z, State.INACTIVE);
        minMax(x, y, z);
    }

    private void minMax(int x, int y, int z) {
        if (x < 0) {
            minX = Math.min(minX, x);
        }
        if (x > 0) {
            maxX = Math.max(maxX, x);
        }
        if (y < 0) {
            minY = Math.min(minY, y);
        }
        if (y > 0) {
            maxY = Math.max(maxY, y);
        }
        if (z < 0) {
            minZ = Math.min(minZ, z);
        }
        if (z > 0) {
            maxZ = Math.max(maxZ, z);
        }
    }

    public State get(int x, int y, int z) {
        Map<Integer, State> xy = get(x, y);
        State state = xy.get(z);
        if (state == null) {
            return State.INACTIVE;
        }
        return state;
    }

    @Override
    public Grid clone() {
        Grid clone = new Grid();
        for (int z = getMinZ(); z <= getMaxZ(); z++) {
            for (int x = getMinX(); x <= getMaxX(); x++) {
                for (int y = getMinY(); y <= getMaxY(); y++) {
                    State state = get(x, y, z);
                    if (state == State.ACTIVE) {
                        clone.activate(x, y, z);
                    } else {
                        clone.deActivate(x, y, z);
                    }
                }
            }
        }
        return clone;
    }

    private Map<Integer, State> get(int x, int y) {
        Map<Integer, Map<Integer, State>> xMap = dimensions.get(x);
        if (xMap == null) {
            xMap = new HashMap<>();
            dimensions.put(x, xMap);
        }

        Map<Integer, State> yMap = xMap.get(y);
        if (yMap == null) {
            yMap = new HashMap<>();
            xMap.put(y, yMap);
        }
        return yMap;
    }

    public static enum State {
        ACTIVE,
        INACTIVE;
    }
}
