package nl.mwensveen.adventofcode.year_2025.day_09;

import java.util.List;

public class TileParser {

    public List<Tile> parse(List<String> input) {
        return input.stream().map(Tile::new).toList();
    }
}
