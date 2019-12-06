package nl.mwensveen.adventofcode.year_2019.day_06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class OrbitCountChecksumCalculatorTest {

    @Test
    public void testCalculateCheckSumOneSatellite() throws Exception {
        OrbitCountChecksumCalculator calculator = new OrbitCountChecksumCalculator();
        int count = calculator.calculateCheckSum(Arrays.asList("COM)B"));
        assertEquals(1, count);
    }

    @Test
    public void testCalculateCheckSumTwoSatellite() throws Exception {
        OrbitCountChecksumCalculator calculator = new OrbitCountChecksumCalculator();
        int count = calculator.calculateCheckSum(Arrays.asList("COM)B", "B)C"));
        assertEquals(3, count);
    }

    @Test
    public void testCalculateCheckSumThreeSatellite() throws Exception {
        OrbitCountChecksumCalculator calculator = new OrbitCountChecksumCalculator();
        int count = calculator.calculateCheckSum(Arrays.asList("COM)B", "B)C", "B)D"));
        assertEquals(5, count);
    }

    @Test
    public void testCalculateCheckSumFourSatellite() throws Exception {
        OrbitCountChecksumCalculator calculator = new OrbitCountChecksumCalculator();
        int count = calculator.calculateCheckSum(Arrays.asList("COM)B", "B)C", "B)D", "C)E"));
        assertEquals(8, count);
    }

    @Test
    public void testCalculateCheckSumExampleSatellite() throws Exception {
        OrbitCountChecksumCalculator calculator = new OrbitCountChecksumCalculator();
        int count = calculator.calculateCheckSum(Arrays.asList("COM)B", "B)C", "C)D", "D)E", "E)F", "B)G", "G)H", "D)I", "E)J", "J)K", "K)L"));
        assertEquals(42, count);
    }

    @Test
    public void testCalculateMinimalTransfers() throws Exception {
        OrbitCountChecksumCalculator calculator = new OrbitCountChecksumCalculator();
        int count = calculator
                .calculateMinimalTransfers(Arrays.asList("COM)B", "B)C", "C)D", "D)E", "E)F", "B)G", "G)H", "D)I", "E)J", "J)K", "K)L", "K)YOU", "I)SAN"));
        assertEquals(4, count);
    }

}
