package nl.mwensveen.adventofcode.year_2020.day_11;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class SeatOccupier {

    public Table<Long, Long, PositionState> changeSeating(Table<Long, Long, PositionState> floorPlan) {
        int rowCount = floorPlan.rowKeySet().size();
        int columnCount = floorPlan.columnKeySet().size();
        Table<Long, Long, PositionState> newPlan = HashBasedTable.create(rowCount, columnCount);
        for (long r = 0; r < rowCount; r++) {
            for (long c = 0; c < columnCount; c++) {
                PositionState positionState = floorPlan.get(r, c);
                if (!positionState.equals(PositionState.FLOOR)) {
                    int count = countAdjacentOccupied(floorPlan, r, c, rowCount, columnCount);
                    if (positionState.equals(PositionState.OCCUPIED) && count >= 4) {
                        positionState = PositionState.EMPTY;
                    } else if (positionState.equals(PositionState.EMPTY) && count == 0) {
                        positionState = PositionState.OCCUPIED;
                    }
                }
                newPlan.put(r, c, positionState);
            }

        }
        return newPlan;
    }

    public Table<Long, Long, PositionState> changeSeatingDirections(Table<Long, Long, PositionState> floorPlan) {
        int rowCount = floorPlan.rowKeySet().size();
        int columnCount = floorPlan.columnKeySet().size();
        Table<Long, Long, PositionState> newPlan = HashBasedTable.create(rowCount, columnCount);
        for (long r = 0; r < rowCount; r++) {
            for (long c = 0; c < columnCount; c++) {
                PositionState positionState = floorPlan.get(r, c);
                if (!positionState.equals(PositionState.FLOOR)) {
                    int count = countDirectionsOccupied(floorPlan, r, c, rowCount, columnCount);
                    if (positionState.equals(PositionState.OCCUPIED) && count >= 5) {
                        positionState = PositionState.EMPTY;
                    } else if (positionState.equals(PositionState.EMPTY) && count == 0) {
                        positionState = PositionState.OCCUPIED;
                    }
                }
                newPlan.put(r, c, positionState);
            }

        }
        return newPlan;
    }

    private int countAdjacentOccupied(Table<Long, Long, PositionState> floorPlan, long r, long c, long rowCount, long columnCount) {
        int count = 0;
        for (long rowCheck = r - 1; rowCheck <= r + 1; rowCheck++) {
            if (rowCheck >= 0 && rowCheck < rowCount) {
                for (long columnCheck = c - 1; columnCheck <= c + 1; columnCheck++) {
                    if (columnCheck >= 0 && columnCheck < columnCount && !(rowCheck == r && columnCheck == c)) {
                        if (floorPlan.get(rowCheck, columnCheck).equals(PositionState.OCCUPIED)) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    private int countDirectionsOccupied(Table<Long, Long, PositionState> floorPlan, long r, long c, long rowCount, long columnCount) {
        int count = 0;
        for (long rowCheck = -1; rowCheck <= 1; rowCheck++) {
            for (long columnCheck = -1; columnCheck <= 1; columnCheck++) {
                boolean occupied = findOccupiedSeat(r, rowCheck, c, columnCheck, floorPlan, rowCount, columnCount);
                if (occupied) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean findOccupiedSeat(long r, long rowMove, long c, long columnMove, Table<Long, Long, PositionState> floorPlan, long rowCount,
            long columnCount) {
        if (rowMove == 0 && columnMove == 0) {
            return false;
        }
        PositionState state = null;
        boolean done = false;
        long rowCheck = r;
        long columnCheck = c;
        while (!done) {
            rowCheck += rowMove;
            columnCheck += columnMove;
            if (rowCheck < 0 || rowCheck >= rowCount || columnCheck < 0 || columnCheck >= columnCount) {
                done = true;
            } else {
                if (!floorPlan.get(rowCheck, columnCheck).equals(PositionState.FLOOR)) {
                    state = floorPlan.get(rowCheck, columnCheck);
                    done = true;
                }
            }
        }
        return PositionState.OCCUPIED.equals(state);
    }

}
