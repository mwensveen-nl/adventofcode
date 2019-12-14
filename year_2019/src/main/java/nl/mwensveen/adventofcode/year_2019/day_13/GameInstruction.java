package nl.mwensveen.adventofcode.year_2019.day_13;

import java.math.BigInteger;
import java.util.List;

public class GameInstruction {
    private Integer x;
    private Integer y;
    private Tile tile;

    public boolean setNextField(Integer i) {
        if (x == null) {
            x = i;
            return false;
        }
        if (y == null) {
            y = i;
            return false;
        }
        if (tile == null) {
            tile = Tile.valueOf(i);
            return true;
        }
        throw new RuntimeException("Instruction already set");

    }

    public static GameInstruction parse(List<BigInteger> result) {
        GameInstruction gi = new GameInstruction();
        for (BigInteger i : result) {
            gi.setNextField(i.intValue());
        }
        return gi;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Tile getTile() {
        return tile;
    }
}
