package nl.mwensveen.adventofcode.year_2020.day_05;

import java.util.List;
import nl.mwensveen.adventofcode.year_2020.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2020.FileReadHelper;

public class BinaryBoardingSolution extends AbstractTimedSolution {

    private List<String> input;
    private int findHighestSeatId;
    private SeatIDProcessor seatIDProcessor = new SeatIDProcessor();

    public static void main(String[] args) {
        BinaryBoardingSolution solution = new BinaryBoardingSolution();
        solution.run();
    }

    public BinaryBoardingSolution() {
        input = FileReadHelper.readLinesAsStrings("Day_05.txt");
    }

    @Override
    protected void part1() {
        findHighestSeatId = seatIDProcessor.findHighestSeatId(input);
        System.out.println(" sanity check. Highest seat ID on a boarding pass = " + findHighestSeatId);
    }

    @Override
    protected void part2() {
        int mySeatId = seatIDProcessor.findMySeatId(input, findHighestSeatId);
        System.out.println("My seat id = " + mySeatId);
    }

}
