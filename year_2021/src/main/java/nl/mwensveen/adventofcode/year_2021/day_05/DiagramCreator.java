package nl.mwensveen.adventofcode.year_2021.day_05;

import com.codepoetics.protonpack.StreamUtils;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javax.annotation.ParametersAreNonnullByDefault;
import org.javatuples.Pair;

@ParametersAreNonnullByDefault
public class DiagramCreator {

    Table<Integer, Integer, AtomicInteger> createDiagramHorizontalVerticalLines(List<Line> lines) {
        Table<Integer, Integer, AtomicInteger> diagram = HashBasedTable.create();

        lines.stream().filter(l -> l.isHorizontal() || l.isVertical()).forEach(l -> addToDiagram(diagram, l));

        return diagram;
    }

    Table<Integer, Integer, AtomicInteger> createDiagramAllLines(List<Line> lines) {
        Table<Integer, Integer, AtomicInteger> diagram = HashBasedTable.create();

        lines.stream().forEach(l -> addToDiagram(diagram, l));

        return diagram;
    }

    private void addToDiagram(Table<Integer, Integer, AtomicInteger> diagram, Line l) {
        Stream<Integer> rangeX = null;
        Stream<Integer> rangeY = null;
        int minY = Math.min(l.y1(), l.y2());
        int maxY = Math.max(l.y1(), l.y2());
        int minX = Math.min(l.x1(), l.x2());
        int maxX = Math.max(l.x1(), l.x2());
        if (l.isHorizontal()) {
            rangeY = IntStream.rangeClosed(minY, maxY).mapToObj(Integer::valueOf);
            rangeX = IntStream.iterate(l.x1(), x -> x).limit(maxY - minY + 1).mapToObj(Integer::valueOf);
        } else if (l.isVertical()) {
            rangeX = IntStream.rangeClosed(minX, maxX).mapToObj(Integer::valueOf);
            rangeY = IntStream.iterate(l.y1(), y -> y).limit(maxX - minX + 1).mapToObj(Integer::valueOf);
        } else {
            rangeX = IntStream.rangeClosed(minX, maxX).mapToObj(Integer::valueOf);
            rangeY = IntStream.rangeClosed(minY, maxY).mapToObj(Integer::valueOf);
            if (maxX == l.x1()) {
                rangeX = rangeX.sorted(Collections.reverseOrder());
            }
            if (maxY == l.y1()) {
                rangeY = rangeY.sorted(Collections.reverseOrder());
            }
        }
        StreamUtils.zip(rangeX, rangeY, (x, y) -> Pair.with(x, y)).forEach(p -> updateDiagram(diagram, p));
    }

    private void updateDiagram(Table<Integer, Integer, AtomicInteger> diagram, Pair<Integer, Integer> p) {
        if (diagram.get(p.getValue0(), p.getValue1()) == null) {
            diagram.put(p.getValue0(), p.getValue1(), new AtomicInteger());
        }
        diagram.get(p.getValue0(), p.getValue1()).getAndAdd(1);
    }
}
