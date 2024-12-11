package nl.mwensveen.adventofcode.year_2024.day_09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiskMapFileProcessorTest {
    public static String input = "2333133121414131402";

    @Test
    public void testProcess() {
        long checksum = new DiskMapFileProcessor().process(input);
        assertEquals(2858, checksum);
    }

}
