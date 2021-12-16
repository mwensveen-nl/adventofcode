package nl.mwensveen.adventofcode.year_2021.day_15;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertTrue(riskPath.contains(new RiskLevel(0, 0, 1)));
        assertTrue(riskPath.contains(new RiskLevel(1, 1, 3)));
        assertFalse(riskPath.contains(new RiskLevel(2, 1, 3)));
    }

    @Test
    public void testGetTotalRisk() {
        RiskPath riskPath = new RiskPath();
        riskPath.addRiskLevel(new RiskLevel(0, 0, 1));
        assertEquals(0, riskPath.getTotalRisk());
        riskPath.addRiskLevel(new RiskLevel(1, 1, 3));
        assertEquals(3, riskPath.getTotalRisk());
        riskPath.addRiskLevel(new RiskLevel(1, 0, 1));
        assertEquals(4, riskPath.getTotalRisk());
    }

    @Test
    public void testCopy() {
        RiskPath riskPath = new RiskPath();
        riskPath.addRiskLevel(new RiskLevel(0, 0, 1));
        riskPath.addRiskLevel(new RiskLevel(1, 1, 3));

        RiskPath other = riskPath.copy();
        assertFalse(riskPath.equals(other));
        assertTrue(other.contains(new RiskLevel(0, 0, 1)));
        assertTrue(other.contains(new RiskLevel(1, 1, 3)));

        assertEquals(3, other.getTotalRisk());
    }

}
