package nl.mwensveen.adventofcode.year_2021.day_04;

import com.google.common.collect.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputParser {

    List<Integer> parseFirstRow(String input) {
        return Stream.of(input.split(",")).map(s -> Integer.parseInt(s)).collect(Collectors.toList());
    }

    List<Table<Long, Long, Integer>> parseOtherInput(List<String> input) {
        BingoBoardParser bingoBoardParser = new BingoBoardParser();

        List<Table<Long, Long, Integer>> boards = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        for (String string : input) {
            if (string.isEmpty()) {
                if (!strings.isEmpty()) {
                    boards.add(bingoBoardParser.parseBoard(strings));
                    strings = new ArrayList<>();
                }
            } else {
                strings.add(string);
            }
        }
        if (!strings.isEmpty())

        {
            boards.add(bingoBoardParser.parseBoard(strings));
        }
        return boards;
    }
}