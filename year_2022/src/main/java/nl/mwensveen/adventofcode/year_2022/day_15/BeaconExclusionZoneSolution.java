package nl.mwensveen.adventofcode.year_2022.day_15;

import java.util.List;
import nl.mwensveen.adventofcode.year_2022.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2022.FileReadHelper;

public class BeaconExclusionZoneSolution extends AbstractTimedSolution {

    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("day15.txt");

    }

    @Override
    protected void part1() {
        SensorParser parser = new SensorParser();
        List<Sensor> sensors = parser.parse(input);
        SensorReportInspector inspector = new SensorReportInspector();
        long emptyPositions = inspector.findEmptyPositions(sensors, 2000000);
        System.out.println("In the row where y=2000000, the number of positions that cannot contain a beacon: " + emptyPositions);

    }

    @Override
    protected void part2() {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        new BeaconExclusionZoneSolution().run();
    }
}
