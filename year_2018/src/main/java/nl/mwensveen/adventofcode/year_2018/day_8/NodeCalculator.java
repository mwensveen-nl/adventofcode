package nl.mwensveen.adventofcode.year_2018.day_8;

import java.util.ArrayList;
import java.util.List;
import org.javatuples.Pair;

public class NodeCalculator {

    private String input;

    public NodeCalculator(String input) {
        this.input = input;
    }

    public Integer calculate() {
        Pair<String, Integer> parameter = new Pair<String, Integer>(input, Integer.valueOf(0));

        parameter = calculate(parameter);
        return parameter.getValue1();
    }

    public Integer calculateComplex() {
        Pair<String, Integer> parameter = new Pair<String, Integer>(input, Integer.valueOf(0));

        parameter = calculateComplex(parameter);
        return parameter.getValue1();
    }

    private Pair<String, Integer> calculate(Pair<String, Integer> parameter) {
        int children = getQuantityChildNodes(parameter.getValue0());
        int metadata = getQuantityMetadataEntries(parameter.getValue0());
        Pair<String, Integer> nextParameter = parameter.setAt0(removeHeaders(parameter.getValue0()));

        for (int i = 0; i < children; i++) {
            nextParameter = calculate(nextParameter);
        }

        for (int i = 0; i < metadata; i++) {
            nextParameter = addValueMetadata(nextParameter);

        }
        return nextParameter;
    }

    private Pair<String, Integer> calculateComplex(Pair<String, Integer> parameter) {
        int children = getQuantityChildNodes(parameter.getValue0());
        int metadata = getQuantityMetadataEntries(parameter.getValue0());
        Pair<String, Integer> nextParameter = new Pair<>(removeHeaders(parameter.getValue0()), Integer.valueOf(0));

        if (children == 0) {
            for (int i = 0; i < metadata; i++) {
                nextParameter = addValueMetadata(nextParameter);
            }
            return nextParameter;
        }

        List<Integer> valueChildNodes = new ArrayList<>();
        for (int i = 0; i < children; i++) {
            nextParameter = calculateComplex(nextParameter);
            valueChildNodes.add(i, nextParameter.getValue1());
            nextParameter = nextParameter.setAt1(Integer.valueOf(0));
        }

        for (int i = 0; i < metadata; i++) {
            nextParameter = addValueMetadata(nextParameter, valueChildNodes);
        }
        return nextParameter;
    }

    private Pair<String, Integer> addValueMetadata(Pair<String, Integer> parameter, List<Integer> valueChildNodes) {
        int i = parameter.getValue0().indexOf(' ');
        int childNodeNumber;
        String s;
        if (i < 0) {
            childNodeNumber = Integer.parseInt(parameter.getValue0());
            s = "";
        } else {
            childNodeNumber = Integer.parseInt(parameter.getValue0().substring(0, i));
            s = parameter.getValue0().substring(i + 1);
        }
        if (childNodeNumber < 1 || childNodeNumber > valueChildNodes.size()) {
            return parameter.setAt0(s);
        }
        Integer sum = Integer.valueOf(parameter.getValue1().intValue() + valueChildNodes.get(childNodeNumber - 1));
        return new Pair<String, Integer>(s, sum);
    }

    private Pair<String, Integer> addValueMetadata(Pair<String, Integer> parameter) {
        int i = parameter.getValue0().indexOf(' ');
        int value;
        String s;
        if (i < 0) {
            value = Integer.parseInt(parameter.getValue0());
            s = "";
        } else {
            value = Integer.parseInt(parameter.getValue0().substring(0, i));
            s = parameter.getValue0().substring(i + 1);
        }
        Integer sum = Integer.valueOf(parameter.getValue1().intValue() + value);
        return new Pair<String, Integer>(s, sum);
    }

    private String removeHeaders(String s) {
        int i = s.indexOf(' ');
        int i2 = s.indexOf(' ', i + 1);
        return s.substring(i2 + 1);
    }

    private int getQuantityChildNodes(String s) {
        int i = s.indexOf(' ');
        return Integer.parseInt(s.substring(0, i));
    }

    private int getQuantityMetadataEntries(String s) {
        int i = s.indexOf(' ');
        int i2 = s.indexOf(' ', i + 1);
        return Integer.parseInt(s.substring(i + 1, i2));
    }
}
