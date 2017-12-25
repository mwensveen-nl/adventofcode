package nl.mwensveen.adventofcode.year_2017.day_25;

import com.google.common.base.MoreObjects;
import java.util.HashMap;
import java.util.Map;

public class State {
    private Map<Integer, Execution> execs = new HashMap<>();

    public Execution getExecution(Integer i) {
        return execs.get(i);
    }

    public void setExecution(Integer i, Execution e) {
        execs.put(i, e);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("execs", execs).toString();
    }
}
