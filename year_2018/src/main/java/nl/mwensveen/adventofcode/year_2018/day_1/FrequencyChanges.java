package nl.mwensveen.adventofcode.year_2018.day_1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class FrequencyChanges {

    public BigInteger calculateResultingFrequency(String changes) {
        return Stream.of(changes.split(",")).map(String::trim).map(BigInteger::new).reduce(BigInteger.ZERO, BigInteger::add);
    }

    public BigInteger findFrequencyReachedTwice(String changes) {
        CalculatedFrequencies calculatedFrequencies = new CalculatedFrequencies();
        Optional<BigInteger> findFirst = Optional.empty();
        while (!findFirst.isPresent()) {
            findFirst =
                    Stream.of(changes.split(",")).sequential().map(String::trim).map(BigInteger::new).filter(i -> calculatedFrequencies.check(i)).findFirst();
        }
        return calculatedFrequencies.result;
    }

    private static class CalculatedFrequencies {
        List<BigInteger> reached = new ArrayList<>();
        BigInteger result = BigInteger.ZERO;

        public CalculatedFrequencies() {
            reached.add(result);
        }

        public boolean check(BigInteger i) {
            result = result.add(i);
            if (reached.contains(result)) {
                return true;
            }
            reached.add(result);
            return false;
        }
    }
}
