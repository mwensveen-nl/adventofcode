package nl.mwensveen.adventofcode.year_2021.day_05;

import java.util.List;
import java.util.stream.Collectors;
import org.javatuples.Pair;

public class LinesParser {

    List<Line> parsLines(List<String> input) {
        return input.stream().map(this::toLine).collect(Collectors.toList());
    }

    private Line toLine(String lineString) {
        String[] points = lineString.split("->");
        Pair<Integer, Integer> point1 = toPoint(points[0].trim());
        Pair<Integer, Integer> point2 = toPoint(points[1].trim());
        Line l = new Line(point1.getValue0(), point1.getValue1(), point2.getValue0(), point2.getValue1());
        return l;
    }

    private Pair<Integer, Integer> toPoint(String point) {
        int i = point.indexOf(',');
        return Pair.with(Integer.valueOf(point.substring(0, i)), Integer.valueOf(point.substring(i + 1)));
    }
}
