package nl.mwensveen.adventofcode.year_2020.day_11;

import com.google.common.collect.Table;

public class StabilityFinder {

    public int findOccupiedSeatsInStability(Table<Long, Long, PositionState> floorPlan, boolean onlyOneStep) {
        SeatOccupier seatOccupier = new SeatOccupier();
        int rowCount = floorPlan.rowKeySet().size();
        int columnCount = floorPlan.columnKeySet().size();
        Table<Long, Long, PositionState> oldPlan = floorPlan;
        Table<Long, Long, PositionState> newPlan = seatOccupier.changeSeating(oldPlan);
        while (!oldPlan.equals(newPlan)) {
            oldPlan = newPlan;
            if (onlyOneStep) {
                newPlan = seatOccupier.changeSeating(oldPlan);
            } else {
                newPlan = seatOccupier.changeSeatingDirections(oldPlan);
            }
        }

        return countOccupiedSeats(newPlan, rowCount, columnCount);
    }

    private int countOccupiedSeats(Table<Long, Long, PositionState> currentPlan, int rowCount, int columnCount) {
        int count = 0;
        for (long r = 0; r < rowCount; r++) {
            for (long c = 0; c < columnCount; c++) {
                if (currentPlan.get(r, c).equals(PositionState.OCCUPIED)) {
                    count++;
                }
            }

        }
        return count;
    }
}
