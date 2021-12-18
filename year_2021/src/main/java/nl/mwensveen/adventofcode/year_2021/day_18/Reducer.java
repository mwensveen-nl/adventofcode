package nl.mwensveen.adventofcode.year_2021.day_18;

import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.List;

public class Reducer {

    List<String> reduce(List<String> operatorOne) {
        List<String> orig = operatorOne;
        List<String> reduced = orig;
        boolean done = false;
        while (!done) {
            orig = reduced;
            reduced = explode(orig);
            if (reduced.equals(orig)) {
                reduced = split(orig);
            }
            if (reduced.equals(orig)) {
                done = true;
            }
        }
        return reduced;
    }

    private List<String> split(List<String> orig) {
        for (int i = 0; i < orig.size(); i++) {
            if (isLarger9(orig, i)) {
                return performSplit(orig, i);
            }
        }
        return orig;
    }

    private List<String> performSplit(List<String> orig, int i) {
        int value = Integer.parseInt(orig.get(i));
        int first = value / 2;
        int second = value - first;
        List<String> splitted = new ArrayList<>(orig);
        splitted.add(i + 1, "]");
        splitted.add(i + 1, Integer.toString(second));
        splitted.add(i + 1, ",");
        splitted.add(i + 1, Integer.toString(first));
        splitted.set(i, "[");
        return splitted;
    }

    private boolean isLarger9(List<String> orig, int i) {
        Integer n = Ints.tryParse(orig.get(i));
        return n != null && n.intValue() > 9;
    }

    private List<String> explode(List<String> orig) {
        int open = 0;
        for (int i = 0; i < orig.size(); i++) {
            switch (orig.get(i)) {
                case "[":
                    open++;
                    break;
                case "]":
                    open--;
                    break;
                case ",":
                    break;
                default:
                    if (open > 4) {
                        if (isLiteral(orig, i - 1)) {
                            return performExplode(orig, i - 1);
                        }
                    }
                    break;
            }
        }
        return orig;
    }

    private List<String> performExplode(List<String> orig, int i) {
        List<String> exploded = new ArrayList<>(orig);
        boolean found = false;
        for (int j = i - 1; j >= 0 && !found; j--) {
            Integer prevNumber = Ints.tryParse(exploded.get(j));
            if (prevNumber != null) {
                Integer currNumber = Ints.tryParse(exploded.get(i + 1));
                exploded.set(j, Integer.valueOf(currNumber + prevNumber).toString());
                found = true;
            }
        }
        found = false;
        for (int j = i + 6; j < exploded.size() && !found; j++) {
            Integer prevNumber = Ints.tryParse(exploded.get(j));
            if (prevNumber != null) {
                Integer currNumber = Ints.tryParse(exploded.get(i + 3));
                exploded.set(j, Integer.valueOf(currNumber + prevNumber).toString());
                found = true;
            }
        }
        exploded.set(i, "0");
        exploded.remove(i + 4);
        exploded.remove(i + 3);
        exploded.remove(i + 2);
        exploded.remove(i + 1);

        return exploded;
    }

    private boolean isLiteral(List<String> orig, int i) {
        return Ints.tryParse(orig.get(i + 1)) != null && orig.get(i + 2).equals(",") && Ints.tryParse(orig.get(i + 3)) != null && orig.get(i + 4).equals("]");
    }

}
