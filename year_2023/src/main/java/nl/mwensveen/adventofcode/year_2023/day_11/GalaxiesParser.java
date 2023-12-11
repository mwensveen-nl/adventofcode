package nl.mwensveen.adventofcode.year_2023.day_11;

import java.util.List;
import java.util.stream.IntStream;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class GalaxiesParser {

	public Table<Integer, Integer, String> parseGalaxies(List<String> input) {
		Table<Integer, Integer, String> galaxies = HashBasedTable.create();

		IntStream.range(0, input.size()).forEach(x -> parseLine(x, input.get(x), galaxies));
		return galaxies;
	}

	private void parseLine(int x, String line, Table<Integer, Integer, String> galaxies) {
		IntStream.range(0, line.length()).forEach(y -> addGalaxy(x, y, line.substring(y, y + 1), galaxies));
	}

	private void addGalaxy(int x, int y, String symbol, Table<Integer, Integer, String> galaxies) {
		if ("#".equals(symbol)) {
			galaxies.put(x, y, symbol);
		}
	}
}
