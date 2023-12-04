package nl.mwensveen.adventofcode.year_2023.day_03;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class GearDiscoverer {

	private static final String PARTS_SYMBOL = "P";
	private static String digits = "0123456789";

	public Long discoverGears(Table<Integer, Integer, String> schematic) {
		Table<Integer, Integer, String> partsTable = HashBasedTable.create();
		schematic.rowKeySet().stream().forEach(i -> replaceInRow(i, schematic, partsTable));

		return schematic.rowKeySet().stream().map(i -> rowsGearPower(i, schematic, partsTable)).collect(Collectors.summingLong(l -> l));
	}

	private Long rowsGearPower(Integer rowIndex, Table<Integer, Integer, String> schematic, Table<Integer, Integer, String> partsTable) {
		return schematic.row(rowIndex).entrySet().stream()
				.filter(entry -> "*".equals(entry.getValue()))
				.filter(entry -> isGear(rowIndex, entry.getKey(), partsTable))
				.map(entry -> calculateGearRatio(rowIndex, entry.getKey(), schematic))
				.collect(Collectors.summingLong(i -> i));
	}

	private long calculateGearRatio(Integer rowIndex, Integer colIndex, Table<Integer, Integer, String> schematic) {
		long ratio = 1;
		ratio *= calculateGearRatioForGear(colIndex, schematic, rowIndex - 1);
		ratio *= calculateGearRatioForGear(colIndex, schematic, rowIndex);
		ratio *= calculateGearRatioForGear(colIndex, schematic, rowIndex + 1);
		return ratio;
	}

	private long calculateGearRatioForGear(Integer colIndex, Table<Integer, Integer, String> schematic, int row) {
		long ratio = 1;
		if (digits.contains(schematic.get(row, colIndex - 1))) {
			ratio *= partNumber(row, colIndex - 1, schematic);
		}
		if (digits.contains(schematic.get(row, colIndex)) && !digits.contains(schematic.get(row, colIndex - 1))) {
			ratio *= partNumber(row, colIndex, schematic);
		}
		if (digits.contains(schematic.get(row, colIndex + 1)) && !digits.contains(schematic.get(row, colIndex))) {
			ratio *= partNumber(row, colIndex + 1, schematic);
		}
		return ratio;
	}

	private int partNumber(int rowIndex, int colIndex, Table<Integer, Integer, String> schematic) {
		int c = colIndex - 1;
		while (schematic.get(rowIndex, c) != null && digits.contains(schematic.get(rowIndex, c))) {
			c--;
		}
		c++;
		StringBuilder part = new StringBuilder();
		while (schematic.get(rowIndex, c) != null && digits.contains(schematic.get(rowIndex, c))) {
			part.append(schematic.get(rowIndex, c));
			c++;
		}
		return Integer.valueOf(part.toString());
	}

	private boolean isGear(Integer rowIndex, Integer colIndex, Table<Integer, Integer, String> partsTable) {
		int p = 0;

		p += adjacentPart(colIndex, partsTable, rowIndex - 1);
		p += adjacentPart(colIndex, partsTable, rowIndex);
		p += adjacentPart(colIndex, partsTable, rowIndex + 1);

		return p == 2;
	}

	private int adjacentPart(Integer colIndex, Table<Integer, Integer, String> partsTable, int above) {
		int p = 0;
		if (PARTS_SYMBOL.equals(partsTable.get(above, colIndex - 1))) {
			p++;
		}
		if (PARTS_SYMBOL.equals(partsTable.get(above, colIndex)) && !PARTS_SYMBOL.equals(partsTable.get(above, colIndex - 1))) {
			p++;
		}
		if (PARTS_SYMBOL.equals(partsTable.get(above, colIndex + 1)) && !PARTS_SYMBOL.equals(partsTable.get(above, colIndex))) {
			p++;
		}
		return p;
	}

	private Table<Integer, Integer, String> replaceInRow(Integer rowIndex, Table<Integer, Integer, String> schematic,
			Table<Integer, Integer, String> partsTable) {
		Map<Integer, String> row = schematic.row(rowIndex);

		StringBuilder partsNumber = new StringBuilder();
		boolean isPart = false;

		for (Entry<Integer, String> entry : row.entrySet()) {
			String c = entry.getValue();
			if (digits.contains(c)) {
				partsNumber.append(c);
				if (isPart(rowIndex, entry.getKey(), schematic)) {
					isPart = true;
				}
			} else {
				if (isPart) {
					replacePart(schematic, rowIndex, entry.getKey() - 1, partsNumber.length(), partsTable);
				}
				isPart = false;
				partsNumber = new StringBuilder();
			}
		}
		if (isPart) {
			replacePart(schematic, rowIndex, row.size() - 1, partsNumber.length(), partsTable);
		}
		return schematic;
	}

	private void replacePart(Table<Integer, Integer, String> schematic, Integer rowIndex, int colIndex, int length,
			Table<Integer, Integer, String> partsTable) {
		for (int i = 0; i < length; i++) {
			partsTable.put(rowIndex, colIndex - i, PARTS_SYMBOL);
		}

	}

	private boolean isPart(Integer rowIndex, int colIndex, Table<Integer, Integer, String> schematic) {
		for (int r = -1; r <= 1; r++) {
			for (int c = -1; c <= 1; c++) {
				String s = schematic.get(rowIndex + r, colIndex + c);
				if (!(s == null || digits.contains(s) || ".".equals(s) || PARTS_SYMBOL.equals(s))) {
					return true;
				}
			}
		}
		return false;
	}

	public Long sumParts(List<Integer> parts) {
		return parts.stream().collect(Collectors.summingLong(Integer::longValue));
	}
}
