package nl.mwensveen.adventofcode.year_2020.day_12;

import java.util.List;
import nl.mwensveen.adventofcode.year_2020.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2020.FileReadHelper;

public class RainRiskSolution extends AbstractTimedSolution {

    private List<Instruction> input;

    @Override
    protected void init() {
        List<String> inputStrings = FileReadHelper.readLinesAsStrings("Day_12.txt");
        InstructionParser parser = new InstructionParser();
        input = parser.parseInstructions(inputStrings);
    }

    @Override
    protected void part1() {
        ShipMover mover = new ShipMover();
        Position position = mover.moveShip(input);
        ManhattanDistanceCalculator calculator = new ManhattanDistanceCalculator();
        long result = calculator.calculate(0, 0, position.getNorthSouth(), position.getWestEast());
        System.out.println("The Manhattan distance between the location and the ship's starting position = " + result);
    }

    @Override
    protected void part2() {
        ShipMover mover = new ShipMover();
        Position position = mover.moveShipAndWaypoint(input, 10, 1);
        ManhattanDistanceCalculator calculator = new ManhattanDistanceCalculator();
        long result = calculator.calculate(0, 0, position.getNorthSouth(), position.getWestEast());
        System.out.println("The Manhattan distance between the location and the ship's starting position = " + result);
    }

    public static void main(String[] args) {
        new RainRiskSolution().run();
    }

}
