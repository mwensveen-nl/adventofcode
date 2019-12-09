package nl.mwensveen.adventofcode.year_2019.day_09;

import com.codepoetics.protonpack.StreamUtils;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntcodeProgram {
    private BigInteger inputValue = BigInteger.ONE;
    private BigInteger result = BigInteger.valueOf(Integer.MIN_VALUE);
    private BigInteger relativeBase = BigInteger.ZERO;

    public IntcodeProgram(int i) {
        inputValue = BigInteger.valueOf(i);
    }

    public BigInteger process(List<BigInteger> programList) {
        Map<BigInteger, BigInteger> program = new HashMap<>();
        StreamUtils.zipWithIndex(programList.stream()).forEach(c -> program.put(BigInteger.valueOf(c.getIndex()), c.getValue()));
        BigInteger i = BigInteger.valueOf(0);
        Instruction inst = new Instruction(get(program, i));
        Opcode opcode = inst.getOpcode();
        while (Opcode.STOP != opcode) {
            switch (opcode) {
                case ADD:
                    add(program, i, inst);
                    i = i.add(BigInteger.ONE).add(BigInteger.valueOf(opcode.getNumberOfParameters()));
                    break;
                case MULTIPLY:
                    multiply(program, i, inst);
                    i = i.add(BigInteger.ONE).add(BigInteger.valueOf(opcode.getNumberOfParameters()));
                    break;
                case INPUT:
                    input(program, i, inst);
                    i = i.add(BigInteger.ONE).add(BigInteger.valueOf(opcode.getNumberOfParameters()));
                    break;
                case OUTPUT:
                    output(program, i, inst);
                    i = i.add(BigInteger.ONE).add(BigInteger.valueOf(opcode.getNumberOfParameters()));
                    break;
                case JUMP_IF_TRUE:
                    i = jumpIfTrue(program, i, inst);
                    break;
                case JUMP_IF_FALSE:
                    i = jumpIfFalse(program, i, inst);
                    break;
                case LESS_THEN:
                    lessThen(program, i, inst);
                    i = i.add(BigInteger.ONE).add(BigInteger.valueOf(opcode.getNumberOfParameters()));
                    break;
                case EQUALS:
                    equals(program, i, inst);
                    i = i.add(BigInteger.ONE).add(BigInteger.valueOf(opcode.getNumberOfParameters()));
                    break;
                case RELATIVE_BASE:
                    adjustsRelativeBase(program, i, inst);
                    i = i.add(BigInteger.ONE).add(BigInteger.valueOf(opcode.getNumberOfParameters()));
                    break;
                default:
                    throw new RuntimeException("Cannot process opcode: " + opcode);
            }
            inst = new Instruction(get(program, i));
            opcode = inst.getOpcode();
        }
        return result;
    }

    private void adjustsRelativeBase(Map<BigInteger, BigInteger> program, BigInteger index, Instruction inst) {
        BigInteger value1 = getParam1(program, index, inst);
        relativeBase = relativeBase.add(value1);
    }

    private void equals(Map<BigInteger, BigInteger> program, BigInteger index, Instruction inst) {
        BigInteger value1 = getParam1(program, index, inst);
        BigInteger value2 = getParam2(program, index, inst);
        BigInteger value3 = get(program, index.add(BigInteger.valueOf(3)));
        if (value1.compareTo(value2) == 0) {
            program.put(value3, BigInteger.ONE);
        } else {
            program.put(value3, BigInteger.ZERO);
        }
    }

    private void lessThen(Map<BigInteger, BigInteger> program, BigInteger index, Instruction inst) {
        BigInteger value1 = getParam1(program, index, inst);
        BigInteger value2 = getParam2(program, index, inst);
        BigInteger value3 = get(program, index.add(BigInteger.valueOf(3)));
        if (value1.compareTo(value2) < 0) {
            program.put(value3, BigInteger.ONE);
        } else {
            program.put(value3, BigInteger.ZERO);
        }
    }

    private BigInteger jumpIfFalse(Map<BigInteger, BigInteger> program, BigInteger index, Instruction inst) {
        BigInteger value1 = getParam1(program, index, inst);
        if (value1.equals(BigInteger.ZERO)) {
            return getParam2(program, index, inst);
        }
        return index.add(BigInteger.valueOf(3));
    }

    private BigInteger jumpIfTrue(Map<BigInteger, BigInteger> program, BigInteger index, Instruction inst) {
        BigInteger value1 = getParam1(program, index, inst);
        if (!value1.equals(BigInteger.ZERO)) {
            return getParam2(program, index, inst);
        }
        return index.add(BigInteger.ONE).add(BigInteger.valueOf(inst.getOpcode().getNumberOfParameters()));
    }

    private void output(Map<BigInteger, BigInteger> program, BigInteger index, Instruction inst) {
        BigInteger value1 = getParam1(program, index, inst);
        System.err.println(value1);
        result = value1;
    }

    private void input(Map<BigInteger, BigInteger> program, BigInteger index, Instruction inst) {
        BigInteger value1 = getParam1(program, index, inst);
        program.put(value1, inputValue);
    }

    private void add(Map<BigInteger, BigInteger> program, BigInteger index, Instruction inst) {
        BigInteger value1 = getParam1(program, index, inst);
        BigInteger value2 = getParam2(program, index, inst);
        BigInteger value3 = get(program, index.add(BigInteger.valueOf(3)));

        program.put(value3, value1.add(value2));
    }

    private BigInteger getParam1(Map<BigInteger, BigInteger> program, BigInteger index, Instruction inst) {
        return getParam(program, get(program, index.add(BigInteger.ONE)), inst.getParameterMode1());
    }

    private BigInteger getParam2(Map<BigInteger, BigInteger> program, BigInteger index, Instruction inst) {
        return getParam(program, get(program, index.add(BigInteger.TWO)), inst.getParameterMode2());
    }

    private BigInteger getParam3(Map<BigInteger, BigInteger> program, BigInteger index, Instruction inst) {
        return getParam(program, get(program, index.add(BigInteger.valueOf(3))), inst.getParameterMode3());
    }

    private BigInteger getParam(Map<BigInteger, BigInteger> program, BigInteger param, ParameterMode parameterMode) {
        switch (parameterMode) {
            case IMMEDIATE:
                return param;
            case POSITION:
                return get(program, param);
            case RELATIVE:
                return get(program, param.add(relativeBase));
            default:
                throw new RuntimeException("unhandled parametermode: " + parameterMode);
        }
    }

    private void multiply(Map<BigInteger, BigInteger> program, BigInteger index, Instruction inst) {
        BigInteger value1 = getParam1(program, index, inst);
        BigInteger value2 = getParam2(program, index, inst);
        BigInteger value3 = get(program, index.add(BigInteger.valueOf(3)));

        program.put(value3, value1.multiply(value2));
    }

    private BigInteger get(Map<BigInteger, BigInteger> program, BigInteger i) {
        if (program.containsKey(i)) {
            return program.get(i);
        }
        return BigInteger.valueOf(0);
    }

}
