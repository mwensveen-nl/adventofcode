package nl.mwensveen.adventofcode.year_2017.day_3;

public class SpiralMemorySolution {

    public static void main(String[] args) {
        SpiralMemory spiralMemory = new SpiralMemory(277678);
        System.out.println("part 1: " + spiralMemory.calculate());
        SpiralMemorySumAdjacentSquares spiralMemorySumAdjacentSquares = new SpiralMemorySumAdjacentSquares(277678);
        System.out.println("part 2: " + spiralMemorySumAdjacentSquares.calculate());
    }

}
