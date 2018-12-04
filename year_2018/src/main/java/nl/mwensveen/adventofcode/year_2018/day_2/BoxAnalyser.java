package nl.mwensveen.adventofcode.year_2018.day_2;

import com.google.common.base.MoreObjects;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BoxAnalyser {
    private static final Integer TWO = new Integer(2);
    private static final Integer THREE = new Integer(3);
    private String id;
    private long countTwo = 0;
    private long countThree = 0;

    public BoxAnalyser(String id) {
        this.id = id.trim();
        analyse();
    }

    private void analyse() {
        Map<Integer, Integer> count = new HashMap<>();
        id.chars().forEach(i -> {
            if (count.containsKey(i)) {
                count.put(i, count.get(i) + 1);
            } else {
                count.put(i, 1);
            }
        });
        countTwo = count.values().stream().filter(TWO::equals).count();
        countThree = count.values().stream().filter(THREE::equals).count();
    }

    public boolean twoTimes() {
        return countTwo > 0;
    }

    public boolean threeTimes() {
        return countThree > 0;
    }

    public Optional<String> compareOneCharDifference(BoxAnalyser otherBA) {
        boolean diffFound = false;
        StringBuilder sb = new StringBuilder(otherBA.id);
        for (int i = id.length() - 1; i >= 0; i--) {
            if (id.charAt(i) != sb.charAt(i)) {
                if (diffFound) {
                    return Optional.empty();
                }
                sb.deleteCharAt(i);
                diffFound = true;
            }
        }
        if (diffFound) {
            return Optional.of(sb.toString());
        }
        return Optional.empty();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("id", id).toString();
    }
}
