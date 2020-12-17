package nl.mwensveen.adventofcode.year_2020.day_17;

import java.util.HashMap;
import java.util.Map;

public class Grid {

    private Map<String, State> dimensions = new HashMap<>();

    private int minX = 0;
    private int maxX = 0;
    private int minY = 0;
    private int maxY = 0;
    private int minZ = 0;
    private int maxZ = 0;
    private int minW = 0;
    private int maxW = 0;

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

    public int getMinW() {
        return minW;
    }

    public int getMaxW() {
        return maxW;
    }

    public void activate(int x, int y, int z) {
        activate(x, y, z, 0);
    }

    public void activate(int x, int y, int z, int w) {
        dimensions.put(xyzwString(x, y, z, w), State.ACTIVE);
        minMax(x, y, z, w);
    }

    public void deActivate(int x, int y, int z) {
        deActivate(x, y, z, 0);
    }

    public void deActivate(int x, int y, int z, int w) {
        dimensions.put(xyzwString(x, y, z, w), State.INACTIVE);
        minMax(x, y, z, w);
    }

    public State get(int x, int y, int z) {
        return get(x, y, z, 0);
    }

    public State get(int x, int y, int z, int w) {
        State state = dimensions.get(xyzwString(x, y, z, w));
        if (state == null) {
            return State.INACTIVE;
        }
        return state;
    }

    private String xyzwString(int x, int y, int z, int w) {
        return x + "*" + y + "*" + z + "*" + w;
    }

    private void minMax(int x, int y, int z, int w) {
        minX = Math.min(minX, x);
        maxX = Math.max(maxX, x);
        minY = Math.min(minY, y);
        maxY = Math.max(maxY, y);
        minZ = Math.min(minZ, z);
        maxZ = Math.max(maxZ, z);
        minW = Math.min(minW, w);
        maxW = Math.max(maxW, w);
    }

    @Override
    public Grid clone() {
        Grid clone = new Grid();
        clone.dimensions = new HashMap<>(dimensions);
        clone.minX = minX;
        clone.maxX = maxX;
        clone.minY = minY;
        clone.maxY = maxY;
        clone.minZ = minZ;
        clone.maxZ = maxZ;
        clone.minW = minW;
        clone.maxW = maxW;
        return clone;
    }

    public enum State {
        ACTIVE,
        INACTIVE;
    }
}
