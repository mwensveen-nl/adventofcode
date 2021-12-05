package nl.mwensveen.adventofcode.year_2021.day_05;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.google.common.collect.Table;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class DiagramCreatorTest {

    @Test
    public void testCreateDiagramHorizontalVerticalLines() {
        List<String> input = Arrays.asList("0,9 -> 5,9",
                "8,0 -> 0,8",
                "9,4 -> 3,4",
                "2,2 -> 2,1",
                "7,0 -> 7,4",
                "6,4 -> 2,0",
                "0,9 -> 2,9",
                "3,4 -> 1,4",
                "0,0 -> 8,8",
                "5,5 -> 8,2");
        LinesParser linesParser = new LinesParser();
        List<Line> lines = linesParser.parsLines(input);

        DiagramCreator creator = new DiagramCreator();
        Table<Integer, Integer, AtomicInteger> diagram = creator.createDiagramHorizontalVerticalLines(lines);
        System.out.println(diagram);
        Set<Integer> rowKeySet = diagram.rowKeySet();
        assertEquals(9, rowKeySet.stream().collect(Collectors.maxBy(Integer::compare)).get());

        Set<Integer> columnKeySet = diagram.columnKeySet();
        assertEquals(9, columnKeySet.stream().collect(Collectors.maxBy(Integer::compare)).get());

        assertNull(diagram.get(0, 0));
        assertEquals(1, diagram.get(7, 0).get());
        assertEquals(2, diagram.get(7, 4).get());

    }

    @Test
    public void testCreateDiagramAllLines() {
        List<String> input = Arrays.asList("0,9 -> 5,9",
                "8,0 -> 0,8",
                "9,4 -> 3,4",
                "2,2 -> 2,1",
                "7,0 -> 7,4",
                "6,4 -> 2,0",
                "0,9 -> 2,9",
                "3,4 -> 1,4",
                "0,0 -> 8,8",
                "5,5 -> 8,2");
        LinesParser linesParser = new LinesParser();
        List<Line> lines = linesParser.parsLines(input);

        DiagramCreator creator = new DiagramCreator();
        Table<Integer, Integer, AtomicInteger> diagram = creator.createDiagramAllLines(lines);
        System.out.println(diagram);
        Set<Integer> rowKeySet = diagram.rowKeySet();
        assertEquals(9, rowKeySet.stream().collect(Collectors.maxBy(Integer::compare)).get());

        Set<Integer> columnKeySet = diagram.columnKeySet();
        assertEquals(9, columnKeySet.stream().collect(Collectors.maxBy(Integer::compare)).get());

        assertNull(diagram.get(1, 0));
        assertEquals(1, diagram.get(7, 0).get());
        assertEquals(2, diagram.get(7, 4).get());
        assertEquals(3, diagram.get(4, 4).get());
    }
}
