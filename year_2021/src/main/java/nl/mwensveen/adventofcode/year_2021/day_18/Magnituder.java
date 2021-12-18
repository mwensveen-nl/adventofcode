package nl.mwensveen.adventofcode.year_2021.day_18;

import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.List;

public class Magnituder {

    public String calculateMagnitude(List<String> orig) {
        List<String> magn = new ArrayList<>(orig);

        while (magn.contains("[")) {
            for (int i = 0; i < magn.size(); i++) {
                if (isLiteral(magn, i)) {
                    magn = performCalc(magn, i);
                    break;
                }
            }
        }
        return magn.get(0);
    }

    private List<String> performCalc(List<String> magn, int i) {
        long first = Long.parseLong(magn.get(i + 1));
        long second = Long.parseLong(magn.get(i + 3));
        long magnitue = first * 3 + second * 2;
        magn.remove(i + 4);
        magn.remove(i + 3);
        magn.remove(i + 2);
        magn.remove(i + 1);
        magn.set(i, Long.toString(magnitue));
        return magn;
    }

    private boolean isLiteral(List<String> orig, int i) {
        return Ints.tryParse(orig.get(i + 1)) != null && orig.get(i + 2).equals(",") && Ints.tryParse(orig.get(i + 3)) != null && orig.get(i + 4).equals("]");
    }
}
