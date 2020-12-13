package nl.mwensveen.adventofcode.year_2020.day_13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BusLeaveCalculatorTest {

    @Test
    public void testCalculate() throws Exception {
        List<Integer> busses = Arrays.asList(7, 13, 59, 31, 19);
        BusLeaveCalculator busLeaveCalculator = new BusLeaveCalculator();
        Integer result = busLeaveCalculator.calculate(939, busses);
        assertEquals(295, result);
    }

    @Test
    public void testFindSchedule() throws Exception {
        BusLeaveCalculator calculator = new BusLeaveCalculator();
        List<BusInterval> bi = Arrays.asList(
                BusInterval.builder().withBusNr(7).withInterval(0).build(),
                BusInterval.builder().withBusNr(13).withInterval(1).build(),
                BusInterval.builder().withBusNr(59).withInterval(4).build(),
                BusInterval.builder().withBusNr(31).withInterval(6).build(),
                BusInterval.builder().withBusNr(19).withInterval(7).build());
        long lcm = calculator.findSchedule(bi);
        assertEquals(1068781, lcm);
    }

    @Test
    public void testFindSchedule1() throws Exception {
        BusLeaveCalculator calculator = new BusLeaveCalculator();
        // 17,x,13,19
        List<BusInterval> bi = Arrays.asList(
                BusInterval.builder().withBusNr(17).withInterval(0).build(),
                BusInterval.builder().withBusNr(13).withInterval(2).build(),
                BusInterval.builder().withBusNr(19).withInterval(3).build());
        long lcm = calculator.findSchedule(bi);
        assertEquals(3417, lcm);
    }

    @Test
    public void testFindSchedule2() throws Exception {
        BusLeaveCalculator calculator = new BusLeaveCalculator();
        // 67,7,59,61
        List<BusInterval> bi = Arrays.asList(
                BusInterval.builder().withBusNr(67).withInterval(0).build(),
                BusInterval.builder().withBusNr(7).withInterval(1).build(),
                BusInterval.builder().withBusNr(59).withInterval(2).build(),
                BusInterval.builder().withBusNr(61).withInterval(3).build());
        long lcm = calculator.findSchedule(bi);
        assertEquals(754018, lcm);
    }

    @Test
    public void testFindSchedule3() throws Exception {
        BusLeaveCalculator calculator = new BusLeaveCalculator();
        // 67,7,x,59,61
        List<BusInterval> bi = Arrays.asList(
                BusInterval.builder().withBusNr(67).withInterval(0).build(),
                BusInterval.builder().withBusNr(7).withInterval(1).build(),
                BusInterval.builder().withBusNr(59).withInterval(3).build(),
                BusInterval.builder().withBusNr(61).withInterval(4).build());
        long lcm = calculator.findSchedule(bi);
        assertEquals(1261476, lcm);
    }

    @Test
    public void testFindSchedule4() throws Exception {
        BusLeaveCalculator calculator = new BusLeaveCalculator();
        // 1789,37,47,1889
        List<BusInterval> bi = Arrays.asList(
                BusInterval.builder().withBusNr(1789).withInterval(0).build(),
                BusInterval.builder().withBusNr(37).withInterval(1).build(),
                BusInterval.builder().withBusNr(47).withInterval(2).build(),
                BusInterval.builder().withBusNr(1889).withInterval(3).build());
        long lcm = calculator.findSchedule(bi);
        assertEquals(1202161486, lcm);
    }

}
