package nl.mwensveen.adventofcode.year_2018.day_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ExactlyOneCharDiffFinder {
    private List<String> input;

    public ExactlyOneCharDiffFinder(List<String> input) {
        this.input = input;
    }

    public String find() {
        List<BoxAnalyser> all = input.stream().map(BoxAnalyser::new).collect(Collectors.toList());
        List<BoxAnalyser> checked = new ArrayList<>();

        for (BoxAnalyser boxAnalyser : all) {
            for (BoxAnalyser boxAnalyser2 : checked) {
                Optional<String> difference = boxAnalyser.compareOneCharDifference(boxAnalyser2);
                if (difference.isPresent()) {
                    return difference.get();
                }
            }
            checked.add(boxAnalyser);
        }
        return null;
    }
}
