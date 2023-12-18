package nl.mwensveen.adventofcode.year_2023.day_14;

import java.util.List;
import java.util.stream.IntStream;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class PlatformParser {

	public Table<Integer, Integer, Rock> parse(List<String> input) {
		Table<Integer, Integer, Rock> platform = HashBasedTable.create();

		IntStream.range(0, input.size()).forEach(r -> parseRow(r, input.get(r), platform));
		return platform;
	}

	private void parseRow(int r, String row, Table<Integer, Integer, Rock> platform) {
		IntStream.range(0, row.length()).forEach(c -> addRockToPlatform(r, c, row.substring(c, c + 1), platform));
	}

	private void addRockToPlatform(int r, int c, String symbol, Table<Integer, Integer, Rock> platform) {
		if (!symbol.equals(".")) {
			platform.put(r, c, Rock.find(symbol));
		}
	}
}
