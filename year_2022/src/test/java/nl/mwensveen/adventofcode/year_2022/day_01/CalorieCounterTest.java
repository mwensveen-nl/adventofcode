package nl.mwensveen.adventofcode.year_2022.day_01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalorieCounterTest {
    String input = """
            1000
            2000
            3000

            4000

            5000
            6000

            7000
            8000
            9000

            10000
            """;

    @Test
    public void testCountMostCalories() {
        CalorieCounter calorieCounter = new CalorieCounter();
        Long mostCalories = calorieCounter.countMostCalories(input.lines().toList());
        assertEquals(24000, mostCalories);
    }

    @Test
    public void testCountThreeMostCalories() {
        CalorieCounter calorieCounter = new CalorieCounter();
        Long sumCalories = calorieCounter.countThreeMostCalories(input.lines().toList());
        assertEquals(45000, sumCalories);
    }

}
