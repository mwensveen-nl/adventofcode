package nl.mwensveen.adventofcode.year_2019.day_18;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import nl.mwensveen.adventofcode.year_2019.day_18.MapParser.MapParserResult;
import org.junit.jupiter.api.Test;

public class TunnelWalkerTest {

    @Test
    public void testFindAllKeys() throws Exception {
        List<String> input = Arrays.asList("#########", "#b.....@#", "#########");
        MapParser mapParser = new MapParser();
        MapParserResult result = mapParser.parse(input);
        TunnelWalker tunnelWalker = new TunnelWalker(result);
        int steps = tunnelWalker.findAllKeys();
        assertEquals(6, steps);
    }

    @Test
    public void testFindAllKeys2() throws Exception {
        List<String> input = Arrays.asList("########################", "#f.D.E.e.C.b.A.@.a.B.c.#", "######################.#", "#d.....................#",
                "########################");
        MapParser mapParser = new MapParser();
        MapParserResult result = mapParser.parse(input);
        TunnelWalker tunnelWalker = new TunnelWalker(result);
        int steps = tunnelWalker.findAllKeys();
        assertEquals(86, steps);
    }

    @Test
    public void testFindAllKeys3() throws Exception {
        List<String> input = Arrays.asList("########################", "#...............b.C.D.f#", "#.######################", "#.....@.a.B.c.d.A.e.F.g#",
                "########################");
        MapParser mapParser = new MapParser();
        MapParserResult result = mapParser.parse(input);
        TunnelWalker tunnelWalker = new TunnelWalker(result);
        int steps = tunnelWalker.findAllKeys();
        assertEquals(132, steps);
    }

    @Test
    public void testFindAllKeys4() throws Exception {
        List<String> input = Arrays.asList("#################", "#i.G..c...e..H.p#", "########.########", "#j.A..b...f..D.o#", "########@########",
                "#k.E..a...g..B.n#", "########.########", "#l.F..d...h..C.m#", "#################");
        MapParser mapParser = new MapParser();
        MapParserResult result = mapParser.parse(input);
        TunnelWalker tunnelWalker = new TunnelWalker(result);
        int steps = tunnelWalker.findAllKeys();
        assertEquals(136, steps);
    }

}
