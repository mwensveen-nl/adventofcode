package nl.mwensveen.adventofcode.year_2025.day_06;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.common.collect.Table;
import java.util.List;
import org.junit.jupiter.api.Test;

class HomeWorksheetParserTest {
    private String input = """
            123 328  51 64
             45 64  387 23
              6 98  215 314
            *   +   *   +
                    """;

    @Test
    public void parse() {
        Table<Integer, Integer, String> worksheet = new HomeWorksheetParser().parse(input.lines().toList());

        assertEquals("123", worksheet.get(Integer.valueOf(0), Integer.valueOf(0)));
        assertEquals("328", worksheet.get(Integer.valueOf(0), Integer.valueOf(1)));
        assertEquals("51", worksheet.get(Integer.valueOf(0), Integer.valueOf(2)));
        assertEquals("64", worksheet.get(Integer.valueOf(0), Integer.valueOf(3)));

        assertEquals("45", worksheet.get(Integer.valueOf(1), Integer.valueOf(0)));
        assertEquals("64", worksheet.get(Integer.valueOf(1), Integer.valueOf(1)));
        assertEquals("387", worksheet.get(Integer.valueOf(1), Integer.valueOf(2)));
        assertEquals("23", worksheet.get(Integer.valueOf(1), Integer.valueOf(3)));

        assertEquals("6", worksheet.get(Integer.valueOf(2), Integer.valueOf(0)));
        assertEquals("98", worksheet.get(Integer.valueOf(2), Integer.valueOf(1)));
        assertEquals("215", worksheet.get(Integer.valueOf(2), Integer.valueOf(2)));
        assertEquals("314", worksheet.get(Integer.valueOf(2), Integer.valueOf(3)));

        assertEquals("*", worksheet.get(Integer.valueOf(3), Integer.valueOf(0)));
        assertEquals("+", worksheet.get(Integer.valueOf(3), Integer.valueOf(1)));
        assertEquals("*", worksheet.get(Integer.valueOf(3), Integer.valueOf(2)));
        assertEquals("+", worksheet.get(Integer.valueOf(3), Integer.valueOf(3)));
    }

    @Test
    public void parseCephalopod() {
        List<String> list = input.lines().toList();
        List<List<String>> worksheet = new HomeWorksheetParser().parseCephalopod(list);
        assertEquals(4, worksheet.size());
        assertTrue(worksheet.get(0).containsAll(List.of("123", " 45", "  6", "*  ")));
        assertTrue(worksheet.get(1).containsAll(List.of("328", "64 ", "98 ", "+  ")));
        assertTrue(worksheet.get(2).containsAll(List.of(" 51", "387", "215", "*  ")));
        assertTrue(worksheet.get(3).containsAll(List.of("64 ", "23 ", "314", "+  ")));
        System.out.println(worksheet);
    }
}
