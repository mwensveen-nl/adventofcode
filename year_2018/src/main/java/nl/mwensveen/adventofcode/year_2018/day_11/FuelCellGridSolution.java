package nl.mwensveen.adventofcode.year_2018.day_11;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class FuelCellGridSolution {
    public static void main(String[] args) {
        FuelCellGridAnalyser fuelCellGridAnalyser = new FuelCellGridAnalyser(3628);

        LocalDateTime start = LocalDateTime.now();
        List<Integer> result = fuelCellGridAnalyser.analyse3x3();
        System.out.println(String.format("top-left of square = %d - %d has max power (%d)", result.get(0), result.get(1), result.get(2)));
        System.out.println(Duration.between(start, LocalDateTime.now()).toString());

        start = LocalDateTime.now();
        result = fuelCellGridAnalyser.analyseAnySize();
        System.out.println(result);
        System.out.println(
                String.format("top-left of square = %d - %d with size %d  has max power (%d)", result.get(0), result.get(1), result.get(2), result.get(3)));
        System.out.println(Duration.between(start, LocalDateTime.now()).toString());
    }
}
