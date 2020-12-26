package nl.mwensveen.adventofcode.year_2020.day_25;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EncryptionKeyCalculatorTest {

    @Test
    public void testCalculateEncryptionKey() throws Exception {
        EncryptionKeyCalculator encryptionKeyCalculator = new EncryptionKeyCalculator();
        assertEquals(14897079, encryptionKeyCalculator.calculateEncryptionKey(17807724, 5764801));
    }

}
