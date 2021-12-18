package nl.mwensveen.adventofcode.year_2021.day_16;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HexInputParserTest {

    @Test
    public void testParseInput() {
        HexInputParser hexInputParser = new HexInputParser();
        assertEquals("11101110000000001101010000001100100000100011000001100000", hexInputParser.parseInput("EE00D40C823060"));
    }

}
