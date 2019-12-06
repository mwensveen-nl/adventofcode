package nl.mwensveen.adventofcode.year_2019.day_06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class OrbitEntryTest {

    @Test
    public void testOrbit() throws Exception {
        OrbitEntry o = new OrbitEntry("COM)B");
        assertEquals("COM", o.getBase());
        assertEquals("B", o.getSatellite());
    }

    @Test
    public void testOrbit2() throws Exception {
        OrbitEntry o = new OrbitEntry("B)C");
        assertEquals("B", o.getBase());
        assertEquals("C", o.getSatellite());
    }

    @Test
    public void testOrbit3() throws Exception {
        OrbitEntry o = new OrbitEntry("BCD)CDE");
        assertEquals("BCD", o.getBase());
        assertEquals("CDE", o.getSatellite());
    }

}
