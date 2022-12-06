package nl.mwensveen.adventofcode.year_2022.day_06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StartOfPacketMarkerTest {

    @Test
    public void testFindMarker() {
        StartOfPacketMarker marker = new StartOfPacketMarker();
        assertEquals(7, marker.findMarker("mjqjpqmgbljsphdztnvjfqwrcgsmlb"));
        assertEquals(5, marker.findMarker("bvwbjplbgvbhsrlpgdmjqwftvncz"));
        assertEquals(6, marker.findMarker("nppdvjthqldpwncqszvftbrmjlhg"));
        assertEquals(10, marker.findMarker("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"));
        assertEquals(11, marker.findMarker("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"));
    }

}
