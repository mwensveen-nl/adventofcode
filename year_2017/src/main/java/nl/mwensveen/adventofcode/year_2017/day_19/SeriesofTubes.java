package nl.mwensveen.adventofcode.year_2017.day_19;

import com.google.common.base.Splitter;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Table;
import java.util.ArrayList;
import java.util.Set;

public class SeriesofTubes {

    private Table<Integer, Integer, String> table;
    private StringBuffer letters;
    private int countSteps;

    public SeriesofTubes(String input) {
        table = toTable(input);
    }

    public String calculate() {
        performMoves();
        return letters.toString();
    }

    public int calculateSteps() {
        performMoves();
        return countSteps;
    }

    private void performMoves() {
        letters = new StringBuffer();
        countSteps = 0;
        Integer row = Integer.valueOf(0);
        Set<Integer> keySet = table.row(row).keySet();
        Integer column = keySet.iterator().next();
        Direction direction = Direction.Down;

        while (true) {
            countSteps++;
            switch (direction) {
                case Down:
                    row++;
                    direction = verticalMove(letters, row, column, direction);
                    break;
                case Up:
                    row--;
                    direction = verticalMove(letters, row, column, direction);
                    break;
                case Right:
                    column++;
                    direction = horizontalMove(letters, row, column, direction);
                    break;
                case Left:
                    column--;
                    direction = horizontalMove(letters, row, column, direction);
                    break;
                case End:
                    countSteps--;
                    return;
                default:
                    throw new RuntimeException("error on direction");
            }
        }

    }

    private Direction verticalMove(StringBuffer letters, Integer row, Integer column, Direction direction) {
        if (!table.contains(row, column)) {
            return Direction.End;
        }

        String s = table.get(row, column);

        if (s.equals(Direction.Switch.getSymbol())) {
            if (table.contains(row, column - 1)) {
                return Direction.Left;
            } else {
                return Direction.Right;
            }
        }

        if (s.equals(Direction.Down.getSymbol()) || s.equals(Direction.Left.getSymbol())) {
            return direction;
        }

        letters.append(s);
        return direction;
    }

    private Direction horizontalMove(StringBuffer letters, Integer row, Integer column, Direction direction) {
        if (!table.contains(row, column)) {
            return Direction.End;
        }
        String s = table.get(row, column);
        if (s.equals(Direction.Switch.getSymbol())) {
            if (table.contains(row - 1, column)) {
                return Direction.Up;
            } else {
                return Direction.Down;
            }
        }
        if (s.equals(Direction.Down.getSymbol()) || s.equals(Direction.Left.getSymbol())) {
            return direction;
        }
        letters.append(s);
        return direction;
    }

    private Table<Integer, Integer, String> toTable(String in) {
        Table<Integer, Integer, String> table = HashBasedTable.create();
        Iterable<String> split = Splitter.on("\n")
            .split(in);
        ArrayList<String> rows = Lists.newArrayList(split);
        for (int r = 0; r < rows.size(); r++) {
            String row = rows.get(r);
            for (int c = 0; c < row.length(); c++) {
                String s = row.substring(c, c + 1);
                if (!s.equals(" ")) {
                    table.put(r, c, s);
                }
            }

        }
        return table;
    }
}
