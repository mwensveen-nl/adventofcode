package nl.mwensveen.adventofcode.year_2019.day_12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EnergyCalculatorTest {

    @Test
    public void testCalculateEnergie() throws Exception {
        Moon m = new Moon(2, 1, -3);
        m.UpdateVelocity(-3, -2, 1);

        EnergyCalculator calculator = new EnergyCalculator();
        int energie = calculator.calculateEnergie(m);

        assertEquals(36, energie);
    }

}
