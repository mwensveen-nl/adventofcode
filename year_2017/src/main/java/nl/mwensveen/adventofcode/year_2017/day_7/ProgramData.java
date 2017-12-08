package nl.mwensveen.adventofcode.year_2017.day_7;

import com.google.common.base.MoreObjects;
import java.util.ArrayList;
import java.util.List;

class ProgramData {
    private final String name;
    private final int weight;
    private List<String> aboveNames;
    private final List<ProgramData> abovePrograms = new ArrayList<>();
    private boolean hasProgramUnder = false;
    private int totalWeight = 0;

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public List<String> getAboveNames() {
        return aboveNames;
    }

    public List<ProgramData> getAbovePrograms() {
        return abovePrograms;
    }

    public ProgramData(String name, int weight, List<String> aboveNames) {
        super();
        this.name = name;
        this.weight = weight;
        this.setAboveNames(aboveNames);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("name", name).add("weight", weight).add("above", getAboveNames()).toString();
    }

    public boolean hasAboveProgramWithName(String name) {
        return abovePrograms.stream().filter(pd -> pd.getName().equals(name)).count() == 1;
    }

    public void setAboveNames(List<String> aboveNames) {
        this.aboveNames = aboveNames;
    }

    public boolean isHasProgramUnder() {
        return hasProgramUnder;
    }

    public void setHasProgramUnder(boolean hasProgramUnder) {
        this.hasProgramUnder = hasProgramUnder;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(int totalWeight) {
        this.totalWeight = totalWeight;
    }

}