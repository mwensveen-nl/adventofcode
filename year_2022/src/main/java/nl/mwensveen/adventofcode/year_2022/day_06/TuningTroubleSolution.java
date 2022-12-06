package nl.mwensveen.adventofcode.year_2022.day_06;

import nl.mwensveen.adventofcode.year_2022.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2022.FileReadHelper;

public class TuningTroubleSolution extends AbstractTimedSolution {

    private String input;

    @Override
    protected void init() {
        input = FileReadHelper.readLineAsString("day06.txt");
    }

    @Override
    protected void part1() {
        StartOfPacketMarker marker = new StartOfPacketMarker();
        int position = marker.findMarker(input);
        System.out.println("Number of characters that need to be processed before the first start-of-packet marker is detected: " + position);

    }

    @Override
    protected void part2() {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        new TuningTroubleSolution().run();
    }

}
