package nl.mwensveen.adventofcode.year_2023.day_11;

import java.util.stream.IntStream;

import com.google.common.collect.Table;

public class DistanceCalculator {
	private int expansion;

	public DistanceCalculator(int expansion) {
		this.expansion = expansion - 1;
	}

	public long calculate(Table<Integer, Integer, String> galaxies) {
		return galaxies.rowKeySet().stream().mapToLong(row -> calculateForRow(row, galaxies)).sum();
	}

	private Long calculateForRow(Integer row, Table<Integer, Integer, String> galaxies) {
		return galaxies.row(row).keySet().stream().mapToLong(col -> calculateGalaxy(row, col, galaxies)).sum();
	}

	private Long calculateGalaxy(Integer row, Integer col, Table<Integer, Integer, String> galaxies) {
		long sum = galaxies.row(row).keySet().stream().filter(i -> i > col).mapToLong(col2 -> calc(row, row, col, col2, galaxies)).sum();
		sum += galaxies.cellSet().stream().filter(c -> c.getRowKey() > row).mapToLong(c -> calc(row, c.getRowKey(), col, c.getColumnKey(), galaxies)).sum();

		return sum;
	}

	private Long calc(Integer row1, Integer row2, Integer col1, Integer col2, Table<Integer, Integer, String> galaxies) {
		long distance = row2 - row1 + Math.abs(col2 - col1);
		distance += IntStream.range(row1 + 1, row2).map(row -> galaxies.containsRow(row) ? 0 : expansion).sum();
		distance += IntStream.range(Math.min(col1, col2), Math.max(col1, col2)).map(col -> galaxies.containsColumn(col) ? 0 : expansion).sum();
		return distance;
	}
}
