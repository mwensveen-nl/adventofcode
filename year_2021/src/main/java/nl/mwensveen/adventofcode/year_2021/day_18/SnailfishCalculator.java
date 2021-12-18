package nl.mwensveen.adventofcode.year_2021.day_18;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class SnailfishCalculator {

    public String calculate(List<String> input) {
        Reducer reducer = new Reducer();
        List<String> operatorOne = null;
        for (Iterator<String> iterator = input.iterator(); iterator.hasNext();) {
            String string = iterator.next();
            if (operatorOne == null) {
                operatorOne = stringAsList(string);
            } else {
                List<String> operatorTwo = stringAsList(string);
                operatorOne = add(operatorOne, operatorTwo);
                operatorOne = reducer.reduce(operatorOne);
            }
        }

        Magnituder magnituder = new Magnituder();
        return magnituder.calculateMagnitude(operatorOne);
    }

    private List<String> add(List<String> operatorOne, List<String> operatorTwo) {
        List<String> number = new ArrayList<>();
        number.add("[");
        number.addAll(operatorOne);
        number.add(",");
        number.addAll(operatorTwo);
        number.add("]");
        return number;
    }

    private List<String> stringAsList(String signal) {
        return signal.chars().mapToObj(e -> Character.toString(e)).collect(Collectors.toList());
    }
}
