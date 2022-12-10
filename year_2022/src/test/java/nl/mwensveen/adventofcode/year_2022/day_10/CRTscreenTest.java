package nl.mwensveen.adventofcode.year_2022.day_10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CRTscreenTest {

    @Test
    public void testDraw() {
        ProgramExecution programExecution = new ProgramExecution();
        CRTscreen crTscreen = new CRTscreen();
        Cycle c = new Cycle(0, 0, 1, 1);

        c = programExecution.executeInstruction("addx 15", c);
        crTscreen.draw(c);
        String row = crTscreen.getRow(0);
        assertEquals("##......................................", row);

        c = programExecution.executeInstruction("addx -11", c);
        crTscreen.draw(c);
        row = crTscreen.getRow(0);
        assertEquals("##......................................", row);

        c = programExecution.executeInstruction("addx 6", c);
        crTscreen.draw(c);
        row = crTscreen.getRow(0);
        assertEquals("##..##..................................", row);

    }

}
