package nl.mwensveen.adventofcode.year_2023.day_15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HashAlgorithmTest {

    @Test
    public void testCalculateHash() {
        HashAlgorithm algorithm = new HashAlgorithm();
        assertEquals(52, algorithm.calculateHash("HASH"));
        assertEquals(30, algorithm.calculateHash("rn=1"));
        assertEquals(0, algorithm.calculateHash("rn"));
    }

}
