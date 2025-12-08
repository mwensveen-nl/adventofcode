package nl.mwensveen.adventofcode.year_2025.day_08;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class CircuitCalculator {

    public List<? extends Set<Coordinate>> calculate(List<Distance> distances, List<Coordinate> coords, int count) {
        List<? extends Set<Coordinate>> circuits = new ArrayList<>(coords.stream().map(Set::of).map(HashSet::new).toList());

        distances.sort((a, b) -> Double.compare(a.length(), b.length()));

        for (int i = 0; i < count; i++) {
            var d = distances.get(i);
            Optional<? extends Set<Coordinate>> first = circuits.stream().filter(c -> c.contains(d.one())).findFirst();
            Optional<? extends Set<Coordinate>> second = circuits.stream().filter(c -> c.contains(d.two())).findFirst();

            if (!first.get().equals(second.get())) {
                first.get().addAll(second.get());
                circuits.remove(second.get());
            }
        }

        return circuits;
    }

    public BigInteger multiplyLargest(List<? extends Set<Coordinate>> circuits, int count) {
        circuits.sort((a, b) -> -1 * Integer.compare(a.size(), b.size()));
        return circuits.stream().limit(count).map(Set::size).map(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply);
    }

    public Distance calculateAll(List<Distance> distances, List<Coordinate> coords) {
        List<? extends Set<Coordinate>> circuits = new ArrayList<>(coords.stream().map(Set::of).map(HashSet::new).toList());

        distances.sort((a, b) -> Double.compare(a.length(), b.length()));
        Distance last = null;
        var i = 0;
        while (circuits.size() != 1) {
            var d = distances.get(i++);
            last = d;
            Optional<? extends Set<Coordinate>> first = circuits.stream().filter(c -> c.contains(d.one())).findFirst();
            Optional<? extends Set<Coordinate>> second = circuits.stream().filter(c -> c.contains(d.two())).findFirst();

            if (!first.get().equals(second.get())) {
                first.get().addAll(second.get());
                circuits.remove(second.get());
            }
        }

        return last;
    }
}
