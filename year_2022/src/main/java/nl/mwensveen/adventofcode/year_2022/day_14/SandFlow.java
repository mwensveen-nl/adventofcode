package nl.mwensveen.adventofcode.year_2022.day_14;

import com.google.common.collect.Table;

public class SandFlow {

    public int flowSandInfinite(Cave cave) {
        int startX = 500;
        int startY = 0;
        Table<Integer, Integer, String> map = cave.getMap();
        boolean flowToBottom = false;
        int sands = 0;

        while (!flowToBottom) {
            boolean done = false;
            int sandX = startX;
            int sandY = startY;
            while (!done) {
                if (map.get(sandX, sandY + 1) == null) {
                    sandY++;
                } else if (map.get(sandX - 1, sandY + 1) == null) {
                    sandX--;
                    sandY++;
                } else if (map.get(sandX + 1, sandY + 1) == null) {
                    sandX++;
                    sandY++;
                } else {
                    map.put(sandX, sandY, "o");
                    done = true;
                    sands++;
                }
                if (sandY > cave.getyMax()) {
                    flowToBottom = true;
                    done = true;
                }
            }
        }

        return sands;
    }

    public int flowSandWithBottom(Cave cave) {
        int startX = 500;
        int startY = 0;
        Table<Integer, Integer, String> map = cave.getMap();
        boolean blocked = false;
        int sands = 0;

        while (!blocked) {
            boolean done = false;
            int sandX = startX;
            int sandY = startY;
            while (!done) {
                if (map.get(sandX, sandY + 1) == null) {
                    sandY++;
                } else if (map.get(sandX - 1, sandY + 1) == null) {
                    sandX--;
                    sandY++;
                } else if (map.get(sandX + 1, sandY + 1) == null) {
                    sandX++;
                    sandY++;
                } else if (sandX == startX && sandY == startY) {
                    blocked = true;
                    done = true;
                    sands++;
                } else {
                    map.put(sandX, sandY, "o");
                    done = true;
                    sands++;
                }
                if (sandY == cave.getyMax() + 1) {
                    map.put(sandX, sandY, "o");
                    done = true;
                    sands++;
                }
            }
        }

        return sands;
    }
}
