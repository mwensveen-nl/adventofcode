package nl.mwensveen.adventofcode.year_2021.day_15;

import org.junit.jupiter.api.Test;

public class RiskPathTest {

    @Test
    public void testAddRiskLevel() {
        RiskPath riskPath = new RiskPath();
        riskPath.addRiskLevel(new RiskLevel(0, 0, 1));
    }

    @Test
    public void testContains() {
        RiskPath riskPath = new RiskPath();
        riskPath.addRiskLevel(new RiskLevel(0, 0, 1));
        riskPath.addRiskLevel(new RiskLevel(1, 1, 3));
    }

    @Test
    public void testGetTotalRisk() {
        throw new RuntimeException("not yet implemented");
    }

    @Test
    public void testCopy() {
        throw new RuntimeException("not yet implemented");
    }

}
