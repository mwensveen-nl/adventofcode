package nl.mwensveen.adventofcode.year_2024.day_03;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MultiplyParser {

    private static final Pattern MULTIPLY_PATTERN = Pattern.compile("(mul\\(\\d{1,3},\\d{1,3}\\))");
    private static final Pattern MULTIPLY_DODONT_PATTERN = Pattern.compile("(mul\\(\\d{1,3},\\d{1,3}\\)|do\\(\\)|don't\\(\\))");
    private static final Pattern NUMBER_PATTERN = Pattern.compile("(\\d{1,3})");

    public List<Mutiply> parseProgram(String input) {
        List<Mutiply> result = new ArrayList<>();
        Matcher m = MULTIPLY_PATTERN.matcher(input);
        while (m.find()) {
            String s = m.group();
            Matcher n = NUMBER_PATTERN.matcher(s);
            n.find();
            int one = Integer.parseInt(n.group());
            n.find();
            int two = Integer.parseInt(n.group());
            result.add(new Mutiply(one, two));
        }
        return result;
    }

    public List<Mutiply> parseProgramDoDont(String input) {
        System.out.println(input);
        List<Mutiply> result = new ArrayList<>();
        Matcher m = MULTIPLY_DODONT_PATTERN.matcher(input);
        boolean enable = true;
        while (m.find()) {
            String s = m.group();
            if (s.equals("do()")) {
                enable = true;
            } else if (s.equals("don't()")) {
                enable = false;
            } else if (enable) {
                Matcher n = NUMBER_PATTERN.matcher(s);
                n.find();
                int one = Integer.parseInt(n.group());
                n.find();
                int two = Integer.parseInt(n.group());
                result.add(new Mutiply(one, two));
            }
        }
        return result;
    }
}
