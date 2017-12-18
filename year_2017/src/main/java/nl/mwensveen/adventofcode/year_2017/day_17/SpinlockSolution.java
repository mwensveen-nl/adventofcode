package nl.mwensveen.adventofcode.year_2017.day_17;

public class SpinlockSolution {

    public static void main(String[] args) {
        Spinlock spinlock = new Spinlock("371");
        System.out.println("Part 1: " + spinlock.calculate(2017));
        System.out.println("Part 2: " + spinlock.calculateAfterZero(50000000));
    }

}
