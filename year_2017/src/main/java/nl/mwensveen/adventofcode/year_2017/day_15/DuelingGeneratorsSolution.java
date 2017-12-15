package nl.mwensveen.adventofcode.year_2017.day_15;

public class DuelingGeneratorsSolution {

    public static void main(String[] args) {
        DuelingGenerators duelingGenerators = new DuelingGenerators(512, 191);
        System.out.println("Part 1: " + duelingGenerators.calculate());
        System.out.println("Part 1: " + duelingGenerators.calculateWithCriteria());
    }

}
