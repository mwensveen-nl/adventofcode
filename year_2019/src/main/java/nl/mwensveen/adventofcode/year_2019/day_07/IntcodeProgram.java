package nl.mwensveen.adventofcode.year_2019.day_07;

import java.util.List;
import java.util.OptionalInt;

public class IntcodeProgram {
    private int inputValue = 1;
    private int result = Integer.MIN_VALUE;
    private OptionalInt phaseSetting;
    private int i = 0;
    private List<Integer> list;

    private boolean exit = false;

    public IntcodeProgram(int phaseSetting, List<Integer> list) {
        this.list = list;
        this.phaseSetting = OptionalInt.of(phaseSetting);
    }

    public Integer process(boolean pausing, Integer input) {
        inputValue = input;
        if (!pausing) {
            i = 0;
        }
        Instruction inst = new Instruction(list.get(i));
        Opcode opcode = inst.getOpcode();
        while (Opcode.STOP != opcode) {
            switch (opcode) {
                case ADD:
                    add(list, i, inst);
                    i += 1 + opcode.getNumberOfParameters();
                    break;
                case MULTIPLY:
                    multiply(list, i, inst);
                    i += 1 + opcode.getNumberOfParameters();
                    break;
                case INPUT:
                    input(list, i, inst);
                    i += 1 + opcode.getNumberOfParameters();
                    break;
                case OUTPUT:
                    output(list, i, inst);
                    i += 1 + opcode.getNumberOfParameters();
                    if (pausing) {
                        return result;
                    }
                    break;
                case JUMP_IF_TRUE:
                    i = jumpIfTrue(list, i, inst);
                    break;
                case JUMP_IF_FALSE:
                    i = jumpIfFalse(list, i, inst);
                    break;
                case LESS_THEN:
                    lessThen(list, i, inst);
                    i += 1 + opcode.getNumberOfParameters();
                    break;
                case EQUALS:
                    equals(list, i, inst);
                    i += 1 + opcode.getNumberOfParameters();
                    break;
                default:
                    throw new RuntimeException("Cannot process opcode: " + opcode);
            }
            inst = new Instruction(list.get(i));
            opcode = inst.getOpcode();
        }
        exit = true;
        return result;
    }

    private void equals(List<Integer> list, int index, Instruction inst) {
        int value1 = getParam1(list, index, inst);
        int value2 = getParam2(list, index, inst);
        int value3 = list.get(index + 3);
        if (value1 == value2) {
            list.set(value3, 1);
        } else {
            list.set(value3, 0);
        }
    }

    private void lessThen(List<Integer> list, int index, Instruction inst) {
        int value1 = getParam1(list, index, inst);
        int value2 = getParam2(list, index, inst);
        int value3 = list.get(index + 3);
        // int value3 = getParam3(list, index, inst);
        if (value1 < value2) {
            list.set(value3, 1);
        } else {
            list.set(value3, 0);
        }
    }

    private int jumpIfFalse(List<Integer> list, int index, Instruction inst) {
        int value1 = getParam1(list, index, inst);
        if (value1 == 0) {
            return getParam2(list, index, inst);
        }
        return index + 1 + inst.getOpcode().getNumberOfParameters();
    }

    private int jumpIfTrue(List<Integer> list, int index, Instruction inst) {
        int value1 = getParam1(list, index, inst);
        if (value1 != 0) {
            return getParam2(list, index, inst);
        }
        return index + 1 + inst.getOpcode().getNumberOfParameters();
    }

    private void output(List<Integer> list, int index, Instruction inst) {
        int value1 = getParam1(list, index, inst);
        // System.err.println(value1);
        result = value1;
    }

    private void input(List<Integer> list, int index, Instruction inst) {
        int value1 = list.get(index + 1);
        list.set(value1, phaseSetting.orElse(inputValue));
        phaseSetting = OptionalInt.empty();
    }

    private void add(List<Integer> list, int index, Instruction inst) {
        int value1 = getParam1(list, index, inst);
        int value2 = getParam2(list, index, inst);
        int value3 = list.get(index + 3);

        list.set(value3, value1 + value2);
    }

    private int getParam1(List<Integer> list, int index, Instruction inst) {
        int parm1 = list.get(index + 1);
        return inst.getParameterMode1() == ParameterMode.IMMEDIATE ? parm1 : list.get(parm1);
    }

    private int getParam2(List<Integer> list, int index, Instruction inst) {
        int parm2 = list.get(index + 2);
        return inst.getParameterMode2() == ParameterMode.IMMEDIATE ? parm2 : list.get(parm2);
    }

    private int getParam3(List<Integer> list, int index, Instruction inst) {
        int parm3 = list.get(index + 3);
        return inst.getParameterMode3() == ParameterMode.IMMEDIATE ? parm3 : list.get(parm3);
    }

    private void multiply(List<Integer> list, int index, Instruction inst) {
        int value1 = getParam1(list, index, inst);
        int value2 = getParam2(list, index, inst);
        int value3 = list.get(index + 3);

        list.set(value3, value1 * value2);
    }

    public boolean isExit() {
        return exit;
    }

}
