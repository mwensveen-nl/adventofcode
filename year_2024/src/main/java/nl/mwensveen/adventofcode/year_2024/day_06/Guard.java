package nl.mwensveen.adventofcode.year_2024.day_06;

import java.util.Arrays;
import java.util.List;

public class Guard {

    private int r;
    private int c;

    private List<Integer> modifiers = Arrays.asList(Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0));

    private int rModifier = 0;
    private int cModifier = 1;

    public Guard(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public void turnRight() {
        rModifier++;
        if (rModifier > 3) {
            rModifier = 0;
        }
        cModifier++;
        if (cModifier > 3) {
            cModifier = 0;
        }
    }

    public List<Integer> inspect() {
        return Arrays.asList(r + modifiers.get(rModifier), c + modifiers.get(cModifier));
    }

    public List<Integer> step() {
        List<Integer> rc = Arrays.asList(r + modifiers.get(rModifier), c + modifiers.get(cModifier));
        r = rc.getFirst();
        c = rc.getLast();
        return rc;
    }

}
