package nl.mwensveen.adventofcode.year_2019.day_04;

import nl.mwensveen.adventofcode.year_2019.AbstractTimedSolution;

public class PasswordHackerSolution extends AbstractTimedSolution {
    private static int RANGE_LOW = 171309;
    private static int RANGE_HIGH = 643603;

    public static void main(String[] args) {
        PasswordHackerSolution solution = new PasswordHackerSolution();
        solution.run();
    }

    @Override
    protected void part1() {
        int count = 0;
        for (int i = RANGE_LOW; i < RANGE_HIGH + 1; i++) {
            count += PasswordChecker.check(i) ? 1 : 0;
        }
        System.out.println("Number of correct passwords between " + RANGE_LOW + " and " + RANGE_HIGH + " = " + count);
    }

    @Override
    protected void part2() {
        int count = 0;
        for (int i = RANGE_LOW; i < RANGE_HIGH + 1; i++) {
            count += PasswordChecker.checkWithoutLongGroup(i) ? 1 : 0;
        }
        System.out.println("Number of correct passwords with larger group check between " + RANGE_LOW + " and " + RANGE_HIGH + " = " + count);
    }

}
