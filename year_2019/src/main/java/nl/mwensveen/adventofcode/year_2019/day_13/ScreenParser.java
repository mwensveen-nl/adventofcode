package nl.mwensveen.adventofcode.year_2019.day_13;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

public class ScreenParser {

    public List<GameInstruction> parseScreen(List<BigInteger> input) {
        List<GameInstruction> gameInstructions = new ArrayList<>();
        IntcodeProgram program = new IntcodeProgram(input, OptionalInt.of(3));
        List<BigInteger> result = program.process(0);
        while (!result.isEmpty()) {
            GameInstruction gameInstruction = GameInstruction.parse(result);
            gameInstructions.add(gameInstruction);
            result = program.process(0);
        }
        return gameInstructions;
    }

    public long countBlocks(List<GameInstruction> gameInstructions) {
        return gameInstructions.stream().filter(gi -> gi.getTile().equals(Tile.BLOCK)).count();
    }
}
