package nl.mwensveen.adventofcode.year_2023.day_13;

import java.util.List;

import com.google.common.collect.Table;

public class PatternAnalyzer {

	long analyze(List<Table<Integer, Integer, Symbol>> pattern) {
		ReflectionFinder reflectionFinder = new ReflectionFinder();
		return pattern.stream().mapToInt(reflectionFinder::find).asLongStream().sum();
	}

	long analyzeWithSmudge(List<Table<Integer, Integer, Symbol>> pattern) {
		ReflectionFinder reflectionFinder = new ReflectionFinder();
		return pattern.stream().mapToInt(reflectionFinder::findWithSmudge).asLongStream().sum();
	}

}
