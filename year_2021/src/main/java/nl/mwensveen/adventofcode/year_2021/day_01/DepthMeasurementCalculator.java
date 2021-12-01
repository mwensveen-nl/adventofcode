package nl.mwensveen.adventofcode.year_2021.day_01;

import com.codepoetics.protonpack.StreamUtils;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DepthMeasurementCalculator {

    long calculateNumberOfIncreases(List<Integer> depths) {
        Stream<Integer> stream = depths.stream();
        return StreamUtils.zipWithIndex(stream).map(di -> {
            if (di.getIndex() > 0) {
                return (di.getValue() > depths.get(((int) di.getIndex()) - 1));
            }
            return false;
        }).filter(b -> b).count();
    }

    long calculateNumberOfIncreasesSumMeasurements(List<Integer> depths) {
        List<Integer> summedDepths = StreamUtils.skipWhile(StreamUtils.zipWithIndex(depths.stream()), di -> di.getIndex() < 2)
                .map(di -> di.getValue() + depths.get((int) di.getIndex() - 1) + depths.get((int) di.getIndex() - 2)).collect(Collectors.toList());

        return calculateNumberOfIncreases(summedDepths);
    }
}
