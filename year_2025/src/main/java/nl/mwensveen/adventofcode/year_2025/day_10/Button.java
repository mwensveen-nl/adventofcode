package nl.mwensveen.adventofcode.year_2025.day_10;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public record Button(List<Integer> switches, Integer bits) {

    public Button(String input) {
        List<Integer> list = Arrays.stream(input.split(",")).map(String::trim).map(Integer::valueOf).toList();
        Integer converted = list.stream().map(t -> bitsMap.get(t)).reduce(0, (a, b) -> a + b);
        this(list, converted);
    }

    private static Map<Integer, Integer> bitsMap = IntStream.rangeClosed(0, 16).boxed().collect(Collectors.toMap(
            key -> key, // Key mapper: the number itself (Function.identity())
            value -> Double.valueOf(Math.pow(2, value)).intValue()// Value mapper: the number squared
    ));;

}
