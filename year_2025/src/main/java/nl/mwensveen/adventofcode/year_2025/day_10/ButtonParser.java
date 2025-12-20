package nl.mwensveen.adventofcode.year_2025.day_10;

import java.util.List;
import java.util.stream.Stream;

public class ButtonParser {

    List<Button> parse(String input) {
        return Stream.of(input.split(" "))
                .map(String::trim)
                .map(s -> s.substring(1, s.length() - 1))
                .map(Button::new)
                .toList();
    }
}
