package nl.mwensveen.adventofcode.year_2017.day_14;

import com.google.common.base.Strings;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import nl.mwensveen.adventofcode.year_2017.day_10.KnotHashPart2;

public class DiskDefragmentation {

    private String input;

    public DiskDefragmentation(String input) {
        this.input = input;
    }

    public long calculate() {
        return IntStream.rangeClosed(0, 127).mapToObj(i -> input + "-" + i).map(s -> toHash(s))
            .map(hash -> toBits(hash)).map(bits -> countOnes(bits)).collect(Collectors.summingLong(l -> l));
    }

    public long calculateGroups() {
        List<char[]> rows = IntStream.rangeClosed(0, 127).mapToObj(i -> input + "-" + i).map(s -> toHash(s))
            .map(hash -> toBits(hash)).map(s -> toCharArray(s)).collect(Collectors.toList());
        int groups = 0;
        for (int i = 0; i < rows.size(); i++) {
            for (int j = 0; j < rows.get(i).length; j++) {
                if (checkAndProcessGroup(rows, i, j)) {
                    groups++;
                }
            }
        }
        return groups;
    }

    private void processGroup(List<char[]> rows, int i, int j) {
        // check up, right, down, left
        if (i > 0) {
            checkAndProcessGroup(rows, i - 1, j);
        }
        if (j < rows.get(i).length - 1) {
            checkAndProcessGroup(rows, i, j + 1);
        }
        if (i < rows.size() - 1) {
            checkAndProcessGroup(rows, i + 1, j);
        }
        if (j > 0) {
            checkAndProcessGroup(rows, i, j - 1);
        }

    }

    private boolean checkAndProcessGroup(List<char[]> rows, int i, int j) {
        if (rows.get(i)[j] == '1') {
            rows.get(i)[j] = '2';
            processGroup(rows, i, j);
            return true;
        }
        return false;
    }

    private char[] toCharArray(String s) {
        return s.toCharArray();
    }

    private long countOnes(String bits) {
        return bits.chars().filter(i -> i == '1').count();
    }

    private String toBits(String hash) {
        return hash.chars().mapToObj(c -> toBinairyString(c)).collect(Collectors.joining());
    }

    private String toHash(String s) {
        KnotHashPart2 knotHashPart2 = new KnotHashPart2(s, 256);
        return knotHashPart2.Calculate();
    }

    public static void main(String[] args) {
        String s = "flqrgnkx";

        // String string2 = s.chars().mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(","));
        // System.out.println(string2);
        KnotHashPart2 knotHashPart2 = new KnotHashPart2(s + "-1", 256);
        String string3 = knotHashPart2.Calculate();
        System.out.println(string3);
        String string = string3.chars().mapToObj(c -> toBinairyString(c)).collect(Collectors.joining());
        System.out.println(string);
    }

    private static String toBinairyString(int c) {
        return Strings.padStart(Integer.toBinaryString(Character.getNumericValue(c)), 4, '0');
    }

}
