package nl.mwensveen.adventofcode.year_2018.day_11;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class FuelCellGridAnalyserTest {

    @Test
    public void testAnalyse3x3WithGridSerialNumber18() throws Exception {
        LocalDateTime start = LocalDateTime.now();
        FuelCellGridAnalyser fuelCellGridAnalyser = new FuelCellGridAnalyser(18);

        List<Integer> result = fuelCellGridAnalyser.analyse3x3();
        Assert.assertEquals(Integer.valueOf(33), result.get(0));
        Assert.assertEquals(Integer.valueOf(45), result.get(1));
        Assert.assertEquals(Integer.valueOf(29), result.get(2));
        System.out.println(Duration.between(start, LocalDateTime.now()).toString());
    }

    @Test
    public void testAnalyse3x3WithGridSerialNumber42() throws Exception {
        FuelCellGridAnalyser fuelCellGridAnalyser = new FuelCellGridAnalyser(42);

        List<Integer> result = fuelCellGridAnalyser.analyse3x3();
        Assert.assertEquals(Integer.valueOf(21), result.get(0));
        Assert.assertEquals(Integer.valueOf(61), result.get(1));
        Assert.assertEquals(Integer.valueOf(30), result.get(2));
    }

    @Test
    public void testAnalyseAnySizeWithGridSerialNumber18() throws Exception {
        FuelCellGridAnalyser fuelCellGridAnalyser = new FuelCellGridAnalyser(18);

        List<Integer> result = fuelCellGridAnalyser.analyseAnySize();
        Assert.assertEquals(Integer.valueOf(90), result.get(0));
        Assert.assertEquals(Integer.valueOf(269), result.get(1));
        Assert.assertEquals(Integer.valueOf(16), result.get(2));
        Assert.assertEquals(Integer.valueOf(113), result.get(3));
    }

    @Test
    public void testAnalyseAnySizeWithGridSerialNumber42() throws Exception {
        FuelCellGridAnalyser fuelCellGridAnalyser = new FuelCellGridAnalyser(42);

        List<Integer> result = fuelCellGridAnalyser.analyseAnySize();
        Assert.assertEquals(Integer.valueOf(232), result.get(0));
        Assert.assertEquals(Integer.valueOf(251), result.get(1));
        Assert.assertEquals(Integer.valueOf(12), result.get(2));
        Assert.assertEquals(Integer.valueOf(119), result.get(3));
    }

}
