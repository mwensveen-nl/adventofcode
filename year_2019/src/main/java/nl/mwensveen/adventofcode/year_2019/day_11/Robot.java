package nl.mwensveen.adventofcode.year_2019.day_11;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.math.BigInteger;
import java.util.List;

public class Robot {

    private IntcodeProgram program;
    private Table<Integer, Integer, Color> hull = HashBasedTable.create();

    public Robot(IntcodeProgram program) {
        this.program = program;
    }

    public int emergencyHullPainting(Color startPanelColor) {
        Direction direction = Direction.UP;
        Point p = new Point(0, 0);

        Color panel = hull.get(p.getX(), p.getY());
        List<BigInteger> output = program.process(panel == null ? Color.BLACK.getNumber() : panel.getNumber());

        while (!output.isEmpty()) {
            hull.put(p.getX(), p.getY(), Color.find(output.get(0).intValue()));
            direction = direction.turn(output.get(1).intValue());
            p = direction.step(p);
            panel = hull.get(p.getX(), p.getY());
            output = program.process(panel == null ? Color.BLACK.getNumber() : panel.getNumber());
        }

        return hull.size();
    }

}
