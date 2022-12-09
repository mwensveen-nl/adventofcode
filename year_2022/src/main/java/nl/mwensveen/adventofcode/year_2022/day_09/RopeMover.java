package nl.mwensveen.adventofcode.year_2022.day_09;

import java.util.List;

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
		int size = rope.size();

		Position leader = rope.get(0);
		leader = switch (direction) {
			case "R" -> new Position(leader.row(), leader.column() + 1);
			case "L" -> new Position(leader.row(), leader.column() - 1);
			case "U" -> new Position(leader.row() + 1, leader.column());
			case "D" -> new Position(leader.row() - 1, leader.column());
			default -> throw new IllegalArgumentException("Unexpected value: " + direction);
		};
		rope.replace(0, leader);

		Position follower = null;
		for (int i = 1; i < size; i++) {
			follower = rope.get(i);
			follower = follow(leader, follower);
			rope.replace(i, follower);
			leader = follower;
		}
		rope.addTPosition(follower);
		return rope;
	}

	private Position follow(Position leader, Position follower) {
		int rowDif = leader.row() - follower.row();
		int columnDif = leader.column() - follower.column();
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
			follower = new Position(follower.row() + rowDif / 2, follower.column() + columnDif / 2);
		}
		return follower;
	}
}
