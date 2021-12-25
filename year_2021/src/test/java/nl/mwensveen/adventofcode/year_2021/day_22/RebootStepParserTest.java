package nl.mwensveen.adventofcode.year_2021.day_22;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RebootStepParserTest {

    @Test
    public void testParse() {
        List<String> input = Arrays.asList("on x=10..12,y=13..15,z=16..18",
                "on x=11..13,y=11..13,z=11..13",
                "off x=9..11,y=9..11,z=9..11",
                "on x=10..10,y=10..10,z=10..10");

        RebootStepParser parser = new RebootStepParser();
        List<Step> list = parser.parse(input);
        assertEquals(4, list.size());

        Step step = list.get(0);
        assertEquals(10, step.getStartX());
        assertEquals(12, step.getEndX());
        assertEquals(13, step.getStartY());
        assertEquals(15, step.getEndY());
        assertEquals(16, step.getStartZ());
        assertEquals(18, step.getEndZ());
        assertEquals("on", step.getOnOff());
        assertEquals("off", list.get(2).getOnOff());
    }

}
