package nl.mwensveen.adventofcode.year_2017.day_25;

import com.google.common.base.MoreObjects;

public class Execution {
    private Integer write;
    private String move;
    private String continueWithState;

    public Integer getWrite() {
        return write;
    }

    public void setWrite(Integer write) {
        this.write = write;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }

    public String getContinueWithState() {
        return continueWithState;
    }

    public void setContinueWithState(String continueWithState) {
        this.continueWithState = continueWithState;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("write", write).add("move", move).add("continueWithState", continueWithState).toString();
    }

}
