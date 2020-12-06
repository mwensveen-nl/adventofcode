package nl.mwensveen.adventofcode.year_2020.day_06;

import java.util.List;
import nl.mwensveen.adventofcode.year_2020.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2020.FileReadHelper;

public class CustomCustomsSolution extends AbstractTimedSolution {
    private AnswerProcessor answerProcessor = new AnswerProcessor();
    private List<List<String>> groupAnswers;

    public static void main(String[] args) {
        CustomCustomsSolution solution = new CustomCustomsSolution();
        solution.run();
    }

    public CustomCustomsSolution() {
        List<String> input = FileReadHelper.readLinesAsStrings("Day_06.txt");
        groupAnswers = answerProcessor.groupAnswers(input);
    }

    @Override
    protected void part1() {
        long result = answerProcessor.totalAnyone(groupAnswers);
        System.out.println("Sum of answers ANYone= " + result);
    }

    @Override
    protected void part2() {
        long result = answerProcessor.totalEveryone(groupAnswers);
        System.out.println("Sum of answers EVERYone= " + result);
    }

}
