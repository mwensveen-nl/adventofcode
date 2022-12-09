package nl.mwensveen.adventofcode.year_2022.day_09;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Rope {
	private List<Position> positions;
	private Set<Position> tPositions;

	public Rope(int i) {
		positions = new ArrayList<>();
		tPositions = new HashSet<>();
		for (int j = 0; j < i; j++) {
			positions.add(new Position(0, 0));
		}
	}

	public void replace(int index, Position newPosition) {
		positions.set(index, newPosition);
	}

	public Position get(int index) {
		return positions.get(index);
	}

	public int size() {
		return positions.size();
	}

	public void addTPosition(Position t) {
		tPositions.add(t);
	}

	public int sizeTPositions() {
		return tPositions.size();
	}

}
