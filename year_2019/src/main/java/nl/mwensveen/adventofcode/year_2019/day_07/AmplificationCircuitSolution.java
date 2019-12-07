package nl.mwensveen.adventofcode.year_2019.day_07;

import java.util.Arrays;
import java.util.List;
import nl.mwensveen.adventofcode.year_2019.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2019.FileReadHelper;

public class AmplificationCircuitSolution extends AbstractTimedSolution {

    public static void main(String[] args) {
        AmplificationCircuitSolution solution = new AmplificationCircuitSolution();
        solution.run();
    }

    @Override
    protected void part1() {
        final int MIN = 0;
        final int MAX = 4;
        int maxThrusterInput = Integer.MIN_VALUE;
        for (int a = MIN; a <= MAX; a++) {
            for (int b = MIN; b <= MAX; b++) {
                for (int c = MIN; c <= MAX; c++) {
                    for (int d = MIN; d <= MAX; d++) {
                        for (int e = MIN; e <= MAX; e++) {
                            if (b != a && c != a & c != b && d != a && d != b && d != c && e != a && e != b && e != c && e != d) {
                                List<Integer> input = FileReadHelper.readCSVIntegers("Day07.txt");
                                AmplifierSeries amplifierSeries = new AmplifierSeries(Arrays.asList(a, b, c, d, e), 0, input);
                                int thrusterInput = amplifierSeries.caluclateThrusterInput();
                                maxThrusterInput = Math.max(maxThrusterInput, thrusterInput);
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Max thrusterinput part 1= " + maxThrusterInput);
    }

    @Override
    protected void part2() {
        int maxThrusterInput = Integer.MIN_VALUE;
        final int MIN = 5;
        final int MAX = 9;
        for (int a = MIN; a <= MAX; a++) {
            for (int b = MIN; b <= MAX; b++) {
                for (int c = MIN; c <= MAX; c++) {
                    for (int d = MIN; d <= MAX; d++) {
                        for (int e = MIN; e <= MAX; e++) {
                            if (b != a && c != a & c != b && d != a && d != b && d != c && e != a && e != b && e != c && e != d) {
                                List<Integer> input = FileReadHelper.readCSVIntegers("Day07.txt");
                                AmplifierSeries amplifierSeries = new AmplifierSeries(Arrays.asList(a, b, c, d, e), 0, input);
                                int thrusterInput = amplifierSeries.caluclateThrusterInputWithFeedback();
                                maxThrusterInput = Math.max(maxThrusterInput, thrusterInput);
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Max thrusterinput part 2= " + maxThrusterInput);
    }

}
