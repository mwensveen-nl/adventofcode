package nl.mwensveen.adventofcode.year_2019.day_11;

import com.codepoetics.protonpack.StreamUtils;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;

public class IntcodeProgram {
    private static final BigInteger ONE = BigInteger.ONE;
    private static final BigInteger TWO = BigInteger.TWO;
    private static final BigInteger THREE = BigInteger.valueOf(3);
    private BigInteger inputValue;
    private BigInteger relativeBase = BigInteger.ZERO;
    private Map<BigInteger, BigInteger> program;
    private OptionalInt numberOfOutput;
    private BigInteger i = BigInteger.valueOf(0);

    public IntcodeProgram(List<BigInteger> programList, OptionalInt numberOfOutput) {
        this.numberOfOutput = numberOfOutput;
        program = new HashMap<>();
        StreamUtils.zipWithIndex(programList.stream()).forEach(c -> program.put(BigInteger.valueOf(c.getIndex()), c.getValue()));
    }

    public List<BigInteger> process(int input) {
        inputValue = BigInteger.valueOf(input);
        List<BigInteger> result = new ArrayList<>();

        Instruction inst = new Instruction(get(i));
        Opcode opcode = inst.getOpcode();
        while (Opcode.STOP != opcode) {
            switch (opcode) {
                case ADD:
                    add(i, inst);
                    i = jumpIndex(i, opcode);
                    break;
                case MULTIPLY:
                    multiply(i, inst);
                    i = jumpIndex(i, opcode);
                    break;
                case INPUT:
                    input(i, inst);
                    i = jumpIndex(i, opcode);
                    break;
                case OUTPUT:
                    result.add(output(i, inst));
                    i = jumpIndex(i, opcode);
                    // System.out.println(result);
                    if (numberOfOutput.isPresent() && result.size() == numberOfOutput.getAsInt()) {
                        return result;
                    }
                    break;
                case JUMP_IF_TRUE:
                    i = jumpIfTrue(i, inst);
                    break;
                case JUMP_IF_FALSE:
                    i = jumpIfFalse(i, inst);
                    break;
                case LESS_THEN:
                    lessThen(i, inst);
                    i = jumpIndex(i, opcode);
                    break;
                case EQUALS:
                    equals(i, inst);
                    i = jumpIndex(i, opcode);
                    break;
                case RELATIVE_BASE:
                    adjustsRelativeBase(i, inst);
                    i = jumpIndex(i, opcode);
                    break;
                default:
                    throw new RuntimeException("Cannot process opcode: " + opcode);
            }
            inst = new Instruction(get(i));
            opcode = inst.getOpcode();
        }
        return result;
    }

    private BigInteger jumpIndex(BigInteger i, Opcode opcode) {
        return i.add(ONE).add(BigInteger.valueOf(opcode.getNumberOfParameters()));
    }

    private void adjustsRelativeBase(BigInteger index, Instruction inst) {
        BigInteger value1 = getInputParam1(index, inst);
        relativeBase = relativeBase.add(value1);
    }

    private void equals(BigInteger index, Instruction inst) {
        BigInteger value1 = getInputParam1(index, inst);
        BigInteger value2 = getInputParam2(index, inst);
        BigInteger value3 = getOutputParam3(index, inst);
        // BigInteger value3 = get(program, index.add(THREE));
        BigInteger value = null;
        if (value1.compareTo(value2) == 0) {
            value = ONE;
        } else {
            value = BigInteger.ZERO;
        }
        program.put(value3, value);
    }

    private void lessThen(BigInteger index, Instruction inst) {
        BigInteger value1 = getInputParam1(index, inst);
        BigInteger value2 = getInputParam2(index, inst);
        BigInteger value3 = getOutputParam3(index, inst);
        // BigInteger value3 = get(program, index.add(THREE));
        BigInteger value = null;
        if (value1.compareTo(value2) < 0) {
            value = ONE;
        } else {
            value = BigInteger.ZERO;
        }
        program.put(value3, value);
    }

    private BigInteger jumpIfFalse(BigInteger index, Instruction inst) {
        BigInteger value1 = getInputParam1(index, inst);
        if (value1.equals(BigInteger.ZERO)) {
            return getInputParam2(index, inst);
        }
        return jumpIndex(index, inst.getOpcode());
    }

    private BigInteger jumpIfTrue(BigInteger index, Instruction inst) {
        BigInteger value1 = getInputParam1(index, inst);
        if (!value1.equals(BigInteger.ZERO)) {
            return getInputParam2(index, inst);
        }
        return jumpIndex(index, inst.getOpcode());
    }

    private BigInteger output(BigInteger index, Instruction inst) {
        BigInteger value1 = getInputParam1(index, inst);
        // System.err.println("Output " + value1);
        return value1;
    }

    private void input(BigInteger index, Instruction inst) {
        BigInteger value1 = getOutputParam1(index, inst);
        program.put(value1, inputValue);
        // System.err.println("Input pos " + value1 + " -> " + inputValue);
    }

    private void add(BigInteger index, Instruction inst) {
        BigInteger value1 = getInputParam1(index, inst);
        BigInteger value2 = getInputParam2(index, inst);
        BigInteger value3 = getOutputParam3(index, inst);
        // BigInteger value3 = get(program, index.add(THREE));

        BigInteger value = value1.add(value2);
        program.put(value3, value);
        // System.err.println("Add pos " + value3 + " -> " + value);
    }

    private void multiply(BigInteger index, Instruction inst) {
        BigInteger value1 = getInputParam1(index, inst);
        BigInteger value2 = getInputParam2(index, inst);
        BigInteger value3 = getOutputParam3(index, inst);
        // BigInteger value3 = get(program, index.add(THREE));

        BigInteger value = value1.multiply(value2);
        program.put(value3, value);
        // System.err.println("Multiply pos " + value3 + " -> " + value);
    }

    private BigInteger getInputParam1(BigInteger index, Instruction inst) {
        return getInputParam(get(index.add(ONE)), inst.getParameterMode1());
    }

    private BigInteger getOutputParam1(BigInteger index, Instruction inst) {
        return getOutputParam(inst.getParameterMode1(), index.add(ONE));
    }

    private BigInteger getOutputParam(ParameterMode parameterMode, BigInteger i) {
        BigInteger param = get(i);
        if (parameterMode.equals(ParameterMode.RELATIVE)) {
            return param.add(relativeBase);
        }
        return param;
    }

    private BigInteger getInputParam2(BigInteger index, Instruction inst) {
        return getInputParam(get(index.add(TWO)), inst.getParameterMode2());
    }

    private BigInteger getOutputParam3(BigInteger index, Instruction inst) {
        return getOutputParam(inst.getParameterMode3(), index.add(THREE));
    }

    private BigInteger getInputParam(BigInteger param, ParameterMode parameterMode) {
        switch (parameterMode) {
            case IMMEDIATE:
                return param;
            case POSITION:
                return get(param);
            case RELATIVE:
                return get(param.add(relativeBase));
            default:
                throw new RuntimeException("unhandled parametermode: " + parameterMode);
        }
    }

    private BigInteger get(BigInteger i) {
        if (program.containsKey(i)) {
            return program.get(i);
        }
        return BigInteger.ZERO;
    }

}
