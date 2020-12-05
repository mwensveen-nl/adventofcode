package nl.mwensveen.adventofcode.year_2019.day_18;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import nl.mwensveen.adventofcode.year_2019.day_18.MapParser.MapParserResult;
import org.junit.jupiter.api.Test;

public class MapParserTest {

    @Test
    public void testParse() throws Exception {
        MapParser mapParser = new MapParser();
        List<String> input = Arrays.asList("########################", "#f.D.E.e.C.b.A.@.a.B.c.#", "######################.#", "#d.....................#",
                "########################");
        MapParserResult result = mapParser.parse(input);
        assertEquals(15, result.getEntryX());
        assertEquals(1, result.getEntryY());
        assertEquals(6, result.getNumberOfKeys());
        assertEquals(Element.WALL, result.getMap().get(0, 0).getElement());
        assertEquals(Element.DOOR, result.getMap().get(3, 1).getElement());
        assertEquals('D', result.getMap().get(3, 1).getSymbol());
        assertEquals(Element.KEY, result.getMap().get(1, 3).getElement());
        assertEquals('d', result.getMap().get(1, 3).getSymbol());
    }

}
