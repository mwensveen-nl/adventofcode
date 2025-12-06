package nl.mwensveen.adventofcode.year_2025.day_03;

import java.math.BigInteger;
import java.util.List;

public class MaxJoltageDetector {

    public BigInteger detect(List<String> banks) {
        return banks.stream().map(this::maxJoltage).reduce(BigInteger.ZERO, BigInteger::add);
    }

    private BigInteger maxJoltage(String bank) {
        char char1 = findHighestChar(bank.substring(0, bank.length() - 1));
        char char2 = findHighestChar(bank.substring(bank.indexOf(char1) + 1));
        return new BigInteger("" + char1 + char2);

    }

    private char findHighestChar(String str) {
        if (str == null || str.isEmpty()) {
            return '\0'; // Return null character or handle the empty case as appropriate
        }

        // Initialize maxChar with the first character of the string
        char maxChar = str.charAt(0);

        // Iterate through the rest of the string
        for (int i = 1; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            // Compare the current character's value with the current maximum
            if (currentChar > maxChar) {
                maxChar = currentChar;
            }
        }

        return maxChar;
    }
}
