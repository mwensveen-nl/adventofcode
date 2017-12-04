package nl.mwensveen.adventofcode.year_2017.day_3;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.Hashtable;
import java.util.Map;

public class SpiralMemorySumAdjacentSquares {

    private int number;

    public SpiralMemorySumAdjacentSquares(int number) {
        this.number = number;
    }

    public int calculate() {
        Map<Cell, Integer> table = new Hashtable<>();
        Cell cell = new Cell(0, 0);
        int value = 1;
        table.put(cell, Integer.valueOf(value));
        Direction direction = Direction.UP;
        // System.out.println(cell);
        while (value <= number) {
            direction = nextCellDirection(cell, direction);
            cell = nextCell(cell, direction);
            value = calculateValue(cell, table);
            table.put(cell, Integer.valueOf(value));
        }
        return value;
    }

    private int calculateValue(Cell cell, Map<Cell, Integer> table) {
        // System.out.println(cell);
        int value = 0;
        for (int r = -1; r <= 1; r++) {
            for (int c = -1; c <= 1; c++) {
                Cell search = new Cell(cell.getRow() + r, cell.getColumn() + c);
                if (table.containsKey(search)) {
                    value += table.get(search).intValue();
                }
            }
        }
        return value;
    }

    private Direction nextCellDirection(Cell cell, Direction direction) {
        Direction newDirection = direction;
        if (cell.getRow() == 0 && cell.getColumn() == 0) {
            newDirection = Direction.RIGHT;
        }
        if ((cell.getRow() < 0 || cell.getColumn() < 0) && Math.abs(cell.getRow()) == Math.abs(cell.getColumn())) {
            newDirection = direction.next();
        }
        if (cell.getRow() >= 0 && cell.getColumn() > 0 && cell.getRow() + 1 == cell.getColumn()) {
            newDirection = direction.next();
        }
        // System.out.println(newDirection);
        return newDirection;
    }

    private Cell nextCell(Cell cell, Direction direction) {
        switch (direction) {
            case UP:
                return new Cell(cell.getRow() - 1, cell.getColumn());
            case LEFT:
                return new Cell(cell.getRow(), cell.getColumn() - 1);
            case DOWN:
                return new Cell(cell.getRow() + 1, cell.getColumn());
            case RIGHT:
                return new Cell(cell.getRow(), cell.getColumn() + 1);
            default:
                return null;
        }
    }

    private enum Direction {
        UP,
        LEFT,
        DOWN,
        RIGHT;
        public Direction next() {
            switch (this) {
                case UP:
                    return LEFT;
                case LEFT:
                    return DOWN;
                case DOWN:
                    return RIGHT;
                default:
                    return UP;
            }
        }
    }

    private static class Cell {
        private final int row;
        private final int column;

        public Cell(int row, int column) {
            super();
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }

        @Override
        public boolean equals(final Object other) {
            if (this == other) {
                return true;
            }
            if (other == null) {
                return false;
            }
            if (!getClass().equals(other.getClass())) {
                return false;
            }
            Cell castOther = (Cell) other;
            return Objects.equal(row, castOther.row) && Objects.equal(column, castOther.column);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(row, column);
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this).add("row", row).add("column", column).toString();
        }

    }

}
