package nl.mwensveen.adventofcode.year_2024.day_04;

import com.google.common.collect.Table;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class XmasSearcherTest {

    private static String input = """
            MMMSXXMASM
            MSAMXMSMSA
            AMXSXMAAMM
            MSAMASMSMX
            XMASAMXAMM
            XXAMMXXAMA
            SMSMSASXSS
            SAXAMASAAA
            MAMMMXMMMM
            MXMXAXMASX
            			""";

    @Test
    public void testSearchXmas() {
        WordSearchInputParser parser = new WordSearchInputParser();
        Table<Integer, Integer, Character> table = parser.parse(input.lines().toList());

        XmasSearcher searcher = new XmasSearcher();
        int count = searcher.searchXmas(table);

        assertEquals(18, count);
    }

}
