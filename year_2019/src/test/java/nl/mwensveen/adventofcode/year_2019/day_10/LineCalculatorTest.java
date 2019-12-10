package nl.mwensveen.adventofcode.year_2019.day_10;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import org.junit.jupiter.api.Test;

public class LineCalculatorTest {

    @Test
    public void testCalculate() throws Exception {
        Point one = new Point(4, 0);
        Point two = new Point(3, 5);
        LineCalculator calculator = new LineCalculator(one, two);
        assertTrue(calculator.next().isEmpty());
    }

    @Test
    public void testCalculate2() throws Exception {
        Point one = new Point(1, 0);
        Point two = new Point(3, 4);
        LineCalculator calculator = new LineCalculator(one, two);
        Optional<Point> next = calculator.next();
        assertTrue(next.isPresent());
        assertEquals(2, next.get().getX());
        assertEquals(2, next.get().getY());
    }

    @Test
    public void testCalculate4() throws Exception {
        Point one = new Point(1, 0);
        Point two = new Point(4, 5);
        LineCalculator calculator = new LineCalculator(one, two);

        Optional<Point> next = calculator.next();
        assertTrue(next.isEmpty());
    }

    @Test
    public void testCalculate3() throws Exception {
        Point one = new Point(3, 4);
        Point two = new Point(1, 0);
        LineCalculator calculator = new LineCalculator(one, two);
        Optional<Point> next = calculator.next();
        assertTrue(next.isPresent());
        assertEquals(2, next.get().getX());
        assertEquals(2, next.get().getY());
    }

    @Test
    public void testCalculateVertical() throws Exception {
        Point one = new Point(3, 4);
        Point two = new Point(3, 0);
        LineCalculator calculator = new LineCalculator(one, two);

        Optional<Point> next = calculator.next();
        assertTrue(next.isPresent());
        assertEquals(3, next.get().getX());
        assertEquals(1, next.get().getY());

        next = calculator.next();
        assertTrue(next.isPresent());
        assertEquals(3, next.get().getX());
        assertEquals(2, next.get().getY());

        next = calculator.next();
        assertTrue(next.isPresent());
        assertEquals(3, next.get().getX());
        assertEquals(3, next.get().getY());

        assertFalse(calculator.next().isPresent());
    }

    @Test
    public void testCalculateHorizontal() throws Exception {
        Point one = new Point(4, 3);
        Point two = new Point(0, 3);
        LineCalculator calculator = new LineCalculator(one, two);

        Optional<Point> next = calculator.next();
        assertTrue(next.isPresent());
        assertEquals(1, next.get().getX());
        assertEquals(3, next.get().getY());

        next = calculator.next();
        assertTrue(next.isPresent());
        assertEquals(2, next.get().getX());
        assertEquals(3, next.get().getY());

        next = calculator.next();
        assertTrue(next.isPresent());
        assertEquals(3, next.get().getX());
        assertEquals(3, next.get().getY());

        assertFalse(calculator.next().isPresent());
    }

}
