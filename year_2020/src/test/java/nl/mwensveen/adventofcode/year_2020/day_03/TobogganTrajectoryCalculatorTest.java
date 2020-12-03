package nl.mwensveen.adventofcode.year_2020.day_03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TobogganTrajectoryCalculatorTest {

    @Test
    public void testCountNumberOfTrees() throws Exception {
        List<String> input = Arrays.asList("..##.......", "#...#...#..", ".#....#..#.", "..#.#...#.#", ".#...##..#.", "..#.##.....", ".#.#.#....#",
                ".#........#", "#.##...#...", "#...##....#", ".#..#...#.#");
        TobogganTrajectoryCalculator calculator = new TobogganTrajectoryCalculator(input);
        assertEquals(7, calculator.countNumberOfTrees(3, 1));
    }

    @Test
    public void testCountNumberOfTreesWithMultiplying() throws Exception {
        List<String> input = Arrays.asList("..##.......", "#...#...#..", ".#....#..#.", "..#.#...#.#", ".#...##..#.", "..#.##.....", ".#.#.#....#",
                ".#........#", "#.##...#...", "#...##....#", ".#..#...#.#");
        TobogganTrajectoryCalculator calculator = new TobogganTrajectoryCalculator(input);

        long numberOfTrees1 = calculator.countNumberOfTrees(1, 1);
        long numberOfTrees2 = calculator.countNumberOfTrees(3, 1);
        long numberOfTrees3 = calculator.countNumberOfTrees(5, 1);
        long numberOfTrees4 = calculator.countNumberOfTrees(7, 1);
        long numberOfTrees5 = calculator.countNumberOfTrees(1, 2);

        assertEquals(336, numberOfTrees1 * numberOfTrees2 * numberOfTrees3 * numberOfTrees4 * numberOfTrees5);
    }

}
