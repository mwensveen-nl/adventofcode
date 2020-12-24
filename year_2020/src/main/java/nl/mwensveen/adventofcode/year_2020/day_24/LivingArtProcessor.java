package nl.mwensveen.adventofcode.year_2020.day_24;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class LivingArtProcessor {

    public Table<Integer, Integer, Tile> flipTiles(Table<Integer, Integer, Tile> floor) {
        Integer snMin = floor.rowKeySet().stream().min(Integer::compareTo).get();
        Integer snMax = floor.rowKeySet().stream().max(Integer::compareTo).get();
        Integer ewMin = floor.columnKeySet().stream().min(Integer::compareTo).get();
        Integer ewMax = floor.columnKeySet().stream().max(Integer::compareTo).get();

        Table<Integer, Integer, Tile> newFloor = HashBasedTable.create();
        for (int sn = snMin - 1; sn <= snMax + 1; sn++) {
            for (int ew = ewMin - 1; ew <= ewMax + 1; ew++) {
                if (Math.abs(sn) % 2 == Math.abs(ew) % 2) {
                    flipTile(sn, ew, floor, newFloor);
                }
            }

        }
        return newFloor;
    }

    private void flipTile(int sn, int ew, Table<Integer, Integer, Tile> floor, Table<Integer, Integer, Tile> newFloor) {
        Tile tile = floor.get(sn, ew);
        if (tile == null) {
            tile = new Tile(sn, ew);
            floor.put(sn, ew, tile);
        }
        tile = tile.copy();

        newFloor.put(sn, ew, tile);

        int adjacentBlackTiles = count(floor, sn, ew);
        newColor(tile, adjacentBlackTiles);
    }

    private void newColor(Tile tile, int adjacentBlackTiles) {
        if (tile.getColor() == Color.BLACK) {
            if (adjacentBlackTiles == 0 || adjacentBlackTiles > 2) {
                tile.flip();
            }
        } else if (adjacentBlackTiles == 2) {
            tile.flip();
        }

    }

    private int count(Table<Integer, Integer, Tile> floor, int sn, int ew) {
        int count = isBlackTile(floor, sn + 1, ew - 1) ? 1 : 0;
        count += isBlackTile(floor, sn, ew - 2) ? 1 : 0;
        count += isBlackTile(floor, sn - 1, ew - 1) ? 1 : 0;
        count += isBlackTile(floor, sn - 1, ew + 1) ? 1 : 0;
        count += isBlackTile(floor, sn, ew + 2) ? 1 : 0;
        count += isBlackTile(floor, sn + 1, ew + 1) ? 1 : 0;
        return count;
    }

    private boolean isBlackTile(Table<Integer, Integer, Tile> floor, int sn, int ew) {
        Tile tile = floor.get(sn, ew);
        if (tile == null || tile.getColor() == Color.WHITE) {
            return false;
        } else {
            return true;
        }
    }
}
