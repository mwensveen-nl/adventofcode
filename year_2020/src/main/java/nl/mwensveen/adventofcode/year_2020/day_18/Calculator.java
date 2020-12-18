package nl.mwensveen.adventofcode.year_2020.day_18;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public Long calculate(String input) {
        String calc = input.replace(" ", "");

        List<Object> newList = toObjectList(calc);
        return Math.round(calculate(newList));
    }

    public Long calculateAdvanced(String input) {
        String calc = input.replace(" ", "");

        List<Object> newList = toObjectList(calc);
        return Math.round(calculateAdvanced(newList));
    }

    private Double calculate(List<Object> list) {
        List<Object> reducedList = new ArrayList<>();
        list.forEach(o -> {
            if (o instanceof List) {
                reducedList.add(calculate((List) o));
            } else {
                reducedList.add(o);
            }
        });

        int i = 0;
        while (i < reducedList.size()) {
            if (Operator.MULTIPLY.equals(reducedList.get(i)) || Operator.PLUS.equals(reducedList.get(i))) {
                Double result = calculate(reducedList.get(i - 1), reducedList.get(i + 1), reducedList.get(i));
                reducedList.set(i, result);
                reducedList.remove(i + 1);
                reducedList.remove(i - 1);
            } else {
                i++;
            }
        }

        return Double.parseDouble(reducedList.get(0).toString());
    }

    private double calculateAdvanced(List<Object> list) {
        List<Object> reducedList = new ArrayList<>();
        list.forEach(o -> {
            if (o instanceof List) {
                reducedList.add(calculateAdvanced((List) o));
            } else {
                reducedList.add(o);
            }
        });

        int i = 0;
        while (i < reducedList.size()) {
            if (Operator.PLUS.equals(reducedList.get(i))) {
                Double result = calculate(reducedList.get(i - 1), reducedList.get(i + 1), reducedList.get(i));
                reducedList.set(i, result);
                reducedList.remove(i + 1);
                reducedList.remove(i - 1);
            } else {
                i++;
            }
        }

        i = 0;
        while (i < reducedList.size()) {
            if (Operator.MULTIPLY.equals(reducedList.get(i))) {
                Double result = calculate(reducedList.get(i - 1), reducedList.get(i + 1), reducedList.get(i));
                reducedList.set(i, result);
                reducedList.remove(i + 1);
                reducedList.remove(i - 1);
            } else {
                i++;
            }
        }

        return Double.parseDouble(reducedList.get(0).toString());
    }

    private List<Object> toObjectList(String calc) {
        final List<Object> list = new ArrayList<>();
        for (int i = 0; i < calc.length(); i++) {
            addToList(calc.substring(i, i + 1), list);
        }
        List<Object> newList = procesParentesis(list);
        return newList;
    }

    private List<Object> procesParentesis(List<Object> list) {
        List<Object> newList = new ArrayList<>();
        while (list.size() > 0) {
            Object o = list.get(0);
            list.remove(0);
            if (!(o instanceof Parenthesis)) {
                newList.add(o);
            } else if (Parenthesis.OPEN == o) {
                newList.add(procesParentesis(list));
            } else {
                return newList;
            }
        }
        return newList;
    }

    private void addToList(String string, List<Object> list) {
        if (Operator.isOperator(string)) {
            list.add(Operator.find(string));
        } else if (Parenthesis.isParenthesis(string)) {
            list.add(Parenthesis.find(string));
        } else {
            addNumberToList(string, list);
        }
    }

    private void addNumberToList(String string, List<Object> list) {
        Double number = Double.valueOf(string);
        int size = list.size();
        if (size > 0) {
            Object prev = list.get(size - 1);
            if (!(prev instanceof Operator || prev instanceof Parenthesis)) {
                addNumberToListWithPreviousNumber(string, list, size);
            } else if (prev.equals(Operator.MINUS)) {
                addNumberToListWithPreviousMinus(list, number, size);
            } else {
                list.add(Double.valueOf(string));
            }
        } else {
            list.add(Double.valueOf(string));
        }
    }

    private void addNumberToListWithPreviousMinus(List<Object> list, Double number, int size) {
        Double negative = Double.valueOf(-1 * number.doubleValue());
        Object prevPrev = size > 1 ? list.get(size - 2) : null;
        if (null == prevPrev || prevPrev instanceof Operator || prevPrev instanceof Parenthesis && Parenthesis.OPEN.equals(prevPrev)) {
            list.set(size - 1, negative);
        } else {
            list.set(size - 1, Operator.PLUS);
            list.add(negative);
        }
    }

    private void addNumberToListWithPreviousNumber(String string, List<Object> list, int size) {
        Double prev = (Double) list.get(size - 1);
        Double prevDouble = prev.doubleValue() * 10;
        Double curDouble = Double.parseDouble(string);
        Double newDouble = prevDouble < 0 ? prevDouble - curDouble : prevDouble + curDouble;
        list.set(size - 1, Double.valueOf(newDouble));
    }

    private Double calculate(Object operand1, Object operand2, Object operator) {
        Operator o = (Operator) operator;
        Double d1 = (Double) operand1;
        Double d2 = (Double) operand2;

        Double result = null;
        switch (o) {
            case MULTIPLY:
                result = d1.doubleValue() * d2.doubleValue();
                break;
            case DIVIDE:
                result = d1.doubleValue() / d2.doubleValue();
                break;
            case PLUS:
                result = d1.doubleValue() + d2.doubleValue();
                break;
            case MINUS:
                result = d1.doubleValue() - d2.doubleValue();
                break;
        }
        return result;
    }

}