package nl.mwensveen.adventofcode.year_2017.day_10;

public class KnotHashSolution {

    public static void main(String[] args) {
        KnotHash knotHash = new KnotHash("94,84,0,79,2,27,81,1,123,93,218,23,103,255,254,243", 256);
        System.out.println("Part one: " + knotHash.Calculate());
        KnotHashPart2 knotHash2 = new KnotHashPart2("94,84,0,79,2,27,81,1,123,93,218,23,103,255,254,243", 256);
        System.out.println("Part two: " + knotHash2.Calculate());
    }

}
