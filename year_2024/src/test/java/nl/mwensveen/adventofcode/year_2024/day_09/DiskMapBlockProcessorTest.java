package nl.mwensveen.adventofcode.year_2024.day_09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiskMapBlockProcessorTest {
    public static String input = "2333133121414131402";

    @Test
    public void testParse() {
        long checksum = new DiskMapBlockProcessor().parse(input);
        assertEquals(1928, checksum);
    }

}
