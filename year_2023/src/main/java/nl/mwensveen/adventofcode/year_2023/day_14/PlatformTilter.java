package nl.mwensveen.adventofcode.year_2023.day_14;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Table;

public class PlatformTilter {

	public long tiltNorth(Table<Integer, Integer, Rock> platform) {
		long sum = 0;
		int load = platform.rowKeySet().stream().collect(Collectors.maxBy((i1, i2) -> i1.compareTo(i2))).get() + 1;

		for (int c = 0; c < platform.columnKeySet().size(); c++) {
			Map<Integer, Rock> column = platform.column(c);

			Set<Integer> keys = column.keySet();
			int i = 0;
			for (Iterator<Integer> iterator = keys.iterator(); iterator.hasNext();) {
				Integer integer = iterator.next();
				Rock rock = column.get(integer);
				if (Rock.ROUND == rock) {
					sum = sum + load - i;
				} else {
					// load = integer;
					i = integer;
				}
				i++;
			}
		}
		return sum;
	}
}
