package nl.mwensveen.adventofcode.year_2023.day_16;

import java.util.ArrayList;

public record Cell(Item item, java.util.List<Direction> directions) {

    public Cell(String input) {
        this(Item.find(input), new ArrayList<>());
    }
}
