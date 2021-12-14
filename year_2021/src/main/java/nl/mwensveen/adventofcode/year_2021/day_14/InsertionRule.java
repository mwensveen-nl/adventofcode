package nl.mwensveen.adventofcode.year_2021.day_14;

import com.google.common.base.MoreObjects;
import java.util.ArrayList;
import java.util.List;

public class InsertionRule {

    private final String insertBetween;
    private final List<String> becomes = new ArrayList<>();

    public InsertionRule(String insertBetween, String insert) {
        this.insertBetween = insertBetween;
        becomes.add(insertBetween.charAt(0) + insert);
        becomes.add(insert + insertBetween.charAt(1));
    }

    public String getInsertBetween() {
        return insertBetween;
    }

    public List<String> getBecomes() {
        return becomes;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("insertBetween", insertBetween).add("becomes", becomes).toString();
    }

}
