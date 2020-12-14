package nl.mwensveen.adventofcode.year_2020.day_14;

import java.math.BigInteger;
import org.junit.jupiter.api.Test;

public class DockingDataSolutionTest {

    @Test
    public void testPart1() throws Exception {
        BigInteger bi = new BigInteger("11");
        bi = bi.clearBit(1);
        bi = bi.setBit(6);
        System.out.println(bi);
    }

}
