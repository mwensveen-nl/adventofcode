package nl.mwensveen.adventofcode.year_2020.day_02;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PasswordPolicyCheckerTest {

    private PasswordPolicyChecker passwordPhilosophy = new PasswordPolicyChecker();

    @Test
    public void testCheckSledRentalPlace1() throws Exception {
        Policy policy = new Policy("1-3 a");
        assertTrue(passwordPhilosophy.checkSledRentalPlace(policy, "abcde"));
    }

    @Test
    public void testCheckSledRentalPlace2() throws Exception {
        Policy policy = new Policy("2-9 c");
        assertTrue(passwordPhilosophy.checkSledRentalPlace(policy, "ccccccccc"));
    }

    @Test
    public void testCheckSledRentalPlaceFalse1() throws Exception {
        Policy policy = new Policy("1-3 b");
        assertFalse(passwordPhilosophy.checkSledRentalPlace(policy, "cdefg"));
    }

    @Test
    public void testCheckSledRentalPlaceFalse2() throws Exception {
        Policy policy = new Policy("2-9 c");
        assertFalse(passwordPhilosophy.checkSledRentalPlace(policy, "cccccccccc"));
    }

    @Test
    public void testCheckSledRentalPlaceFalse3() throws Exception {
        Policy policy = new Policy("2-9 c");
        assertFalse(passwordPhilosophy.checkSledRentalPlace(policy, "bbcbbb"));
    }

    @Test
    public void testCheckTobogganRentalShop() throws Exception {
        Policy policy = new Policy("1-3 a");
        assertTrue(passwordPhilosophy.checkTobogganRentalShop(policy, "abcde"));
    }

    @Test
    public void testCheckTobogganRentalShop1False() throws Exception {
        Policy policy = new Policy("1-3 b");
        assertFalse(passwordPhilosophy.checkTobogganRentalShop(policy, "cdefg"));
    }

    @Test
    public void testCheckTobogganRentalShop2False() throws Exception {
        Policy policy = new Policy("2-9 c");
        assertFalse(passwordPhilosophy.checkTobogganRentalShop(policy, "ccccccccc"));
    }

}
