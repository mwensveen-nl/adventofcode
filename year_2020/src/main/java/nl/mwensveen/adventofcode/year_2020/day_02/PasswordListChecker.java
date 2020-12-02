package nl.mwensveen.adventofcode.year_2020.day_02;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Check a list of Passwords with their policies.
 */
public class PasswordListChecker {

    private PasswordPolicyChecker passwordPolicyChecker = new PasswordPolicyChecker();
    private List<PasswordCombo> combos;

    public PasswordListChecker(List<String> input) {
        combos = input.stream().map(PasswordCombo::new).collect(Collectors.toList());
    }

    public long checkListSledRentalPlaceStyle() {
        long count = combos.stream().filter(c -> passwordPolicyChecker.checkSledRentalPlace(c.policy, c.password)).count();
        return count;
    }

    public long checkListTobogganRentalShopStyle() {
        long count = combos.stream().filter(c -> passwordPolicyChecker.checkTobogganRentalShop(c.policy, c.password)).count();
        return count;
    }

    private static class PasswordCombo {
        private Policy policy;
        private String password;

        private PasswordCombo(String input) {
            int index = input.indexOf(":");
            policy = new Policy(input.substring(0, index));
            password = input.substring(index + 1).trim();
        }
    }
}
