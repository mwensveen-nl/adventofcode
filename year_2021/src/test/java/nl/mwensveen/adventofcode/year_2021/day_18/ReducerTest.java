package nl.mwensveen.adventofcode.year_2021.day_18;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class ReducerTest {

    @Test
    public void testReduce() {
        Reducer reducer = new Reducer();
        List<String> result = reducer.reduce(stringAsList("[[[[[9,8],1],2],3],4]"));

        String join = String.join("", result);
        assertEquals("[[[[0,9],2],3],4]", join);
    }

    @Test
    public void testReduce2() {
        Reducer reducer = new Reducer();
        List<String> result = reducer.reduce(stringAsList("[7,[6,[5,[4,[3,2]]]]]"));

        String join = String.join("", result);
        assertEquals("[7,[6,[5,[7,0]]]]", join);
    }

    @Test
    public void testReduce3() {
        Reducer reducer = new Reducer();
        List<String> result = reducer.reduce(stringAsList("[[6,[5,[4,[3,2]]]],1]"));

        String join = String.join("", result);
        assertEquals("[[6,[5,[7,0]]],3]", join);
    }

    @Test
    public void testReduce4() {
        Reducer reducer = new Reducer();
        List<String> result = reducer.reduce(stringAsList("[[3,[2,[8,0]]],[9,[5,[4,[3,2]]]]]"));

        String join = String.join("", result);
        assertEquals("[[3,[2,[8,0]]],[9,[5,[7,0]]]]", join);
    }

    @Test
    public void testReduce5() {
        Reducer reducer = new Reducer();

        List<String> result = reducer.reduce(Arrays.asList("[", "10", ",", "1", "]"));

        String join = String.join("", result);
        assertEquals("[[5,5],1]", join);
    }

    @Test
    public void testReduce6() {
        Reducer reducer = new Reducer();

        List<String> result = reducer.reduce(Arrays.asList("[", "11", ",", "1", "]"));

        String join = String.join("", result);
        assertEquals("[[5,6],1]", join);
    }

    private List<String> stringAsList(String signal) {
        return signal.chars().mapToObj(e -> Character.toString(e)).collect(Collectors.toList());
    }
}
