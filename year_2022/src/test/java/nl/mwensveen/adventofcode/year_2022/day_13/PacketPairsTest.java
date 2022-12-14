package nl.mwensveen.adventofcode.year_2022.day_13;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

public class PacketPairsTest {

	@Test
	public void testPacketPairs() {
		PacketPairs packetPairs = new PacketPairs(1, "[1,1,3,1,1]", "[1,[1,50],1,1]");
		assertEquals(1, packetPairs.getNumber());
		assertEquals("1,1,3,1,1", packetPairs.getLeft());
		assertEquals("1,[1,50],1,1", packetPairs.getRight());
		assertIterableEquals(List.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(1)),
				packetPairs.getLeftList());
		assertIterableEquals(List.of(Integer.valueOf(1), List.of(Integer.valueOf(1), Integer.valueOf(50)), Integer.valueOf(1), Integer.valueOf(1)),
				packetPairs.getRightList());
	}

	@Test
	public void testPacketPairs2() {
		PacketPairs packetPairs = new PacketPairs(8, "[1,[2,[3,[4,[5,6,7]]]],8,9]", "[[[]]]");
		assertEquals(8, packetPairs.getNumber());
		assertIterableEquals(
				List.of(Integer.valueOf(1),
						List.of(Integer.valueOf(2),
								List.of(Integer.valueOf(3), List.of(Integer.valueOf(4), List.of(Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7))))),
						Integer.valueOf(8), Integer.valueOf(9)),
				packetPairs.getLeftList());
		assertIterableEquals(List.of(List.of(Optional.empty())), packetPairs.getRightList());
	}

}
