package nl.mwensveen.adventofcode.year_2019.day_04;

public class PasswordChecker {

    public static boolean check(int pw) {
        int number = pw;
        boolean adjacent = false;
        int prev = 99;
        while (number > 0) {
            int n = number % 10;
            if (prev < n) {
                // note we check from right to left, so
                // Going from left to right, the digits never decrease; they only ever increase or stay the same
                // becomes the digits never increase;
                return false;
            }
            if (prev == n) {
                adjacent = true;
            }
            prev = n;
            number = number / 10;
        }
        return adjacent;
    }
}
