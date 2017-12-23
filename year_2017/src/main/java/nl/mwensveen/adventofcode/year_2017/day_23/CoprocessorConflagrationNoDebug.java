package nl.mwensveen.adventofcode.year_2017.day_23;

public class CoprocessorConflagrationNoDebug {

    public int calculate() {
        int h = 0;
        for (int b = 109300; b <= 126300; b += 17) {
            boolean addedH = false;
            for (int d = 2; d <= b / 2 && !addedH; d++) {
                for (int e = 2; e <= b / d && !addedH; e++) {
                    if (d * e == b) {
                        h = h + 1;
                        addedH = true;
                    }
                }
            }
        }
        return h;
    }
}
