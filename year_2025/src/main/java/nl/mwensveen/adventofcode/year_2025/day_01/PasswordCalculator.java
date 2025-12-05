package nl.mwensveen.adventofcode.year_2025.day_01;

import java.util.List;
import java.util.stream.IntStream;
import nl.mwensveen.circularcollection.CircularCollection;

public class PasswordCalculator {

    private static final Integer ZERO = Integer.valueOf(0);

    public long calculate(List<Rotation> rotations) {
        CircularCollection<Integer> dail = new CircularCollection(IntStream.range(0, 100).boxed().toList());

        dail.setCurrent(Integer.valueOf(50));
        long pwd = 0L;
        for (Rotation rotation : rotations) {
            Integer nmbr;
            if (Direction.RIGHT.equals(rotation.direction())) {
                nmbr = dail.movePrevious(rotation.count());
            } else {
                nmbr = dail.moveNext(rotation.count());
            }
            if (ZERO.equals(nmbr)) {
                pwd++;
            }
        }
        return pwd;
    }
}
