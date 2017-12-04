package nl.mwensveen.adventofcode.year_2017.day_3;

public class SpiralMemory {

    private int number;

    public SpiralMemory(int number) {
        this.number = number;
    }

    public int calculate() {
        int son = determineSignificantOddNumber(number);

        for (int i = 1; i <= 4; i++) {
            int corner = calcCorner(i, son);
            int prevCorner = calcCorner(i - 1, son);
            if (number >= corner && number < prevCorner) {
                if (number - corner < prevCorner - number) {
                    return son - 1 - (number - corner);
                } else {
                    return son - 1 - (prevCorner - number);
                }
            }
        }
        return 0;
    }

    private int calcCorner(int i, int son) {
        return son * son - i * son + i;

    }

    private int determineSignificantOddNumber(int n) {
        if (n == 1) {
            return 1;
        }
        int son = 0;
        for (int i = 1; Math.pow(i, 2) < n; i = i + 2) {
            son = i;
        }
        return son + 2;
    }
}
