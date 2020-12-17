package nl.mwensveen.adventofcode.year_2020.day_17;

import nl.mwensveen.adventofcode.year_2020.day_17.Grid.State;

public class Cycle {

    public Grid performCycle3D(Grid grid) {
        Grid clone = grid.clone();
        for (int x = grid.getMinX() - 1; x <= grid.getMaxX() + 1; x++) {
            for (int y = grid.getMinY() - 1; y <= grid.getMaxY() + 1; y++) {
                for (int z = grid.getMinZ() - 1; z <= grid.getMaxZ() + 1; z++) {
                    int activeNeighbours = getActiveNeighbours3D(grid, x, y, z);
                    State state = grid.get(x, y, z);
                    if (state == State.ACTIVE) {
                        if (!(activeNeighbours == 2 || activeNeighbours == 3)) {
                            clone.deActivate(x, y, z);
                        }
                    } else {
                        if (activeNeighbours == 3) {
                            clone.activate(x, y, z);
                        }
                    }
                }
            }
        }
        return clone;
    }

    public Grid performCycle4D(Grid grid) {
        Grid clone = grid.clone();
        for (int x = grid.getMinX() - 1; x <= grid.getMaxX() + 1; x++) {
            for (int y = grid.getMinY() - 1; y <= grid.getMaxY() + 1; y++) {
                for (int z = grid.getMinZ() - 1; z <= grid.getMaxZ() + 1; z++) {
                    for (int w = grid.getMinW() - 1; w <= grid.getMaxW() + 1; w++) {
                        int activeNeighbours = getActiveNeighbours4D(grid, x, y, z, w);
                        State state = grid.get(x, y, z, w);
                        if (state == State.ACTIVE) {
                            if (!(activeNeighbours == 2 || activeNeighbours == 3)) {
                                clone.deActivate(x, y, z, w);
                            }
                        } else {
                            if (activeNeighbours == 3) {
                                clone.activate(x, y, z, w);
                            }
                        }
                    }
                }
            }
        }
        return clone;
    }

    private int getActiveNeighbours3D(Grid grid, int x, int y, int z) {
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

    private int getActiveNeighbours4D(Grid grid, int x, int y, int z, int w) {
        int count = 0;
        for (int xn = x - 1; xn <= x + 1; xn++) {
            for (int yn = y - 1; yn <= y + 1; yn++) {
                for (int zn = z - 1; zn <= z + 1; zn++) {
                    for (int wn = w - 1; wn <= w + 1; wn++) {
                        if (!(x == xn && y == yn && z == zn && w == wn)) {
                            State state = grid.get(xn, yn, zn, wn);
                            if (State.ACTIVE == state) {
                                count++;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
