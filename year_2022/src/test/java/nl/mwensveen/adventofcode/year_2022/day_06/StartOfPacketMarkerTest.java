package nl.mwensveen.adventofcode.year_2022.day_06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StartOfPacketMarkerTest {

    @Test
    public void testFindMarker4Chars() {
        StartOfPacketMarker marker = new StartOfPacketMarker();
        assertEquals(7, marker.findMarker("mjqjpqmgbljsphdztnvjfqwrcgsmlb", 4));
        assertEquals(5, marker.findMarker("bvwbjplbgvbhsrlpgdmjqwftvncz", 4));
        assertEquals(6, marker.findMarker("nppdvjthqldpwncqszvftbrmjlhg", 4));
        assertEquals(10, marker.findMarker("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 4));
        assertEquals(11, marker.findMarker("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 4));
    }

    @Test
    public void testFindMarker14Chars() {
        StartOfPacketMarker marker = new StartOfPacketMarker();
        assertEquals(19, marker.findMarker("mjqjpqmgbljsphdztnvjfqwrcgsmlb", 14));
        assertEquals(23, marker.findMarker("bvwbjplbgvbhsrlpgdmjqwftvncz", 14));
        assertEquals(23, marker.findMarker("nppdvjthqldpwncqszvftbrmjlhg", 14));
        assertEquals(29, marker.findMarker("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 14));
        assertEquals(26, marker.findMarker("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 14));
    }

}
