package nl.mwensveen.adventofcode.year_2019.day_13;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.math.BigInteger;
import java.util.List;
import java.util.OptionalInt;

public class GamePayer {
    private List<BigInteger> input;

    public GamePayer(List<BigInteger> input) {
        this.input = input;
    }

    public int playGame() {
        int paddle = 0;
        Integer ball = null;
        int xSize = Integer.MIN_VALUE;
        int ySize = Integer.MIN_VALUE;
        BigInteger score = null;
        IntcodeProgram program = new IntcodeProgram(input, OptionalInt.of(3));

        Table<Integer, Integer, Tile> screen = HashBasedTable.create();

        int joystick = getJoystick(paddle, ball);
        List<BigInteger> move = program.process(joystick);
        paddle += joystick;
        while (!move.isEmpty()) {
            GameInstruction gameInstruction = new GameInstruction();
            gameInstruction.setNextField(move.get(0).intValue());
            gameInstruction.setNextField(move.get(1).intValue());
            if (gameInstruction.getX() == -1 && gameInstruction.getY() == 0) {
                score = move.get(2);
            } else {
                gameInstruction.setNextField(move.get(2).intValue());
                screen.put(gameInstruction.getX(), gameInstruction.getY(), gameInstruction.getTile());
                if (gameInstruction.getTile() == Tile.HORIZONTALPADDLE) {
                    paddle = gameInstruction.getX();
                }
                if (gameInstruction.getTile() == Tile.BALL) {
                    ball = gameInstruction.getX();
                }
                xSize = Math.max(gameInstruction.getX(), xSize);
                ySize = Math.max(gameInstruction.getY(), ySize);
            }
            joystick = getJoystick(paddle, ball);
            printScreen(screen, xSize, ySize);
            move = program.process(joystick);
        }
        return score.intValue();
    }

    private void printScreen(Table<Integer, Integer, Tile> screen, int xSize, int ySize) {
        for (int y = 0; y <= ySize; y++) {
            for (int x = 0; x <= xSize; x++) {
                if (screen.contains(x, y)) {
                    System.out.print(screen.get(x, y).getIcon());
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
        System.out.println();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println();
    }

    private int getJoystick(int paddle, Integer ball) {
        if (ball == null) {
            return 0;
        }
        if (paddle > ball.intValue()) {
            return -1;
        } else if (paddle < ball.intValue()) {
            return 1;
        } else {
            return 0;
        }
    }
}
