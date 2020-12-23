package nl.mwensveen.adventofcode.year_2020.day_23;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cups {
    private static final Integer ONE = Integer.valueOf(1);
    private Cup current;
    private Map<Integer, Cup> cupsMap = new HashMap<>();
    private Cup pick;
    private Integer lowest = Integer.MAX_VALUE;
    private Integer highest = Integer.MIN_VALUE;

    public Integer doPickUp() {
        pick = current.next;
        current.next = pick.next.next.next;
        current.next.prev = current;
        return pick.number;
    }

    public Integer dropPickup() {
        Integer destination = current.number - 1;
        return dropPickup(destination);
    }

    private Integer dropPickup(Integer destination) {
        Integer newDestination = destination;
        if (newDestination.compareTo(lowest) < 0) {
            newDestination = highest;
        }
        if (pick.number.equals(newDestination) || pick.next.number.equals(newDestination) || pick.next.next.number.equals(newDestination)) {
            newDestination = newDestination - 1;
            return dropPickup(newDestination);
        } else {
            Cup destinationCup = cupsMap.get(newDestination);
            Cup oldNext = destinationCup.next;
            destinationCup.next = pick;
            pick.prev = destinationCup;
            oldNext.prev = pick.next.next;
            pick.next.next.next = oldNext;
            return newDestination;
        }
    }

    public Integer pickNewCurrent() {
        current = current.next;
        return current.number;
    }

    public String finishedLabels() {
        Cup one = cupsMap.get(ONE);
        StringBuilder stringBuilder = new StringBuilder();
        Cup next = one.next;
        while (!next.equals(one)) {
            stringBuilder.append(next.number.toString());
            next = next.next;
        }
        return stringBuilder.toString();
    }

    public long findStars() {
        Cup one = cupsMap.get(ONE);
        return one.next.number.longValue() * one.next.next.number.longValue();
    }

    /**
     * Constructor that creates a Cups with the values of a Cups.Builder.
     */
    public Cups(List<Integer> cupsList) {
        Cup prev = null;
        Cup curr = null;
        for (Integer number : cupsList) {
            curr = new Cup(number);
            if (current == null) {
                current = curr;
            }
            if (prev != null) {
                prev.next = curr;
                curr.prev = prev;
            }
            cupsMap.put(number, curr);
            prev = curr;
            lowest = Math.min(lowest, number);
            highest = Math.max(highest, number);
        }
        current.prev = prev;
        prev.next = current;
    }

    private class Cup {
        private Cup prev;
        private Cup next;
        private final Integer number;

        public Cup(Integer number) {
            super();
            this.number = number;
        }

        @Override
        public String toString() {
            return "Cup [(" + prev.number + ") " + number + " (" + next.number + ")]";
        }

    }
}
