package nl.mwensveen.adventofcode.year_2017.day_8;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnusualRegisterInstructions {

    private List<String> instructionList;
    private Map<String, Integer> registers;
    private int maxDuringProces = 0;

    public UnusualRegisterInstructions(String instructions) {
        instructionList = toLineList(instructions);
    }

    public Integer calculate() {
        registers = new HashMap<>();
        instructionList.stream().map(s -> createInstruction(s)).forEach(inst -> perform(inst));
        return registers.values().stream().max(Comparator.naturalOrder()).get();
    }

    public Integer calculatePartTwo() {
        registers = new HashMap<>();
        instructionList.stream().map(s -> createInstruction(s)).forEach(inst -> perform(inst));
        return maxDuringProces;
    }

    private void perform(Instruction inst) {
        int currentValue = 0;
        if (registers.containsKey(inst.getRegister())) {
            currentValue = registers.get(inst.getRegister()).intValue();
        }
        int conditionValue = 0;
        if (registers.containsKey(inst.getConditionRegister())) {
            conditionValue = registers.get(inst.getConditionRegister()).intValue();
        }
        if (compare(conditionValue, inst.conditionOperator, Integer.valueOf(inst.conditionValue).intValue())) {
            int newValue = execute(currentValue, inst.operation, Integer.valueOf(inst.value).intValue());
            registers.put(inst.getRegister(), Integer.valueOf(newValue));
            maxDuringProces = Math.max(newValue, maxDuringProces);
        }
    }

    private int execute(int currentValue, String operation, int operationValue) {
        if (operation.equals("inc")) {
            return currentValue + operationValue;
        }
        return currentValue - operationValue;
    }

    private boolean compare(int registerValue, String conditionOperator, int conditionValue) {
        switch (conditionOperator) {
            case ">":
                return registerValue > conditionValue;
            case "<":
                return registerValue < conditionValue;
            case ">=":
                return registerValue >= conditionValue;
            case "==":
                return registerValue == conditionValue;
            case "<=":
                return registerValue <= conditionValue;
            case "!=":
                return registerValue != conditionValue;
        }
        return false;
    }

    private Instruction createInstruction(String s) {
        Iterable<String> split = Splitter.on(" ")
            .trimResults()
            .omitEmptyStrings()
            .split(s);
        ArrayList<String> l = Lists.newArrayList(split);
        return new Instruction(l.get(0), l.get(1), l.get(2), l.get(4), l.get(5), l.get(6));
    }

    private List<String> toLineList(String in) {
        Iterable<String> split = Splitter.on("\n")
            .trimResults()
            .omitEmptyStrings()
            .split(in);
        ArrayList<String> newArrayList = Lists.newArrayList(split);
        return newArrayList;
    }

    private static class Instruction {
        private final String register;
        private final String operation;
        private final String value;
        private final String conditionRegister;
        private final String conditionOperator;
        private final String conditionValue;

        public Instruction(String register, String operation, String value, String conditionRegister, String conditionOperator, String conditionValue) {
            super();
            this.register = register;
            this.operation = operation;
            this.value = value;
            this.conditionRegister = conditionRegister;
            this.conditionOperator = conditionOperator;
            this.conditionValue = conditionValue;
        }

        public String getRegister() {
            return register;
        }

        public String getOperation() {
            return operation;
        }

        public String getConditionRegister() {
            return conditionRegister;
        }

        public String getConditionOperator() {
            return conditionOperator;
        }

        public String getConditionValue() {
            return conditionValue;
        }

        public String getValue() {
            return value;
        }

    }
}