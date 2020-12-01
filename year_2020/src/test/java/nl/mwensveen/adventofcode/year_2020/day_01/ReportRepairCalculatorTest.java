package nl.mwensveen.adventofcode.year_2020.day_01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ReportRepairCalculatorTest {

    private ReportRepairCalculator calculator = new ReportRepairCalculator();

    @Test
    public void testFindEntriesInExpenceReportTwo() throws Exception {
        List<Integer> one = Arrays.asList(1721, 979, 366, 1456, 299, 675);

        assertEquals(514579, calculator.findEntriesInExpenceReportTwo(one));
    }

    @Test
    public void testFindEntriesInExpenceReportTwoThree() throws Exception {
        List<Integer> one = Arrays.asList(1721, 979, 366, 1456, 299, 675);

        assertEquals(241861950, calculator.findEntriesInExpenceReportThree(one));
    }

    @Test
    public void testFindEntriesInExpenceReportTwo2() throws Exception {
        List<Integer> one = Arrays.asList(1721, 979, 366, 1456, 675);
        try {
            calculator.findEntriesInExpenceReportTwo(one);
            fail();
        } catch (RuntimeException e) {
            assertEquals("not found", e.getMessage());
        }
    }
}
