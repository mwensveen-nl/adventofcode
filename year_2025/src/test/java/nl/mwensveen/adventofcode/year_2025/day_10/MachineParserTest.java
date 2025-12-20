package nl.mwensveen.adventofcode.year_2025.day_10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MachineParserTest {

    @Test
    public void parse() {
        MachineParser parser = new MachineParser();
        Machine machine = parser.parse("[.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7}");
        assertEquals(6, machine.indicatorLight().bits());
        assertEquals(6, machine.buttons().size());
    }

}
