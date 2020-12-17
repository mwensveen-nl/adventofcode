package nl.mwensveen.adventofcode.year_2020.day_17;

import nl.mwensveen.adventofcode.year_2020.day_17.Grid3D.State;

public class Cycle3D {

    public Grid3D performCycle(Grid3D grid) {
        Grid3D clone = grid.clone();
        for (int x = grid.getMinX() - 1; x <= grid.getMaxX() + 1; x++) {
            for (int y = grid.getMinY() - 1; y <= grid.getMaxY() + 1; y++) {
                for (int z = grid.getMinZ() - 1; z <= grid.getMaxZ() + 1; z++) {
                    int activeNeighbours = getActiveNeighbours(grid, x, y, z);
                    State state = grid.get(x, y, z);
                    if (state == State.ACTIVE) {
                        if (!(activeNeighbours == 2 || activeNeighbours == 3)) {
                            // clone.activate(x, y, z);
                            // } else {
                            clone.deActivate(x, y, z);
                        }
                    } else {
                        if (activeNeighbours == 3) {
                            clone.activate(x, y, z);
                            // } else {
                            // clone.deActivate(x, y, z);
                        }
                    }
                }
            }
        }
        return clone;
    }

    private int getActiveNeighbours(Grid3D grid, int x, int y, int z) {
        int count = 0;
        for (int xn = x - 1; xn <= x + 1; xn++) {
            for (int yn = y - 1; yn <= y + 1; yn++) {
                for (int zn = z - 1; zn <= z + 1; zn++) {
                    if (!(x == xn && y == yn && z == zn)) {
                        State state = grid.get(xn, yn, zn);
                        if (State.ACTIVE == state) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
