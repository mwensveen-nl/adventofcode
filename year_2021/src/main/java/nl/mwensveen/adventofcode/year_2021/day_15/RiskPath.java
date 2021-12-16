package nl.mwensveen.adventofcode.year_2021.day_15;

import java.util.ArrayList;
import java.util.List;

public class RiskPath {
    private List<RiskLevel> travelled = new ArrayList<>();
    private Long totalRisk = 0L;

    void addRiskLevel(RiskLevel riskLevel) {
        if (!travelled.isEmpty()) {
            totalRisk += riskLevel.getRisk();
        }
        travelled.add(riskLevel);
    }

    boolean contains(RiskLevel riskLevel) {
        return travelled.contains(riskLevel);
    }

    public Long getTotalRisk() {
        return totalRisk;
    }

    RiskPath copy() {
        RiskPath copy = new RiskPath();
        copy.travelled.addAll(this.travelled);
        copy.totalRisk = this.totalRisk;
        return copy;
    }
}
