package nl.mwensveen.adventofcode.year_2019.day_17;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VacuumRobotMover {
    private final IntcodeProgram intcodeProgram;

    public VacuumRobotMover(IntcodeProgram intcodeProgram) {
        this.intcodeProgram = intcodeProgram;
    }

    public BigInteger visitScaffolds() {

        List<Integer> a = Arrays.asList(ascii('L'), ascii(','), ascii('5'), ascii(','), ascii('5'), ascii(','), ascii('R'), ascii(','), ascii('8'), ascii(','),
                ascii('R'), ascii(','), ascii('6'), ascii(','), ascii('R'), ascii(','), ascii('5'), ascii(','), ascii('5'), ascii('\n'));
        List<Integer> b = Arrays.asList(ascii('L'), ascii(','), ascii('6'), ascii(','), ascii('6'), ascii(','), ascii('R'), ascii(','), ascii('8'), ascii(','),
                ascii('L'), ascii(','), ascii('6'), ascii(','), ascii('6'), ascii('\n'));
        List<Integer> c = Arrays.asList(ascii('L'), ascii(','), ascii('5'), ascii(','), ascii('5'), ascii(','), ascii('R'), ascii(','), ascii('8'), ascii(','),
                ascii('R'), ascii(','), ascii('8'), ascii('\n'));

        List<Integer> routine = Arrays.asList(ascii('A'), ascii(','), ascii('B'), ascii(','), ascii('A'), ascii(','), ascii('B'), ascii(','), ascii('C'),
                ascii(','), ascii('C'), ascii(','), ascii('B'), ascii(','), ascii('A'), ascii(','), ascii('C'), ascii(','), ascii('A'), ascii('\n'));

        List<Integer> videoFeed = Arrays.asList(ascii('n'), ascii('\n'));

        List<Integer> input = new ArrayList<>();
        input.addAll(routine);
        input.addAll(a);
        input.addAll(b);
        input.addAll(c);
        input.addAll(videoFeed);

        List<BigInteger> result = intcodeProgram.process(0, input);

        return result.get(result.size() - 1);

    }

    private Integer ascii(char c) {
        return Integer.valueOf(c);
    }
}
