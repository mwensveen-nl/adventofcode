package nl.mwensveen.adventofcode.year_2020.day_19;

import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RuleValidator {
    public long validate(Collection<String> rules, Collection<String> messages) {
        return messages.stream().filter(message -> rules.contains(message)).count();
    }

    public long validateInfinite(Multimap<Integer, String> rules, Collection<String> messages) {
        // given:
        // 8: 42 | 42 8
        // 11: 42 31 | 42 11 31
        // visual inspection:
        // 0: 8 11
        // 8 and 11 are not used in other rules.
        // so only interesting rules are 42 and 31.
        Collection<String> thirtyOne = rules.get(31);
        Collection<String> fortyTwo = rules.get(42);

        int ruleSize = thirtyOne.iterator().next().length();
        return messages.stream().filter(m -> matches0(m, thirtyOne, fortyTwo, ruleSize)).count();
    }

    private boolean matches0(String m, Collection<String> thirtyOne, Collection<String> fortyTwo, int ruleSize) {
        // 0: 8 11
        // 8: 42 | 42 8
        // 11: 42 31 | 42 11 31
        // therefor
        // minimum rule 0: 42 42 31
        // message must start with 42 42
        // message must end with 31
        // and after 42 only 31
        // and more 42 than 41

        List<String> messageParts = split(m, ruleSize);
        if (messageParts.size() < 3) {
            return false;
        }
        // start with 42 42
        if (!matches(messageParts.get(0), fortyTwo) || !matches(messageParts.get(1), fortyTwo)) {
            return false;
        }
        // ending in 31?
        if (!matches(messageParts.get(messageParts.size() - 1), thirtyOne)) {
            return false;
        }

        // now check on multiple 42, followed by multiple 31
        boolean match42 = true;
        boolean valid = true;
        int number42 = 0;
        int number31 = 0;
        for (int i = 2; i < messageParts.size() - 1 && valid; i++) {
            if (match42) {
                match42 = matches(messageParts.get(i), fortyTwo);
                if (match42) {
                    number42++;
                }
            }
            if (!match42) {
                valid = matches(messageParts.get(i), thirtyOne);
                if (valid) {
                    number31++;
                }
            }
        }
        return valid && number42 >= number31;
    }

    private boolean matches(String messagePart, Collection<String> rules) {
        return rules.contains(messagePart);
    }

    private List<String> split(String message, int size) {
        List<String> output = new ArrayList<>();
        int length = message.length();
        for (int i = 0; i < length; i = i + size) {
            output.add(message.substring(i, Math.min(i + size, length)));
        }
        return output;
    }
}
