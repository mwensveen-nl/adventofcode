package nl.mwensveen.adventofcode.year_2023.day_13;

import com.google.common.collect.Table;
import java.util.List;

public class PatternAnalyzer {

    long analyze(List<Table<Integer, Integer, Symbol>> pattern) {
        ReflectionFinder reflectionFinder = new ReflectionFinder();
        return pattern.stream().mapToInt(reflectionFinder::find).asLongStream().sum();
    }

}
