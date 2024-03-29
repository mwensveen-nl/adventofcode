package nl.mwensveen.adventofcode.year_2022.day_06;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StartOfPacketMarker {

    public int findMarker(String input, int count) {
        List<String> chars = input.chars().mapToObj(i -> String.valueOf((char) i)).toList();

        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();

        int i = count;
        list.addAll(chars.subList(0, i));

        set.clear();
        set.addAll(list);
        while (set.size() != count) {
            list.remove(0);
            list.add(chars.get(i));
            set.clear();
            set.addAll(list);
            i++;
        }

        return i;
    }
}
