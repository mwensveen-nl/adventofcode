package nl.mwensveen.adventofcode.year_2020.day_06;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AnswerCalculator {

    public int numberOfAnyoneAnswers(List<String> input) {
        Set<Character> uniqueAnswers = new HashSet<>();
        input.forEach(answers -> answers.chars().forEach(i -> uniqueAnswers.add(Character.valueOf((char) i))));
        return uniqueAnswers.size();
    }

    public int numberOfEveryoneAnswers(List<String> input) {
        List<List<Integer>> intersection = new ArrayList<>();
        intersection.add(convertToIntegers(input.get(0)));
        for (String string : input) {
            intersection.set(0, convertToIntegers(string).stream().filter(i -> inIntersection(i, intersection.get(0))).collect(Collectors.toList()));
        }
        return intersection.get(0).size();
    }

    private boolean inIntersection(Integer i, List<Integer> intersection) {
        return intersection.contains(i);
    }

    private List<Integer> convertToIntegers(String string) {
        return string.chars().mapToObj(Integer::valueOf).collect(Collectors.toList());
    }
}
