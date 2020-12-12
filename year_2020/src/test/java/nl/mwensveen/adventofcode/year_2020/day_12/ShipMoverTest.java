package nl.mwensveen.adventofcode.year_2020.day_12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ShipMoverTest {

    @Test
    public void testMoveShip() throws Exception {
        List<String> input = Arrays.asList("F10", "N3", "F7", "R90", "F11");
        InstructionParser instructionParser = new InstructionParser();
        List<Instruction> instructions = instructionParser.parseInstructions(input);

        ShipMover shipMover = new ShipMover();
        Position position = shipMover.moveShip(instructions);

        assertEquals(8, position.getNorthSouth());
        assertEquals(17, position.getWestEast());
    }

    @Test
    public void moveShipAndWaypoint() throws Exception {
        List<String> input = Arrays.asList("F10", "N3", "F7", "R90", "F11");
        InstructionParser instructionParser = new InstructionParser();
        List<Instruction> instructions = instructionParser.parseInstructions(input);

        ShipMover shipMover = new ShipMover();
        Position position = shipMover.moveShipAndWaypoint(instructions, 10, 1);

        assertEquals(72, position.getNorthSouth());
        assertEquals(214, position.getWestEast());

    }

}
