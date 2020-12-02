package nl.mwensveen.adventofcode.year_2020.day_02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PolicyTest {

    @Test
    public void testPolicy() throws Exception {
        Policy policy = new Policy("1-3 a");
        assertEquals(1, policy.getFirstNumber());
        assertEquals(3, policy.getSecondNumber());
        assertEquals('a', policy.getLetter());
    }

    @Test
    public void testPolicy2() throws Exception {
        Policy policy = new Policy("10-12 p");
        assertEquals(10, policy.getFirstNumber());
        assertEquals(12, policy.getSecondNumber());
        assertEquals('p', policy.getLetter());
    }

}
