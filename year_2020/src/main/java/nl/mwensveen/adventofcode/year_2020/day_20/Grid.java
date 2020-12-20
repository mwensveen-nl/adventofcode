package nl.mwensveen.adventofcode.year_2020.day_20;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class Grid {

    private Table<Integer, Integer, Image> table = HashBasedTable.create();

    private int minX = 0;
    private int maxX = 0;
    private int minY = 0;
    private int maxY = 0;

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

    public Image get(int x, int y) {
        return table.get(x, y);
    }

    public void put(int x, int y, Image image) {
        table.put(x, y, image);
        minMax(x, y);
    }

    private void minMax(int x, int y) {
        minX = Math.min(minX, x);
        maxX = Math.max(maxX, x);
        minY = Math.min(minY, y);
        maxY = Math.max(maxY, y);
    }

}
