package nl.mwensveen.adventofcode.year_2020.day_06;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AnswerProcessor {
    AnswerCalculator answerCalculator = new AnswerCalculator();

    public List<List<String>> groupAnswers(List<String> input) {
        List<List<String>> answerGroups = new ArrayList<>();
        List<String> answers = newAnswers(answerGroups);
        for (String row : input) {
            if (row.isEmpty()) {
                answers = newAnswers(answerGroups);
            } else {
                answers.add(row);
            }
        }
        return answerGroups;
    }

    private List<String> newAnswers(List<List<String>> answerGroups) {
        List<String> answers = new ArrayList<>();
        answerGroups.add(answers);
        return answers;
    }

    public long totalAnyone(List<List<String>> input) {
        return input.stream().map(answers -> Integer.valueOf(answerCalculator.numberOfAnyoneAnswers(answers)))
                .collect(Collectors.summingInt(Integer::intValue));
    }

    public long totalEveryone(List<List<String>> input) {
        return input.stream().map(answers -> Integer.valueOf(answerCalculator.numberOfEveryoneAnswers(answers)))
                .collect(Collectors.summingInt(Integer::intValue));
    }
}
