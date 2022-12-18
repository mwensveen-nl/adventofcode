package nl.mwensveen.adventofcode.year_2022.day_15;

import java.math.BigInteger;
import java.util.List;
import nl.mwensveen.adventofcode.year_2022.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2022.FileReadHelper;

public class BeaconExclusionZoneSolution extends AbstractTimedSolution {

    private List<String> input;
    private List<Sensor> sensors;
    private SensorReportInspector inspector = new SensorReportInspector();

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("day15.txt");
        SensorParser parser = new SensorParser();
        sensors = parser.parse(input);

    }

    @Override
    protected void part1() {
        long emptyPositions = inspector.findEmptyPositions(sensors, 2000000);
        System.out.println("In the row where y=2000000, the number of positions that cannot contain a beacon: " + emptyPositions);
    }

    @Override
    protected void part2() {
        BigInteger frequency = inspector.findBeacon(sensors, 4000000);
        System.out.println("The tuning frequency of the only possible position for the distress beacon: " + frequency.toString());
    }

    public static void main(String[] args) {
        new BeaconExclusionZoneSolution().run();
    }
}
