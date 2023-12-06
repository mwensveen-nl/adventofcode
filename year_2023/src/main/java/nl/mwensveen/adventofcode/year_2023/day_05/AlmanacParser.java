package nl.mwensveen.adventofcode.year_2023.day_05;

import java.util.List;

import com.google.common.base.Strings;

public class AlmanacParser {

	public AlmanacSeeds parseInputToSeeds(List<String> input) {
		AlmanacSeeds almanac = null;
		boolean start = true;
		boolean newConversion = false;
		Conversion conversion = null;
		for (String line : input) {
			if (start) {
				almanac = AlmanacSeeds.parse(line);
				start = false;
			} else if (Strings.isNullOrEmpty(line)) {
				newConversion = true;
			} else if (newConversion) {
				conversion = Conversion.parse(line);
				almanac.conversions().add(conversion);
				newConversion = false;
			} else {
				conversion.addRange(line);
			}
		}
		return almanac;
	}

	public AlmanacSeedRanges parseInputToSeedRanges(List<String> input) {
		AlmanacSeedRanges almanac = null;
		boolean start = true;
		boolean newConversion = false;
		Conversion conversion = null;
		for (String line : input) {
			if (start) {
				almanac = AlmanacSeedRanges.parse(line);
				start = false;
			} else if (Strings.isNullOrEmpty(line)) {
				newConversion = true;
			} else if (newConversion) {
				conversion = Conversion.parse(line);
				almanac.conversions().add(conversion);
				newConversion = false;
			} else {
				conversion.addRange(line);
			}
		}
		return almanac;
	}
}
