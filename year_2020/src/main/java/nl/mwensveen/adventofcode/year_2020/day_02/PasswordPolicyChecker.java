package nl.mwensveen.adventofcode.year_2020.day_02;

import com.google.common.base.CharMatcher;

/**
 * Password Checker .
 */
public class PasswordPolicyChecker {

    /**
     * Check if the password matched the policy used by the Sled Rental Place
     *
     * @param policy the policy
     * @param password the password
     * @return true, if successful
     */
    public boolean checkSledRentalPlace(Policy policy, String password) {
        int count = CharMatcher.is(policy.getLetter()).countIn(password);
        return count >= policy.getFirstNumber() && count <= policy.getSecondNumber();
    }

    /**
     * Check if the password matched the policy used by the toboggan rental shop.
     *
     * @param policy the policy
     * @param password the password
     * @return true, if successful
     */
    public boolean checkTobogganRentalShop(Policy policy, String password) {
        return checkOnPositon(password, policy.getFirstNumber(), policy.getLetter()) ^ checkOnPositon(password, policy.getSecondNumber(), policy.getLetter());
    }

    private boolean checkOnPositon(String password, int pos, char letter) {
        // no concept of "index zero"!
        return password.charAt(pos - 1) == letter;
    }
}
