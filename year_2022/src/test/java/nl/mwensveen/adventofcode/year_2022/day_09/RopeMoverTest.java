package nl.mwensveen.adventofcode.year_2022.day_09;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
	private String input2 = """
			R 5
			U 8
			L 8
			D 3
			R 17
			D 10
			L 25
			U 20
						""";
	private RopeMover ropeMover = new RopeMover();

	@Test
	public void testMoveRope() {
		Rope rope = new Rope(2);

		rope = ropeMover.moveRope(rope, "R 4");
		assertEquals(new Position(0, 4), rope.get(0));
		assertEquals(new Position(0, 3), rope.get(1));
		assertEquals(4, rope.sizeTPositions());

		rope = ropeMover.moveRope(rope, "U 4");
		assertEquals(new Position(4, 4), rope.get(0));
		assertEquals(new Position(3, 4), rope.get(1));
		assertEquals(7, rope.sizeTPositions());

		rope = ropeMover.moveRope(rope, "L 3");
		assertEquals(new Position(4, 1), rope.get(0));
		assertEquals(new Position(4, 2), rope.get(1));
		assertEquals(9, rope.sizeTPositions());

		rope = ropeMover.moveRope(rope, "D 2");
		assertEquals(new Position(2, 1), rope.get(0));
		assertEquals(new Position(3, 1), rope.get(1));
		assertEquals(10, rope.sizeTPositions());
	}

	@Test
	public void testMultipleMoveRope() {
		Rope rope = new Rope(2);

		Rope multipleMoveRope = ropeMover.multipleMoveRope(rope, input.lines().toList());
		assertEquals(new Position(2, 2), multipleMoveRope.get(0));
		assertEquals(new Position(2, 1), multipleMoveRope.get(1));
		assertEquals(13, multipleMoveRope.sizeTPositions());
	}

	@Test
	public void testMultipleMoveRope10Knots() {
		Rope rope = new Rope(10);

		Rope multipleMoveRope = ropeMover.multipleMoveRope(rope, input.lines().toList());
		assertEquals(new Position(2, 2), multipleMoveRope.get(0));
		assertEquals(new Position(2, 1), multipleMoveRope.get(1));
		assertEquals(new Position(2, 2), multipleMoveRope.get(2));
		assertEquals(new Position(2, 3), multipleMoveRope.get(3));
		assertEquals(new Position(2, 2), multipleMoveRope.get(4));
		assertEquals(new Position(1, 1), multipleMoveRope.get(5));
		assertEquals(new Position(0, 0), multipleMoveRope.get(6));
		assertEquals(new Position(0, 0), multipleMoveRope.get(7));
		assertEquals(new Position(0, 0), multipleMoveRope.get(8));
		assertEquals(new Position(0, 0), multipleMoveRope.get(9));
		assertEquals(1, multipleMoveRope.sizeTPositions());
	}

	@Test
	public void testMultipleMoveRope10KnotsLargeMoves() {
		Rope rope = new Rope(10);

		Rope multipleMoveRope = ropeMover.multipleMoveRope(rope, input2.lines().toList());
		assertEquals(new Position(15, -11), multipleMoveRope.get(0));
		assertEquals(new Position(14, -11), multipleMoveRope.get(1));
		assertEquals(new Position(13, -11), multipleMoveRope.get(2));
		assertEquals(new Position(12, -11), multipleMoveRope.get(3));
		assertEquals(new Position(11, -11), multipleMoveRope.get(4));
		assertEquals(new Position(10, -11), multipleMoveRope.get(5));
		assertEquals(new Position(9, -11), multipleMoveRope.get(6));
		assertEquals(new Position(8, -11), multipleMoveRope.get(7));
		assertEquals(new Position(7, -11), multipleMoveRope.get(8));
		assertEquals(new Position(6, -11), multipleMoveRope.get(9));
		assertEquals(36, multipleMoveRope.sizeTPositions());
	}

}
