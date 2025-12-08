package nl.mwensveen.adventofcode.year_2025.day_08;

import java.util.ArrayList;
import java.util.List;

public class JunctionBoxesParser {

    public List<Coordinate> parse(List<String> input) {
        return input.stream().map(Coordinate::new).toList();
    }

    public List<Distance> toDistance(List<Coordinate> coords) {
        List<Distance> distances = new ArrayList<>();
        for (int i = 0; i < coords.size(); i++) {
            for (int j = i + 1; j < coords.size(); j++) {
                distances.add(new Distance(coords.get(i), coords.get(j)));
            }
        }
        return distances;
    }
}
