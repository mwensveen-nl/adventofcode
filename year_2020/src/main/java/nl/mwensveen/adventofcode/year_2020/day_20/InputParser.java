package nl.mwensveen.adventofcode.year_2020.day_20;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    public List<Image> parse(List<String> input) {
        List<Image> images = new ArrayList<>();
        ImageParser imageParser = new ImageParser();
        List<String> imageString = new ArrayList<>();
        for (String string : input) {
            if (string.isEmpty()) {
                images.add(imageParser.parser(imageString));
                imageString = new ArrayList<>();
            } else {
                imageString.add(string);
            }
        }
        images.add(imageParser.parser(imageString));
        imageString = new ArrayList<>();
        return images;
    }
}
