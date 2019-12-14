package nl.mwensveen.adventofcode.year_2019.day_13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ScreenParserTest {

    private long blocks;

    @Test
    public void testCountBlocks() throws Exception {
        List<GameInstruction> gameInstructions =
                Arrays.asList(GameInstruction.parse(Arrays.asList(BigInteger.valueOf(1), BigInteger.valueOf(2), BigInteger.valueOf(3))),
                        GameInstruction.parse(Arrays.asList(BigInteger.valueOf(6), BigInteger.valueOf(5), BigInteger.valueOf(2))));
        ScreenParser parser = new ScreenParser();
        blocks = parser.countBlocks(gameInstructions);
        assertEquals(1, blocks);
    }

}
