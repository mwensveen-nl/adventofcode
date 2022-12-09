package nl.mwensveen.adventofcode.year_2022.day_09;

import java.util.List;
import java.util.Set;

public class RopeMover {

	public Rope multipleMoveRope(Rope rope, List<String> moves) {
		Rope result = rope;
		for (String move : moves) {
			result = moveRope(result, move);
		}
		return result;
	}

	public Rope moveRope(Rope rope, String move) {
		String[] split = move.split(" ");
		String direction = split[0];
		int number = Integer.parseInt(split[1]);

		Rope newRope = rope;
		for (int i = 0; i < number; i++) {
			newRope = moveOneStep(newRope, direction);
		}
		return newRope;
	}

	private Rope moveOneStep(Rope rope, String direction) {
		Position h = rope.h();
		Position t = rope.t();
		Set<Position> tPositions = rope.tPositions();

		h = switch (direction) {
			case "R" -> new Position(h.row(), h.column() + 1);
			case "L" -> new Position(h.row(), h.column() - 1);
			case "U" -> new Position(h.row() + 1, h.column());
			case "D" -> new Position(h.row() - 1, h.column());
			default -> throw new IllegalArgumentException("Unexpected value: " + direction);
		};

		int rowDif = h.row() - t.row();
		int columnDif = h.column() - t.column();
		if (Math.abs(rowDif) > 1 || Math.abs(columnDif) > 1) {
			if (rowDif < 0) {
				rowDif--;
			} else {
				rowDif++;
			}
			if (columnDif < 0) {
				columnDif--;
			} else {
				columnDif++;
			}
			t = new Position(t.row() + rowDif / 2, t.column() + columnDif / 2);
		}
		tPositions.add(t);
		return new Rope(h, t, tPositions);
	}
}
