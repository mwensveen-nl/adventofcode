package nl.mwensveen.adventofcode.year_2021.day_04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.common.collect.Table;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BingoBoardParserTest {

    @Test
    public void testParseBoard() {
        List<String> input = Arrays.asList("31  5 70  8 88",
                "38 63 14 91 56",
                "22 67 17 47 74",
                "93 52 69 29 53",
                "33 66 64 19 73");

        BingoBoardParser bingoBoardParser = new BingoBoardParser();
        Table<Long, Long, Integer> board = bingoBoardParser.parseBoard(input);
        assertEquals(5, board.rowKeySet().size());
        assertEquals(5, board.row(0L).size());
        assertEquals(31, board.get(0L, 0L));
    }

}
