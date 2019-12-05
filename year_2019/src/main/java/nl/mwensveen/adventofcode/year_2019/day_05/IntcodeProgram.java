package nl.mwensveen.adventofcode.year_2019.day_05;

import java.util.List;

public class IntcodeProgram {
    private int inputValue = 1;
    private int result = Integer.MIN_VALUE;

    public IntcodeProgram(int i) {
        inputValue = i;
    }

    public Integer process(List<Integer> list) {
        int i = 0;
        Instruction inst = new Instruction(list.get(i));
        Opcode opcode = inst.getOpcode();
        while (Opcode.STOP != opcode) {
            switch (opcode) {
                case ADD:
                    add(list, i, inst);
                    break;
                case MULTIPLY:
                    multiply(list, i, inst);
                    break;
                case INPUT:
                    input(list, i, inst);
                    break;
                case OUTPUT:
                    output(list, i, inst);
                    break;
                default:
                    break;
            }
            i += 1 + opcode.getNumberOfParameters();
            inst = new Instruction(list.get(i));
            opcode = inst.getOpcode();
        }
        return result;
    }

    private void output(List<Integer> list, int index, Instruction inst) {
        int value1 = list.get(index + 1);
        System.err.println(list.get(value1));
        result = list.get(value1);
    }

    private void input(List<Integer> list, int index, Instruction inst) {
        int value1 = list.get(index + 1);
        list.set(value1, inputValue);
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

    // private int getParam3(List<Integer> list, int index, Instruction inst) {
    // int parm3 = list.get(index + 3);
    // return inst.getParameterMode3() == ParameterMode.POSITION ? parm3 : list.get(parm3);
    // }

    private void multiply(List<Integer> list, int index, Instruction inst) {
        int value1 = getParam1(list, index, inst);
        int value2 = getParam2(list, index, inst);
        int value3 = list.get(index + 3);

        list.set(value3, value1 * value2);
    }

}
