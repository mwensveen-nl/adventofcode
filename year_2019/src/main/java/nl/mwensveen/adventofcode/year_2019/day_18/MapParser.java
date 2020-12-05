package nl.mwensveen.adventofcode.year_2019.day_18;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.List;

public class MapParser {
    private Table<Integer, Integer, MapEntry> map = HashBasedTable.create();
    private int maxX = Integer.MIN_VALUE;
    private int entranceX;
    private int entranceY;
    private int numberOfKeys;

    public MapParserResult parse(List<String> input) {
        int y = 0;
        for (String in : input) {
            for (int x = 0; x < in.length(); x++) {
                char c = in.charAt(x);
                Element e = Element.valueOf(c);
                MapEntry me = new MapEntry(e, c);
                map.put(Integer.valueOf(x), Integer.valueOf(y), me);
                if (e == Element.KEY) {
                    numberOfKeys++;
                } else if (e == Element.ENTRANCE) {
                    entranceX = x;
                    entranceY = y;
                }
            }
            if (in.length() - 1 > maxX) {
                maxX = in.length() - 1;
            }
            y++;
        }
        MapParserResult result = new MapParserResult();
        result.entryX = entranceX;
        result.entryY = entranceY;
        result.map = map;
        result.maxX = maxX;
        result.maxY = --y;
        result.numberOfKeys = numberOfKeys;
        return result;
    }

    public static class MapParserResult {
        private Table<Integer, Integer, MapEntry> map;
        private int numberOfKeys;
        private int maxX;
        private int maxY;
        private int entryX;
        private int entryY;

        public Table<Integer, Integer, MapEntry> getMap() {
            return map;
        }

        public int getNumberOfKeys() {
            return numberOfKeys;
        }

        public int getMaxX() {
            return maxX;
        }

        public int getMaxY() {
            return maxY;
        }

        public int getEntryX() {
            return entryX;
        }

        public int getEntryY() {
            return entryY;
        }

    }
}
