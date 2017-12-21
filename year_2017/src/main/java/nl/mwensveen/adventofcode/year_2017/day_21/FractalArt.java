package nl.mwensveen.adventofcode.year_2017.day_21;

import com.google.common.base.Splitter;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Table;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FractalArt {

    private String input;
    private Map<Table<Integer, Integer, String>, Table<Integer, Integer, String>> book;

    public FractalArt(String input) {
        this.input = input;
    }

    public long calculate(int iterations) {
        book = new HashMap<>();
        ArrayList<String> rules = split(input, "\n");
        rules.forEach(r -> putRuleInBook(r));

        Table<Integer, Integer, String> image = patternToTable(".#./..#/###");

        for (int x = 0; x < iterations; x++) {
            image = createNewImage(image);
            // System.out.println();
            // print(image);
        }

        return image.values().stream().filter(s -> s.equals("#")).count();
    }

    private Table<Integer, Integer, String> createNewImage(Table<Integer, Integer, String> image) {
        Table<Integer, Integer, String> ni = HashBasedTable.create();
        Set<Integer> row = image.rowKeySet();
        int squareSize = row.size() % 2 == 0 ? 2 : 3;
        int squareCount = row.size() / squareSize;
        for (int r = 0; r < squareCount; r++) {
            for (int c = 0; c < squareCount; c++) {
                Table<Integer, Integer, String> square = getSquare(r, c, image, squareSize);
                Table<Integer, Integer, String> replacement = book.get(square);
                putReplacementInNewImage(r, c, replacement, ni);
            }
        }
        return ni;
    }

    private void putReplacementInNewImage(int r, int c, Table<Integer, Integer, String> replacement, Table<Integer, Integer, String> ni) {
        int size = replacement.rowKeySet().size();
        for (int r1 = 0; r1 < size; r1++) {
            for (int c1 = 0; c1 < size; c1++) {
                ni.put(r * size + r1, c * size + c1, replacement.get(r1, c1));
            }
        }
    }

    private Table<Integer, Integer, String> getSquare(int r, int c, Table<Integer, Integer, String> image, int size) {
        Table<Integer, Integer, String> nt = HashBasedTable.create();
        for (int r1 = 0; r1 < size; r1++) {
            for (int c1 = 0; c1 < size; c1++) {
                nt.put(r1, c1, image.get(r * size + r1, c * size + c1));
            }
        }
        return nt;
    }

    private void putRuleInBook(String pattern) {
        ArrayList<String> patterns = split(pattern, "=>");

        Table<Integer, Integer, String> p0 = patternToTable(patterns.get(0));
        Table<Integer, Integer, String> replace = patternToTable(patterns.get(1));

        Table<Integer, Integer, String> p1 = rotate(p0);
        Table<Integer, Integer, String> p2 = rotate(p1);
        Table<Integer, Integer, String> p3 = rotate(p2);
        Table<Integer, Integer, String> p4 = flip(p0);
        Table<Integer, Integer, String> p5 = rotate(p4);
        Table<Integer, Integer, String> p6 = rotate(p5);
        Table<Integer, Integer, String> p7 = rotate(p6);
        book.put(p0, replace);
        book.put(p1, replace);
        book.put(p2, replace);
        book.put(p3, replace);
        book.put(p4, replace);
        book.put(p5, replace);
        book.put(p6, replace);
        book.put(p7, replace);
    }

    private Table<Integer, Integer, String> patternToTable(String pattern) {
        ArrayList<String> rows = split(pattern, "/");
        Table<Integer, Integer, String> p0 = rowsToTable(rows);
        return p0;
    }

    private Table<Integer, Integer, String> flip(Table<Integer, Integer, String> p0) {
        Table<Integer, Integer, String> p4 = HashBasedTable.create();
        int size = p0.rowKeySet().size();
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                p4.put(r, size - 1 - c, p0.get(r, c));
            }
        }
        return p4;
    }

    private Table<Integer, Integer, String> rotate(Table<Integer, Integer, String> p0) {
        Table<Integer, Integer, String> p1 = HashBasedTable.create();
        int size = p0.rowKeySet().size();
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                p1.put(size - 1 - c, r, p0.get(r, c));
            }
        }
        return p1;
    }

    private Table<Integer, Integer, String> rowsToTable(ArrayList<String> rows) {
        Table<Integer, Integer, String> p0 = HashBasedTable.create();
        for (int r = 0; r < rows.size(); r++) {
            for (int c = 0; c < rows.get(r).length(); c++) {
                p0.put(r, c, rows.get(r).substring(c, c + 1));
            }
        }
        return p0;
    }

    private static void print(Table<Integer, Integer, String> p0) {
        int size = p0.rowKeySet().size();
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                System.out.print(p0.get(r, c));
            }
            System.out.println();
        }
    }

    private static ArrayList<String> split(String in, String splitString) {
        Iterable<String> split = Splitter.on(splitString)
            .trimResults()
            .omitEmptyStrings()
            .split(in);
        ArrayList<String> newArrayList = Lists.newArrayList(split);
        return newArrayList;
    }
}
