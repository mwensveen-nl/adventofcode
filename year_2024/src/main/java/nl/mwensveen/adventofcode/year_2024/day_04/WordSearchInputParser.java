package nl.mwensveen.adventofcode.year_2024.day_04;

import java.util.List;
import java.util.stream.IntStream;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class WordSearchInputParser {

	public Table<Integer, Integer, Character> parse(List<String> input) {
		Table<Integer, Integer, Character> table = HashBasedTable.create();

		IntStream.range(0, input.size()).forEach(i -> parseLine(i, input.get(i), table));
		return table;
	}

	private void parseLine(int i, String line, Table<Integer, Integer, Character> table) {
		IntStream.range(0, line.length()).forEach(j -> table.put(i, j, line.charAt(j)));
	}

}
