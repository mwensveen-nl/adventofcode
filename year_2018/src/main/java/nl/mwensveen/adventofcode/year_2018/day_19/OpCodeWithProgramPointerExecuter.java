package nl.mwensveen.adventofcode.year_2018.day_19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class OpCodeWithProgramPointerExecuter {
    private static final List<OpCode> opcodes = Arrays.asList(new ADDI(), new ADDR(), new BANI(), new BANR(), new BORI(), new BORR(), new EQIR(), new EQRI(),
            new EQRR(), new GTIR(), new GTRI(), new GTRR(), new MULI(), new MULR(), new SETI(), new SETR());
    private static final String REGEX_OPCODE = "((?:[a-z][a-z]+))";
    private static final Pattern PATTERN_OPCODE = Pattern.compile(REGEX_OPCODE, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    private static final String REGEX_NUMBERS = ".*?(\\d+).*?(\\d+).*?(\\d+)";
    private static final Pattern PATTERN_NUMBERS = Pattern.compile(REGEX_NUMBERS, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    private static final String REGEX_INSTRUCTION_POINTER_REGISTER = ".*?(\\d+)";
    private static final Pattern PATTERN_INSTRUCTION_POINTER_REGISTER =
            Pattern.compile(REGEX_INSTRUCTION_POINTER_REGISTER, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

    private String programPointerInput;
    private List<String> input;
    private List<Instruction> instructions = new ArrayList();
    private Integer ipRegister;
    private List<Integer> registers = new ArrayList<>();
    private Integer instructionPointer = 0;

    public OpCodeWithProgramPointerExecuter(String programPointerInput, List<String> input) {
        this.programPointerInput = programPointerInput;
        ipRegister = maakInstructionPointerRegistryNumber(programPointerInput);
        this.input = input;
        input.stream().forEach(s -> instructions.add(makeOpcodeInstruction(s)));
        IntStream.range(0, 6).forEach(i -> registers.add(Integer.valueOf(0)));
    }

    public Integer executeInstructions(int valueRegistry0) {
        registers.set(0, valueRegistry0);
        while (instructionPointer < instructions.size()) {
            registers.set(ipRegister, instructionPointer);
            Instruction instruction = instructions.get(instructionPointer);
            // System.out.print(instructionPointer + " : " + registers);
            registers = instruction.getOpCode().perform(registers, instruction.getNumbers());
            instructionPointer = registers.get(ipRegister) + 1;
            // System.out.println(" " + instruction.getOpCode() + " " + instruction.getNumbers() + " : " + registers);
        }
        return registers.get(0);
    }

    private Integer maakInstructionPointerRegistryNumber(String s) {
        Matcher m = PATTERN_INSTRUCTION_POINTER_REGISTER.matcher(s);
        if (m.find()) {
            return Integer.parseInt(m.group(1));
        }
        return null;
    }

    private Instruction makeOpcodeInstruction(String s) {
        OpCode opcode = null;
        List<Integer> list = null;
        Matcher m = PATTERN_OPCODE.matcher(s);
        if (m.find()) {
            opcode = findOpcode(m.group(1));
        }
        m = PATTERN_NUMBERS.matcher(s);
        if (m.find()) {
            Integer i0 = Integer.parseInt(m.group(1));
            Integer i1 = Integer.parseInt(m.group(2));
            Integer i2 = Integer.parseInt(m.group(3));
            list = Arrays.asList(i0, i1, i2);
        }
        return new Instruction(opcode, list);
    }

    private OpCode findOpcode(String name) {
        return opcodes.stream().filter(o -> o.name().equalsIgnoreCase(name)).findFirst().get();
    }

}
