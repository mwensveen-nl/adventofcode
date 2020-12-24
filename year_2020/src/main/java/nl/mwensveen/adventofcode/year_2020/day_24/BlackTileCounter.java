package nl.mwensveen.adventofcode.year_2020.day_24;

import com.google.common.collect.Table;

public class BlackTileCounter {

    public long countBlackTiles(Table<Integer, Integer, Tile> floor) {
        return floor.values().stream().filter(tile -> tile.getColor() == Color.BLACK).count();
    }
}
