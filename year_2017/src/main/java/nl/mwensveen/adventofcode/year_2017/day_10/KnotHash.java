package nl.mwensveen.adventofcode.year_2017.day_10;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KnotHash {

    private List<Integer> lengths;
    Integer[] elements = null;
    int position = 0;
    int skipSize = 0;
    private int numberOfElements;

    public KnotHash(String lengthString, int numberOfElements) {
        this.numberOfElements = numberOfElements;
        lengths = toIntList(lengthString);
    }

    public int Calculate() {
        List<Integer> collect = IntStream.range(0, numberOfElements).mapToObj(Integer::valueOf).collect(Collectors.toList());
        elements = collect.toArray(new Integer[numberOfElements]);
        lengths.forEach(i -> performMove(i));
        return elements[0] * elements[1];
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
        if (position >= elements.length) {
            position = position - elements.length;
        }
    }

    private void putSection(ArrayList<Integer> section) {
        IntStream.range(position, position + section.size()).forEach(index -> updateElements(section.get(index - position), index));
    }

    private void updateElements(Integer element, int index) {
        if (index >= elements.length) {
            elements[index - elements.length] = element;
        } else {
            elements[index] = element;
        }
    }

    private ArrayList<Integer> getSection(Integer i) {
        ArrayList<Integer> section = new ArrayList<>();
        IntStream.range(position, position + i).forEach(index -> section.add(getElementWithIndex(index)));
        return section;
    }

    private Integer getElementWithIndex(int index) {
        int i = index;
        if (i >= elements.length) {
            i = i - elements.length;
        }
        return elements[i];
    }

    private List<Integer> toIntList(String in) {
        Iterable<String> split = Splitter.on(",")
            .trimResults()
            .omitEmptyStrings()
            .split(in);
        ArrayList<String> newArrayList = Lists.newArrayList(split);
        List<Integer> list = newArrayList.stream().map(s -> Integer.valueOf(s)).collect(Collectors.toList());
        System.out.println(list);
        return list;

    }
}
