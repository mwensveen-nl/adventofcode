package nl.mwensveen.adventofcode.year_2021.day_22;

import java.util.List;
import nl.mwensveen.adventofcode.year_2021.day_22.Step.Builder;

public class RebootStepParser {

    List<Step> parse(List<String> input) {
        return input.stream().map(s -> parseStep(s)).toList();
    }

    private Step parseStep(String s) {
        String[] split = s.split(" ");
        Builder builder = Step.builder();
        builder.withOnOff(split[0].trim());
        split = split[1].split(",");

        String[] step = splitStartEnd(split[0]);
        builder.withStartX(Integer.valueOf(step[0]));
        builder.withEndX(Integer.valueOf(step[1]));

        step = splitStartEnd(split[1]);
        builder.withStartY(Integer.valueOf(step[0]));
        builder.withEndY(Integer.valueOf(step[1]));

        step = splitStartEnd(split[2]);
        builder.withStartZ(Integer.valueOf(step[0]));
        builder.withEndZ(Integer.valueOf(step[1]));

        return builder.build();
    }

    private String[] splitStartEnd(String x) {
        String[] split = x.split("=");
        return split[1].split("\\.\\.");
    }
}
