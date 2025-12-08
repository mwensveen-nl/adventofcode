package nl.mwensveen.adventofcode.year_2025.day_08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class CircuitCalculatorTest {
    String input = """
            162,817,812
            57,618,57
            906,360,560
            592,479,940
            352,342,300
            466,668,158
            542,29,236
            431,825,988
            739,650,466
            52,470,668
            216,146,977
            819,987,18
            117,168,530
            805,96,715
            346,949,466
            970,615,88
            941,993,340
            862,61,35
            984,92,344
            425,690,689
                     """;

    @Test
    public void calculate() {
        var parser = new JunctionBoxesParser();
        var coords = parser.parse(input.lines().toList());
        List<Distance> distances = parser.toDistance(coords);

        List<? extends Set<Coordinate>> circuits = new CircuitCalculator().calculate(distances, coords, 10);
        assertEquals(11, circuits.size());
    }

    @Test
    public void multiplyLargest() {
        var parser = new JunctionBoxesParser();
        var coords = parser.parse(input.lines().toList());
        List<Distance> distances = parser.toDistance(coords);

        CircuitCalculator circuitCalculator = new CircuitCalculator();
        List<? extends Set<Coordinate>> circuits = circuitCalculator.calculate(distances, coords, 10);
        BigInteger result = circuitCalculator.multiplyLargest(circuits, 3);
        assertEquals(40, result.intValue());

    }

    @Test
    public void calculateAll() {
        var parser = new JunctionBoxesParser();
        var coords = parser.parse(input.lines().toList());
        List<Distance> distances = parser.toDistance(coords);

        Distance d = new CircuitCalculator().calculateAll(distances, coords);
        assertEquals(25272, d.one().x().intValue() * d.two().x().intValue());
    }

}
