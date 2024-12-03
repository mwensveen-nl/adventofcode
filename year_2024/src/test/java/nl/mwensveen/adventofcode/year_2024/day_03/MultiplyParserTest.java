package nl.mwensveen.adventofcode.year_2024.day_03;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultiplyParserTest {

    @Test
    public void testParseProgram() {
        MultiplyParser multiplyParser = new MultiplyParser();
        List<Mutiply> list = multiplyParser.parseProgram("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))");

        assertEquals(4, list.size());
        assertEquals(2, list.getFirst().one());
        assertEquals(4, list.getFirst().two());
    }

    @Test
    public void testParseProgramDoDont() {
        MultiplyParser multiplyParser = new MultiplyParser();
        List<Mutiply> list = multiplyParser.parseProgramDoDont("xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))");

        assertEquals(2, list.size());
        assertEquals(2, list.getFirst().one());
        assertEquals(4, list.getFirst().two());
        assertEquals(8, list.getLast().one());
        assertEquals(5, list.getLast().two());
    }

}
