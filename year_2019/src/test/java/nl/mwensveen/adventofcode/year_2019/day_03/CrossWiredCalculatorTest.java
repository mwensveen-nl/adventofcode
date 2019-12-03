package nl.mwensveen.adventofcode.year_2019.day_03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class CrossWiredCalculatorTest {

    @Test
    public void testCalculateManhattenDistanceOfNearestIntersection() throws Exception {
        String lineOne = "R8,U5,L5,D3";
        String lineTwo = "U7,R6,D4,L4";
        CrossWiredCalculator calculator = new CrossWiredCalculator();
        int distance = calculator.calculateManhattenDistanceOfNearestIntersection(Arrays.asList(lineOne, lineTwo));
        assertEquals(6, distance);
    }

    @Test
    public void testCalculateManhattenDistanceOfNearestIntersection2() throws Exception {
        String lineOne = "R75,D30,R83,U83,L12,D49,R71,U7,L72";
        String lineTwo = "U62,R66,U55,R34,D71,R55,D58,R83";
        CrossWiredCalculator calculator = new CrossWiredCalculator();
        int distance = calculator.calculateManhattenDistanceOfNearestIntersection(Arrays.asList(lineOne, lineTwo));
        assertEquals(159, distance);
    }

    @Test
    public void testCalculateManhattenDistanceOfNearestIntersection3() throws Exception {
        String lineOne = "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51";
        String lineTwo = "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7";
        CrossWiredCalculator calculator = new CrossWiredCalculator();
        int distance = calculator.calculateManhattenDistanceOfNearestIntersection(Arrays.asList(lineOne, lineTwo));
        assertEquals(135, distance);
    }

    @Test
    public void testCalculateMinStepsToIntersection() throws Exception {
        String lineOne = "R8,U5,L5,D3";
        String lineTwo = "U7,R6,D4,L4";
        CrossWiredCalculator calculator = new CrossWiredCalculator();
        int distance = calculator.calculateMinStepsToIntersection(Arrays.asList(lineOne, lineTwo));
        assertEquals(30, distance);
    }

    @Test
    public void testCalculateMinStepsToIntersection2() throws Exception {
        String lineOne = "R75,D30,R83,U83,L12,D49,R71,U7,L72";
        String lineTwo = "U62,R66,U55,R34,D71,R55,D58,R83";
        CrossWiredCalculator calculator = new CrossWiredCalculator();
        int distance = calculator.calculateMinStepsToIntersection(Arrays.asList(lineOne, lineTwo));
        assertEquals(610, distance);
    }

    @Test
    public void testCalculateMinStepsToIntersection3() throws Exception {
        String lineOne = "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51";
        String lineTwo = "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7";
        CrossWiredCalculator calculator = new CrossWiredCalculator();
        int distance = calculator.calculateMinStepsToIntersection(Arrays.asList(lineOne, lineTwo));
        assertEquals(410, distance);
    }
}
