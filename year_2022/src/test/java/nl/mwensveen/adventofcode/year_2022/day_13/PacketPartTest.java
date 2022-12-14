package nl.mwensveen.adventofcode.year_2022.day_13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PacketPartTest {

    @Test
    public void testCompareTo() {
        PacketPart p1 = new PacketPart("[]");
        PacketPart p2 = new PacketPart("[[]]");
        assertTrue(p1.compareTo(p2) < 0);
        assertTrue(p2.compareTo(p1) > 0);
        assertTrue(p1.compareTo(p1) == 0);
    }

    @Test
    public void testCompareTo2() {
        PacketPart p1 = new PacketPart("[[[]]]");
        PacketPart p2 = new PacketPart("[1,1,3,1,1]");
        assertTrue(p1.compareTo(p2) < 0);
        assertTrue(p2.compareTo(p1) > 0);
        assertTrue(p1.compareTo(p1) == 0);
    }

    @Test
    public void testCompareTo3() {
        PacketPart p1 = new PacketPart("[1,1,3,1,1]");
        PacketPart p2 = new PacketPart("[1,1,5,1,1]");
        assertTrue(p1.compareTo(p2) < 0);
        assertTrue(p2.compareTo(p1) > 0);
        assertTrue(p1.compareTo(p1) == 0);
    }

}
