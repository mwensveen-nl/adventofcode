package nl.mwensveen.adventofcode.year_2018.day_5;

public class PolymerReaction {

    private StringBuilder polymerOrig;

    public PolymerReaction(String input) {
        polymerOrig = new StringBuilder(input);
    }

    public int react() {
        StringBuilder polymer = new StringBuilder(polymerOrig.toString());
        performReaction(polymer);

        return polymer.length();
    }

    private void performReaction(StringBuilder polymer) {
        for (int i = 0; i < polymer.length() - 1;) {
            String first = polymer.substring(i, i + 1);
            String second = polymer.substring(i + 1, i + 2);
            if (first.equalsIgnoreCase(second) && !first.equals(second)) {
                polymer.delete(i, i + 2);
                if (i != 0) {
                    i--;
                }
            } else {
                i++;
            }
        }
    }

    public int removeAndReact() {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int min = Integer.MAX_VALUE;

        for (char c : alphabet) {
            String s = String.valueOf(c);
            StringBuilder polymer = new StringBuilder(polymerOrig.toString());
            for (int i = polymer.length() - 1; i >= 0; i--) {
                if (polymer.substring(i, i + 1).equalsIgnoreCase(s)) {
                    polymer.delete(i, i + 1);
                }
            }
            performReaction(polymer);
            if (polymer.length() < min) {
                min = polymer.length();
            }
        }
        return min;
    }

}
