package nl.mwensveen.adventofcode.year_2019.day_04;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PasswordCheckerTest {

    @Test
    public void testCheck() throws Exception {
        assertFalse(PasswordChecker.check(123450));
        assertTrue(PasswordChecker.check(111111));
        assertFalse(PasswordChecker.check(123789));
    }

    @Test
    public void testCheckWithoutLongGroup() throws Exception {
        assertTrue(PasswordChecker.checkWithoutLongGroup(112233));
        assertFalse(PasswordChecker.checkWithoutLongGroup(123444));
        assertTrue(PasswordChecker.checkWithoutLongGroup(111122));
        assertTrue(PasswordChecker.checkWithoutLongGroup(112222));
    }

}
