package nl.mwensveen.adventofcode.year_2018.day_6;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class ManhathanDistanceCalculatorTest {

    @Test
    public void testCalculateLargestArea() throws Exception {
        List<String> input = Arrays.asList("1, 1", "1, 6", "8, 3", "3, 4", "5, 5", "8, 9");
        ManhathanDistanceCalculator calculator = new ManhathanDistanceCalculator(input);
        Assert.assertEquals(17, calculator.calculateLargestArea());
    }

    @Test
    public void testCalculateRegion() throws Exception {
        List<String> input = Arrays.asList("1, 1", "1, 6", "8, 3", "3, 4", "5, 5", "8, 9");
        ManhathanDistanceCalculator calculator = new ManhathanDistanceCalculator(input);
        Assert.assertEquals(16, calculator.calculateRegion(32));
    }

    @Test
    public void testCalculateAreaAndRegion() throws Exception {
        List<String> input = Arrays.asList("1, 1", "1, 6", "8, 3", "3, 4", "5, 5", "8, 9");
        ManhathanDistanceCalculator calculator = new ManhathanDistanceCalculator(input);
        Assert.assertEquals(17, calculator.calculateLargestArea());
        Assert.assertEquals(16, calculator.calculateRegion(32));
    }

}
