package nl.mwensveen.adventofcode.year_2023.day_13;

import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import com.google.common.collect.Table;

public class ReflectionFinder {

	public int find(Table<Integer, Integer, Symbol> pattern) {
		OptionalInt foundCol = IntStream.range(1, pattern.columnKeySet().size()).filter(i -> isReflectionCol(pattern, i)).findFirst();
		if (foundCol.isPresent()) {
			return foundCol.getAsInt();
		}
		OptionalInt foundRow = IntStream.range(1, pattern.rowKeySet().size()).filter(i -> isReflectionRow(pattern, i)).findFirst();
		return foundRow.getAsInt() * 100;
	}

	private boolean isReflectionCol(Table<Integer, Integer, Symbol> pattern, int i) {
		int c1Start = i;
		int c2Start = i + 1;
		int c2End = pattern.columnKeySet().size();
		for (int c1 = c1Start, c2 = c2Start; c1 >= 1 && c2 <= c2End; c1--, c2++) {
			if (!pattern.column(c1).equals(pattern.column(c2))) {
				return false;
			}
		}
		return true;
	}

	private boolean isReflectionRow(Table<Integer, Integer, Symbol> pattern, int i) {
		int r1Start = i;
		int r2Start = i + 1;
		int r2End = pattern.rowKeySet().size();
		for (int r1 = r1Start, r2 = r2Start; r1 >= 1 && r2 <= r2End; r1--, r2++) {
			if (!pattern.row(r1).equals(pattern.row(r2))) {
				return false;
			}
		}
		return true;
	}

	public int findWithSmudge(Table<Integer, Integer, Symbol> pattern) {
		OptionalInt foundCol = IntStream.range(1, pattern.columnKeySet().size()).filter(i -> isReflectionWithSmudgeCol(pattern, i)).findFirst();
		if (foundCol.isPresent()) {
			return foundCol.getAsInt();
		}
		OptionalInt foundRow = IntStream.range(1, pattern.rowKeySet().size()).filter(i -> isReflectionWithSmudgeRow(pattern, i)).findFirst();
		return foundRow.getAsInt() * 100;
	}

	private boolean isReflectionWithSmudgeCol(Table<Integer, Integer, Symbol> pattern, int i) {
		int c1Start = i;
		int c2Start = i + 1;
		int c2End = pattern.columnKeySet().size();
		boolean smudgeFound = false;
		for (int c1 = c1Start, c2 = c2Start; c1 >= 1 && c2 <= c2End; c1--, c2++) {
			boolean withSmudge = patternMatchWithSmudge(pattern.column(c1), pattern.column(c2));
			if (!(pattern.column(c1).equals(pattern.column(c2)) || withSmudge)) {
				return false;
			}
			if (withSmudge) {
				if (smudgeFound) {
					return false;
				}
				smudgeFound = true;
			}
		}
		return smudgeFound;
	}

	private boolean isReflectionWithSmudgeRow(Table<Integer, Integer, Symbol> pattern, int i) {
		int r1Start = i;
		int r2Start = i + 1;
		int r2End = pattern.rowKeySet().size();
		boolean smudgeFound = false;
		for (int r1 = r1Start, r2 = r2Start; r1 >= 1 && r2 <= r2End; r1--, r2++) {
			boolean withSmudge = patternMatchWithSmudge(pattern.row(r1), pattern.row(r2));
			if (!(pattern.row(r1).equals(pattern.row(r2)) || withSmudge)) {
				return false;
			}
			if (withSmudge) {
				if (smudgeFound) {
					return false;
				}
				smudgeFound = true;
			}
		}
		return smudgeFound;
	}

	private boolean patternMatchWithSmudge(Map<Integer, Symbol> map, Map<Integer, Symbol> map2) {
		long count = map.keySet().stream().filter(key -> !map.get(key).equals(map2.get(key))).count();
		return count == 1;
	}

}
