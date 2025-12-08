package nl.mwensveen.adventofcode.year_2025.day_08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class JunctionBoxesParserTest {

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
    public void parse() {
        var parser = new JunctionBoxesParser();
        var coords = parser.parse(input.lines().toList());

        assertEquals(20, coords.size());

        assertEquals(162, coords.getFirst().x());
        assertEquals(817, coords.getFirst().y());
        assertEquals(812, coords.getFirst().z());

        assertEquals(425, coords.getLast().x());
        assertEquals(690, coords.getLast().y());
        assertEquals(689, coords.getLast().z());
    }

    @Test
    public void toDistance() {
        var parser = new JunctionBoxesParser();
        var coords = parser.parse(input.lines().toList());

        List<Distance> distances = parser.toDistance(coords);
        assertEquals(190, distances.size());

        Distance d = distances.stream().sorted((a, b) -> Double.compare(a.length(), b.length())).findFirst().get();
        assertEquals(new Coordinate(162, 817, 812), d.one());
        assertEquals(new Coordinate(425, 690, 689), d.two());
        distances.remove(d);

        Distance d2 = distances.stream().sorted((a, b) -> Double.compare(a.length(), b.length())).findFirst().get();
        assertEquals(new Coordinate(162, 817, 812), d2.one());
        assertEquals(new Coordinate(431, 825, 988), d2.two());
        distances.remove(d2);

        Distance d3 = distances.stream().sorted((a, b) -> Double.compare(a.length(), b.length())).findFirst().get();
        assertEquals(new Coordinate(906, 360, 560), d3.one());
        assertEquals(new Coordinate(805, 96, 715), d3.two());
    }

}
