package nl.mwensveen.adventofcode.year_2018.day_11;

public class PowerCalculator {

    private PowerCalculator() {
    }

    public static int calculate(int x, int y, int serialNumber) {
        int rackid = x + 10;
        int power = rackid * y;
        power = power + serialNumber;
        power = power * rackid;
        String ps = Integer.toString(power);
        if (ps.length() < 3) {
            return 0;
        }

        int hundred = Integer.valueOf(String.valueOf(ps.charAt(ps.length() - 3)));
        return hundred - 5;
    }
}
