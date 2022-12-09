package nl.mwensveen.adventofcode.year_2022.day_09;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

public class RopeMoverTest {
	private String input = """
			R 4
			U 4
			L 3
			D 1
			R 4
			D 1
			L 5
			R 2
						""";
	private RopeMover ropeMover = new RopeMover();

	@Test
	public void testMoveRope() {
		Rope rope = new Rope(new Position(0, 0), new Position(0, 0), new HashSet<>());

		rope = ropeMover.moveRope(rope, "R 4");
		assertEquals(new Position(0, 4), rope.h());
		assertEquals(new Position(0, 3), rope.t());
		assertEquals(4, rope.tPositions().size());

		rope = ropeMover.moveRope(rope, "U 4");
		assertEquals(new Position(4, 4), rope.h());
		assertEquals(new Position(3, 4), rope.t());
		assertEquals(7, rope.tPositions().size());

		rope = ropeMover.moveRope(rope, "L 3");
		assertEquals(new Position(4, 1), rope.h());
		assertEquals(new Position(4, 2), rope.t());
		assertEquals(9, rope.tPositions().size());

		rope = ropeMover.moveRope(rope, "D 2");
		assertEquals(new Position(2, 1), rope.h());
		assertEquals(new Position(3, 1), rope.t());
		assertEquals(10, rope.tPositions().size());
	}

	@Test
	public void testMultipleMoveRope() {
		Rope rope = new Rope(new Position(0, 0), new Position(0, 0), new HashSet<>());
		Rope multipleMoveRope = ropeMover.multipleMoveRope(rope, input.lines().toList());
		assertEquals(new Position(2, 2), multipleMoveRope.h());
		assertEquals(new Position(2, 1), multipleMoveRope.t());
		assertEquals(13, multipleMoveRope.tPositions().size());
	}

}
