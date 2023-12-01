package nl.mwensveen.adventofcode.year_2023.day_01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CalibrationRecoverer {
	static Map<String, Integer> words = new HashMap<>();
	static {
		words.put("one", 1);
		words.put("two", 2);
		words.put("three", 3);
		words.put("four", 4);
		words.put("five", 5);
		words.put("six", 6);
		words.put("seven", 7);
		words.put("eight", 8);
		words.put("nine", 9);
	}

	public Long calculateSumOfCalibrations(List<String> input) {
		return input.stream().map(line -> onlyDigits(line)).map(digits -> firstLast(digits)).collect(Collectors.summingLong(Integer::longValue));
	}

	public Long calculateSumOfCalibrationsWithWords(List<String> input) {
		return input.stream().map(line -> onlyDigitsOrWords(line)).map(digits -> firstLast(digits)).collect(Collectors.summingLong(Integer::longValue));
	}

	private int firstLast(String digits) {
		String fl = digits.substring(0, 1).concat(digits.substring(digits.length() - 1));
		return Integer.valueOf(fl);
	}

	private String onlyDigits(String line) {
		return line.chars().filter(i -> Character.isDigit(i)).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
	}

	private String onlyDigitsOrWords(String line) {
		String newLine = line;
		for (Map.Entry<String, Integer> entry : words.entrySet()) {
			String key = entry.getKey();
			String value = Integer.toString(entry.getValue());
			newLine = newLine.replace(key, key + value + key);
		}
		return onlyDigits(newLine);
	}
}
