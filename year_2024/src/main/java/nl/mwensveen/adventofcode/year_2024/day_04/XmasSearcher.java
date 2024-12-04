package nl.mwensveen.adventofcode.year_2024.day_04;

import com.google.common.collect.Table;

public class XmasSearcher {

	private static String WORD = "XMAS";
	private static int WORDSIZE = WORD.length();

	public int search(Table<Integer, Integer, Character> table) {
		int rows = table.rowKeySet().size();
		int columns = table.columnKeySet().size();
		int count = 0;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				count += searchWord(r, c, table);
			}
		}
		return count;
	}

	private int searchWord(int r, int c, Table<Integer, Integer, Character> table) {
		int count = 0;
		if (table.get(r, c) == WORD.charAt(0)) {
			if (r >= WORDSIZE - 1) {
				// can go up
				if (checkUp(r, c, table)) {
					count++;
				}
			}
			if (r <= table.rowKeySet().size() - WORDSIZE) {
				// can go down
				if (checkDown(r, c, table)) {
					count++;
				}
			}
		}
		return count;
	}

	private boolean checkDown(int r, int c, Table<Integer, Integer, Character> table) {
		for (int i = 1; i < WORDSIZE; i++) {
			if (table.get(r + i, c) != WORD.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	private boolean checkUp(int r, int c, Table<Integer, Integer, Character> table) {
		for (int i = 1; i < WORDSIZE; i++) {
			if (table.get(r - i, c) != WORD.charAt(i)) {
				return false;
			}
		}
		return true;
	}
}
