package nl.mwensveen.adventofcode.year_2017.day_14;

public class DiskDefragmentationSolution {

    public static void main(String[] args) {
        DiskDefragmentation diskDefragmentation = new DiskDefragmentation("hfdlxzhv");
        System.out.println("Part 1: " + diskDefragmentation.calculate());
        System.out.println("Part 2: " + diskDefragmentation.calculateGroups());
    }

}
