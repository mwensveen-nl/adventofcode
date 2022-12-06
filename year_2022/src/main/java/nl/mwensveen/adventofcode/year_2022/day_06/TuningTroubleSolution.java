package nl.mwensveen.adventofcode.year_2022.day_06;

import nl.mwensveen.adventofcode.year_2022.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2022.FileReadHelper;

public class TuningTroubleSolution extends AbstractTimedSolution {

    private String input;
    private StartOfPacketMarker marker = new StartOfPacketMarker();

    @Override
    protected void init() {
        input = FileReadHelper.readLineAsString("day06.txt");
    }

    @Override
    protected void part1() {
        int position = marker.findMarker(input, 4);
        System.out.println("Number of characters that need to be processed before the first start-of-packet marker with 4 characters is detected: " + position);
    }

    @Override
    protected void part2() {
        int position = marker.findMarker(input, 14);
        System.out.println("Number of characters that need to be processed before the first start-of-packet marker with 14 characters is detected: " + position);
    }

    public static void main(String[] args) {
        new TuningTroubleSolution().run();
    }

}
