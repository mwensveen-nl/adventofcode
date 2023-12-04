package nl.mwensveen.adventofcode.year_2023.day_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.google.common.collect.Table;

public class PartDiscoverer {

	private static String digits = "0123456789";

	public List<Integer> discoverParts(Table<Integer, Integer, String> schematic) {
		return schematic.rowKeySet().stream().map(i -> processRow(i, schematic)).flatMap(l -> l.stream()).toList();
	}

	private List<Integer> processRow(Integer rowIndex, Table<Integer, Integer, String> schematic) {
		List<Integer> parts = new ArrayList<>();

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
					parts.add(Integer.valueOf(partsNumber.toString()));
				}
				isPart = false;
				partsNumber = new StringBuilder();
			}
		}
		if (isPart) {
			parts.add(Integer.valueOf(partsNumber.toString()));
		}
		return parts;
	}

	private boolean isPart(Integer rowIndex, int colIndex, Table<Integer, Integer, String> schematic) {
		for (int r = -1; r <= 1; r++) {
			for (int c = -1; c <= 1; c++) {
				String s = schematic.get(rowIndex + r, colIndex + c);
				if (!(s == null || digits.contains(s) || ".".equals(s))) {
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
