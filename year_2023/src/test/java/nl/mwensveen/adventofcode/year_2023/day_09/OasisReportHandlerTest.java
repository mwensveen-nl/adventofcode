package nl.mwensveen.adventofcode.year_2023.day_09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OasisReportHandlerTest {
    private String input = """
            0 3 6 9 12 15
            1 3 6 10 15 21
            10 13 16 21 30 45
                    """;

    @Test
    public void testHandleReport() {
        OasisReportHandler handler = new OasisReportHandler();
        long result = handler.handleReport(input.lines().toList(), false);
        assertEquals(114, result);
    }

    @Test
    public void testHandleReportPreviousValue() {
        OasisReportHandler handler = new OasisReportHandler();
        long result = handler.handleReport(input.lines().toList(), true);
        assertEquals(2, result);
    }

}
