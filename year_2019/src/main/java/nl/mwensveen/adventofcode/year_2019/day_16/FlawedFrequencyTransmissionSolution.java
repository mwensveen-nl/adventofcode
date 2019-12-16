package nl.mwensveen.adventofcode.year_2019.day_16;

import java.util.ArrayList;
import java.util.List;
import nl.mwensveen.adventofcode.year_2019.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2019.FileReadHelper;

public class FlawedFrequencyTransmissionSolution extends AbstractTimedSolution {

    @Override
    protected void part1() {
        PhaseApplier phaseApplier = new PhaseApplier(100);
        List<Integer> output = phaseApplier.applyPhases(FileReadHelper.readStringAsIntegers("Day16.txt"));
        MessageRetreiver messageRetreiver = new MessageRetreiver();
        String message = messageRetreiver.retrieve(null, 0, output);
        System.out.println("First 8 digits after 100 phases " + message);
    }

    @Override
    protected void part2() {
        List<Integer> input = FileReadHelper.readStringAsIntegers("Day16.txt");
        List<Integer> inputRepeated = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            inputRepeated.addAll(input);
        }
        PhaseApplier phaseApplier = new PhaseApplier(100);
        List<Integer> output = phaseApplier.applyPhases(inputRepeated);
        MessageRetreiver messageRetreiver = new MessageRetreiver();
        String message = messageRetreiver.retrieve(input, 7, output);
        System.out.print("Message of 8 digits when applying offset " + message);
    }

    public static void main(String[] args) {
        FlawedFrequencyTransmissionSolution solution = new FlawedFrequencyTransmissionSolution();
        solution.run();
    }

}
