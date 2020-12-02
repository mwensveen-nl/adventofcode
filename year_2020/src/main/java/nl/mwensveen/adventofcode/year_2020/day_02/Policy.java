package nl.mwensveen.adventofcode.year_2020.day_02;

/**
 * Password Policy.
 */
public class Policy {

    private final int firstNumber;
    private final int secondNumber;
    private final char letter;

    public Policy(String input) {
        int index1 = input.indexOf('-');
        int index2 = input.indexOf(' ');
        firstNumber = Integer.parseInt(input.substring(0, index1));
        secondNumber = Integer.parseInt(input.substring(index1 + 1, index2));
        letter = input.substring(index2 + 1).charAt(0);
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public char getLetter() {
        return letter;
    }
}
