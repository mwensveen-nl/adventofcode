package nl.mwensveen.adventofcode.year_2023.day_03;

import java.util.List;
import java.util.stream.IntStream;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class EngineSchematicParser {

	public Table<Integer, Integer, String> parse(List<String> input) {
		Table<Integer, Integer, String> table = HashBasedTable.create();
		IntStream.range(0, input.size()).mapToObj(i -> new Object() {
			int rowIndex = i;
			String line = input.get(i);
		}).forEach(o -> parseRow(o.rowIndex, o.line, table));
		;

		return table;
	}

	private void parseRow(int rowIndex, String line, Table<Integer, Integer, String> table) {
		IntStream.range(0, line.length()).mapToObj(i -> new Object() {
			int colIndex = i;
			String s = line.substring(i, i + 1);
		}).forEach(o -> table.put(rowIndex, o.colIndex, o.s));
	}

}
