package nl.mwensveen.adventofcode.year_2020.day_13;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class BusLeaveCalculator {

    public Integer calculate(int now, List<Integer> busNumbers) {
        Map<Double, Integer> times = busNumbers.stream().collect(Collectors.toMap(bn -> Math.ceil(divide(now, bn)) - divide(now, bn), bn -> bn));
        Optional<Double> min = times.keySet().stream().min(Double::compare);
        Integer bus = times.get(min.get());
        double wait = bus.intValue() * min.get();
        return (int) wait * bus;
    }

    private double divide(int now, Integer bn) {
        return 1.0 * now / bn.intValue();
    }

    // based on: Least Common Multiple: https://www.baeldung.com/java-least-common-multiple
    public long findSchedule(List<BusInterval> bi) {
        long lcm = 0L;
        long increment = bi.get(0).getBusNr();
        for (int i = 1; i < bi.size(); i++) {
            long busNummer = bi.get(i).getBusNr();
            long interval = bi.get(i).getInterval();
            boolean lcmFound = false;
            while (!lcmFound) {
                lcm += increment;
                if ((lcm + interval) % busNummer == 0) {
                    lcmFound = true;
                }
            }
            increment *= busNummer;
        }
        return lcm;
    }

}
