package nl.mwensveen.adventofcode.year_2021.day_04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.common.collect.Table;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class InputParserTest {

    @Test
    public void testParseFirstRow() {
        InputParser inputParser = new InputParser();
        List<Integer> firstRow = inputParser.parseFirstRow("7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1");
        assertEquals(27, firstRow.size());
        assertEquals(7, firstRow.get(0));
        assertEquals(1, firstRow.get(26));
    }

    @Test
    public void testParseOtherInput() {
        List<String> input = Arrays.asList(
                "",
                "22 13 17 11  0",
                " 8  2 23  4 24",
                "21  9 14 16  7",
                " 6 10  3 18  5",
                " 1 12 20 15 19",
                "",
                " 3 15  0  2 22",
                " 9 18 13 17  5",
                "19  8  7 25 23",
                "20 11 10 24  4",
                "14 21 16 12  6",
                "",
                "14 21 17 24  4",
                "10 16 15  9 19",
                "18  8 23 26 20",
                "22 11 13  6  5",
                " 2  0 12  3  7");
        InputParser inputParser = new InputParser();
        List<Table<Long, Long, Integer>> boards = inputParser.parseOtherInput(input);
        assertEquals(3, boards.size());
    }

}
