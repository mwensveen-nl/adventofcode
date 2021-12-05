package nl.mwensveen.adventofcode.year_2021.day_05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.common.collect.Table;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

public class DiagramCounterTest {

    @Test
    public void testCountPointsWithOverlap() {
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

        DiagramCounter diagramCounter = new DiagramCounter();
        long result = diagramCounter.countPointsWithOverlap(diagram);
        assertEquals(5L, result);
    }

    @Test
    public void testCountPointsWithOverlap2() {
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

        DiagramCounter diagramCounter = new DiagramCounter();
        long result = diagramCounter.countPointsWithOverlap(diagram);
        assertEquals(12L, result);
    }

}
