package nl.mwensveen.adventofcode.year_2022.day_10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class CRTscreen {
    Map<Integer, Boolean> screen = new HashMap<>();

    public CRTscreen() {
        IntStream.range(0, 240).forEach(i -> screen.put(i, Boolean.FALSE));
    }

    public List<Integer> sprite(Cycle c) {
        return IntStream.rangeClosed(c.beginValue() - 1, c.beginValue() + 1).mapToObj(i -> Integer.valueOf(i)).toList();
    }

    public IntStream positions(Cycle c) {
        return IntStream.rangeClosed(c.begin() - 1, c.end() - 1);
    }

    public void draw(Cycle c) {
        List<Integer> sprite = sprite(c);
        positions(c).filter(i -> sprite.contains(i % 40)).forEach(i -> screen.put(i, Boolean.TRUE));
    }

    public String getRow(int row) {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(row * 40, (row + 1) * 40).forEach(i -> stringBuilder.append((screen.get(i) ? "#" : ".")));
        return stringBuilder.toString();
    }

    public void toScreen() {
        IntStream.range(0, 6).forEach(i -> System.out.println(getRow(i)));
    }
}
