package nl.mwensveen.adventofcode.year_2020.day_19;

import java.util.Collection;

public class RuleValidator {
    public long validate(Collection<String> rules, Collection<String> messages) {
        return messages.stream().filter(message -> rules.contains(message)).count();
    }
}
