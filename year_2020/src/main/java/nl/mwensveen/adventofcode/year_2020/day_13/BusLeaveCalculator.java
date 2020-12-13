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

    // based on: Least Common Multiple
    public long findSchedule(List<BusInterval> bi) {
        long time = 0L;
        long increment = bi.get(0).getBusNr();
        for (int i = 1; i < bi.size(); i++) {
            long busNummer1 = bi.get(i).getBusNr();
            long interval1 = bi.get(i).getInterval();
            boolean search = true;
            while (search) {
                time += increment;
                if ((time + interval1) % busNummer1 == 0) {
                    increment *= busNummer1;
                    search = false;
                }
            }
        }
        return time;

    }

}
