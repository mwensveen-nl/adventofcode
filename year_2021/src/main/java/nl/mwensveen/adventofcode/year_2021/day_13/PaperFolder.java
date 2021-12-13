package nl.mwensveen.adventofcode.year_2021.day_13;

import java.util.Map;

import org.javatuples.Pair;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class PaperFolder {

	Table<Integer, Integer, Character> foldPaper(String input, Table<Integer, Integer, Character> paper) {
		String fold = input.split(" ")[2];

		Pair<String, Integer> instruction = Pair.with(fold.split("=")[0], Integer.parseInt(fold.split("=")[1]));

		Table<Integer, Integer, Character> foldedPaper = null;
		if (instruction.getValue0().equals("y")) {
			foldedPaper = foldUp(paper, instruction.getValue1());
		} else {
			foldedPaper = foldLeft(paper, instruction.getValue1());
		}

		return foldedPaper;
	}

	private Table<Integer, Integer, Character> foldLeft(Table<Integer, Integer, Character> paper, Integer foldColumn) {
		Table<Integer, Integer, Character> foldedPaper = HashBasedTable.create();
		paper.columnKeySet().stream().filter(colNr -> colNr < foldColumn).forEach(colNr -> copyColumn(foldedPaper, paper, colNr));
		paper.columnKeySet().stream().filter(columnNr -> columnNr > foldColumn).forEach(columnNr -> moveColumn(columnNr, foldColumn, paper, foldedPaper));
		return foldedPaper;
	}

	private void copyColumn(Table<Integer, Integer, Character> foldedPaper, Table<Integer, Integer, Character> paper, Integer colNr) {
		Map<Integer, Character> column = paper.column(colNr);
		column.keySet().forEach(rowNr -> foldedPaper.put(rowNr, colNr, '#'));
	}

	private void moveColumn(Integer columnNr, Integer foldColumn, Table<Integer, Integer, Character> paper, Table<Integer, Integer, Character> foldedPaper) {
		int newColumnNr = foldColumn * 2 - columnNr;
		paper.column(columnNr).entrySet().forEach(es -> foldedPaper.put(es.getKey(), newColumnNr, es.getValue()));
	}

	private Table<Integer, Integer, Character> foldUp(Table<Integer, Integer, Character> paper, Integer foldRow) {
		Table<Integer, Integer, Character> foldedPaper = HashBasedTable.create();
		paper.rowKeySet().stream().filter(rowNr -> rowNr < foldRow).forEach(rowNr -> copyRow(foldedPaper, paper, rowNr));

		paper.rowKeySet().stream().filter(rowNr -> rowNr > foldRow).forEach(rowNr -> moveRow(rowNr, foldRow, paper, foldedPaper));
		return foldedPaper;
	}

	private void copyRow(Table<Integer, Integer, Character> foldedPaper, Table<Integer, Integer, Character> paper, Integer rowNr) {
		Map<Integer, Character> row = paper.row(rowNr);
		row.keySet().forEach(colNr -> foldedPaper.put(rowNr, colNr, '#'));
	}

	private void moveRow(Integer rowNr, Integer foldRow, Table<Integer, Integer, Character> paper, Table<Integer, Integer, Character> foldedPaper) {
		int newRowNr = foldRow * 2 - rowNr;
		paper.row(rowNr).entrySet().forEach(es -> foldedPaper.put(newRowNr, es.getKey(), es.getValue()));
	}
}
