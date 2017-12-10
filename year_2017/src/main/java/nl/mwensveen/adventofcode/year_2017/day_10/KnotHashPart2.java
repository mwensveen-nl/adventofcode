package nl.mwensveen.adventofcode.year_2017.day_10;

import com.google.common.base.Strings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KnotHashPart2 {

    private List<Integer> lengths;
    Integer[] elements = null;
    int position = 0;
    int skipSize = 0;
    private int numberOfElements;

    public KnotHashPart2(String lengthString, int numberOfElements) {
        this.numberOfElements = numberOfElements;
        lengths = toIntList(lengthString);
    }

    public String Calculate() {
        makeElementsArray();
        IntStream.range(0, 64).forEach(i -> processLengths());
        return IntStream.range(0, 16).mapToObj(i -> calculateHex(i)).collect(Collectors.joining(""));
    }

    private String calculateHex(int i) {
        int number = IntStream.range(i * 16, (i + 1) * 16).map(index -> elements[index]).reduce(-1, (id, element) -> id < 0 ? element : id ^ element);
        return Strings.padStart(Integer.toHexString(number).toUpperCase(), 2, '0');
    }

    private void processLengths() {
        lengths.forEach(i -> performMove(i));
    }

    private void makeElementsArray() {
        List<Integer> collect = IntStream.range(0, numberOfElements).mapToObj(Integer::valueOf).collect(Collectors.toList());
        elements = collect.toArray(new Integer[numberOfElements]);
    }

    private void performMove(Integer length) {
        ArrayList<Integer> section = getSection(length);
        Collections.reverse(section);
        putSection(section);
        movePosition(length.intValue() + skipSize);
        skipSize++;
    }

    private void movePosition(int i) {
        position = position + i;
        while (position >= elements.length) {
            position = position - elements.length;
        }
    }

    private void putSection(ArrayList<Integer> section) {
        IntStream.range(position, position + section.size()).forEach(index -> updateElements(section.get(index - position), index));
    }

    private void updateElements(Integer element, int index) {
        int i = index;
        while (i >= elements.length) {
            i = i - elements.length;
        }
        elements[i] = element;
    }

    private ArrayList<Integer> getSection(Integer i) {
        ArrayList<Integer> section = new ArrayList<>();
        IntStream.range(position, position + i).forEach(index -> section.add(getElementWithIndex(index)));
        return section;
    }

    private Integer getElementWithIndex(int index) {
        int i = index;
        while (i >= elements.length) {
            i = i - elements.length;
        }
        return elements[i];
    }

    private List<Integer> toIntList(String in) {

        List<Integer> ints = new ArrayList<>();
        IntStream.range(0, in.length()).forEach(i -> ints.add(Integer.valueOf(in.charAt(i))));
        ints.add(17);
        ints.add(31);
        ints.add(73);
        ints.add(47);
        ints.add(23);
        System.out.println(ints);
        return ints;
    }
}
