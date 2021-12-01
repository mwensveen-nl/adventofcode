package nl.mwensveen.adventofcode.year_2021.day_01;

import java.util.List;

import com.codepoetics.protonpack.StreamUtils;

public class DepthMeasurementCalculator {

	long calculateNumberOfIncreases(List<Integer> depths) {
		return StreamUtils.zipWithIndex(depths.stream()).map(di -> {
			if (di.getIndex() > 0) {
				return (di.getValue() > depths.get(((int) di.getIndex()) - 1));
			}
			return false;
		}).filter(b -> b).count();
	}
}
