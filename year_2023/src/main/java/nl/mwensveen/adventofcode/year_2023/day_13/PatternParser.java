package nl.mwensveen.adventofcode.year_2023.day_13;

import com.google.common.base.Strings;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PatternParser {

    public List<Table<Integer, Integer, Symbol>> parse(List<String> input) {
        List<Table<Integer, Integer, Symbol>> result = new ArrayList<>();
        Table<Integer, Integer, Symbol> pattern = HashBasedTable.create();
        result.add(pattern);
        int r = 1;
        for (Iterator<String> iterator = input.iterator(); iterator.hasNext();) {
            String row = iterator.next();
            if (Strings.isNullOrEmpty(row)) {
                pattern = HashBasedTable.create();
                result.add(pattern);
                r = 1;
            } else {
                for (int c = 1; c <= row.length(); c++) {
                    pattern.put(r, c, Symbol.find(row.substring(c - 1, c)));
                }
                r++;
            }
        }
        return result;
    }

}
