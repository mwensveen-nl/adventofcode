package nl.mwensveen.adventofcode.year_2019.day_09;

import com.codepoetics.protonpack.StreamUtils;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntcodeProgram {
    private static final BigInteger ONE = BigInteger.ONE;
    private static final BigInteger TWO = BigInteger.TWO;
    private static final BigInteger THREE = BigInteger.valueOf(3);
    private final BigInteger inputValue;
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
                    i = jumpIndex(i, opcode);
                    break;
                case MULTIPLY:
                    multiply(program, i, inst);
                    i = jumpIndex(i, opcode);
                    break;
                case INPUT:
                    input(program, i, inst);
                    i = jumpIndex(i, opcode);
                    break;
                case OUTPUT:
                    result = output(program, i, inst);
                    i = jumpIndex(i, opcode);
                    break;
                case JUMP_IF_TRUE:
                    i = jumpIfTrue(program, i, inst);
                    break;
                case JUMP_IF_FALSE:
                    i = jumpIfFalse(program, i, inst);
                    break;
                case LESS_THEN:
                    lessThen(program, i, inst);
                    i = jumpIndex(i, opcode);
                    break;
                case EQUALS:
                    equals(program, i, inst);
                    i = jumpIndex(i, opcode);
                    break;
                case RELATIVE_BASE:
                    adjustsRelativeBase(program, i, inst);
                    i = jumpIndex(i, opcode);
                    break;
                default:
                    throw new RuntimeException("Cannot process opcode: " + opcode);
            }
            inst = new Instruction(get(program, i));
            opcode = inst.getOpcode();
        }
        return result;
    }

    private BigInteger jumpIndex(BigInteger i, Opcode opcode) {
        return i.add(ONE).add(BigInteger.valueOf(opcode.getNumberOfParameters()));
    }

    private void adjustsRelativeBase(Map<BigInteger, BigInteger> program, BigInteger index, Instruction inst) {
        BigInteger value1 = getInputParam1(program, index, inst);
        relativeBase = relativeBase.add(value1);
    }

    private void equals(Map<BigInteger, BigInteger> program, BigInteger index, Instruction inst) {
        BigInteger value1 = getInputParam1(program, index, inst);
        BigInteger value2 = getInputParam2(program, index, inst);
        BigInteger value3 = getOutputParam3(program, index, inst);
        // BigInteger value3 = get(program, index.add(THREE));
        BigInteger value = null;
        if (value1.compareTo(value2) == 0) {
            value = ONE;
        } else {
            value = BigInteger.ZERO;
        }
        program.put(value3, value);
    }

    private void lessThen(Map<BigInteger, BigInteger> program, BigInteger index, Instruction inst) {
        BigInteger value1 = getInputParam1(program, index, inst);
        BigInteger value2 = getInputParam2(program, index, inst);
        BigInteger value3 = getOutputParam3(program, index, inst);
        // BigInteger value3 = get(program, index.add(THREE));
        BigInteger value = null;
        if (value1.compareTo(value2) < 0) {
            value = ONE;
        } else {
            value = BigInteger.ZERO;
        }
        program.put(value3, value);
    }

    private BigInteger jumpIfFalse(Map<BigInteger, BigInteger> program, BigInteger index, Instruction inst) {
        BigInteger value1 = getInputParam1(program, index, inst);
        if (value1.equals(BigInteger.ZERO)) {
            return getInputParam2(program, index, inst);
        }
        return jumpIndex(index, inst.getOpcode());
    }

    private BigInteger jumpIfTrue(Map<BigInteger, BigInteger> program, BigInteger index, Instruction inst) {
        BigInteger value1 = getInputParam1(program, index, inst);
        if (!value1.equals(BigInteger.ZERO)) {
            return getInputParam2(program, index, inst);
        }
        return jumpIndex(index, inst.getOpcode());
    }

    private BigInteger output(Map<BigInteger, BigInteger> program, BigInteger index, Instruction inst) {
        BigInteger value1 = getInputParam1(program, index, inst);
        System.err.println("Output " + value1);
        return value1;
    }

    private void input(Map<BigInteger, BigInteger> program, BigInteger index, Instruction inst) {
        BigInteger value1 = getOutputParam1(program, index, inst);
        program.put(value1, inputValue);
        // System.err.println("Input pos " + value1 + " -> " + inputValue);
    }

    private void add(Map<BigInteger, BigInteger> program, BigInteger index, Instruction inst) {
        BigInteger value1 = getInputParam1(program, index, inst);
        BigInteger value2 = getInputParam2(program, index, inst);
        BigInteger value3 = getOutputParam3(program, index, inst);
        // BigInteger value3 = get(program, index.add(THREE));

        BigInteger value = value1.add(value2);
        program.put(value3, value);
        // System.err.println("Add pos " + value3 + " -> " + value);
    }

    private void multiply(Map<BigInteger, BigInteger> program, BigInteger index, Instruction inst) {
        BigInteger value1 = getInputParam1(program, index, inst);
        BigInteger value2 = getInputParam2(program, index, inst);
        BigInteger value3 = getOutputParam3(program, index, inst);
        // BigInteger value3 = get(program, index.add(THREE));

        BigInteger value = value1.multiply(value2);
        program.put(value3, value);
        // System.err.println("Multiply pos " + value3 + " -> " + value);
    }

    private BigInteger getInputParam1(Map<BigInteger, BigInteger> program, BigInteger index, Instruction inst) {
        return getInputParam(program, get(program, index.add(ONE)), inst.getParameterMode1());
    }

    private BigInteger getOutputParam1(Map<BigInteger, BigInteger> program, BigInteger index, Instruction inst) {
        return getOutputParam(program, inst.getParameterMode1(), index.add(ONE));
    }

    private BigInteger getOutputParam(Map<BigInteger, BigInteger> program, ParameterMode parameterMode, BigInteger i) {
        BigInteger param = get(program, i);
        if (parameterMode.equals(ParameterMode.RELATIVE)) {
            return param.add(relativeBase);
        }
        return param;
    }

    private BigInteger getInputParam2(Map<BigInteger, BigInteger> program, BigInteger index, Instruction inst) {
        return getInputParam(program, get(program, index.add(TWO)), inst.getParameterMode2());
    }

    private BigInteger getOutputParam3(Map<BigInteger, BigInteger> program, BigInteger index, Instruction inst) {
        return getOutputParam(program, inst.getParameterMode3(), index.add(THREE));
    }

    private BigInteger getInputParam(Map<BigInteger, BigInteger> program, BigInteger param, ParameterMode parameterMode) {
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

    private BigInteger get(Map<BigInteger, BigInteger> program, BigInteger i) {
        if (program.containsKey(i)) {
            return program.get(i);
        }
        return BigInteger.ZERO;
    }

}
