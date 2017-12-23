package nl.mwensveen.adventofcode.year_2017.day_23;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.primitives.Longs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CoprocessorConflagration {
    private List<Instruction> instructions;
    private Map<String, Long> registers = new HashMap<>();

    public CoprocessorConflagration(String input) {
        instructions = toInstructionList(input);
    }

    public int calculate() {
        int i = 0;
        int counter = 0;
        while (true) {
            System.out.println(i);
            Instruction instruction = instructions.get(i);
            System.out.println(instruction);
            Long value = null;
            Long instructionValue = null;
            switch (instruction.getCommand()) {
                case SET:
                    instructionValue = getValueOrUseLong(instruction.getValue());
                    setValueOfRegister(instruction.getRegister(), instructionValue);
                    break;
                case DECREASE:
                    value = getValueFromRegister(instruction.getRegister());
                    instructionValue = getValueOrUseLong(instruction.getValue());
                    setValueOfRegister(instruction.getRegister(), value.longValue() - instructionValue.longValue());
                    break;
                case MULTIPLY:
                    value = getValueFromRegister(instruction.getRegister());
                    instructionValue = getValueOrUseLong(instruction.getValue());
                    setValueOfRegister(instruction.getRegister(), value.longValue() * instructionValue.longValue());
                    counter++;
                    break;
                case JUMP:
                    value = getValueOrUseLong(instruction.getRegister());
                    if (value != Long.valueOf(0)) {
                        instructionValue = getValueOrUseLong(instruction.getValue());
                        i = i + instructionValue.intValue();
                        if (i >= instructions.size()) {
                            System.out.println();
                            return counter;
                        }
                        i--;
                    }
                    break;
                default:
                    throw new RuntimeException("Instruction not implemented  " + instruction);
            }
            i++;
        }
    }

    private Instruction toInstruction(String input) {
        Iterable<String> split = Splitter.on(" ")
            .trimResults()
            .omitEmptyStrings()
            .split(input);
        ArrayList<String> newArrayList = Lists.newArrayList(split);
        return new Instruction(InstructionCommand.find(newArrayList.get(0)), newArrayList.get(1), newArrayList.size() > 2 ? newArrayList.get(2) : null);
    }

    private List<Instruction> toInstructionList(String in) {
        Iterable<String> split = Splitter.on("\n")
            .trimResults()
            .omitEmptyStrings()
            .split(in);
        ArrayList<String> newArrayList = Lists.newArrayList(split);
        return newArrayList.stream().map(s -> toInstruction(s)).collect(Collectors.toList());
    }

    private Long getValueOrUseLong(String value) {
        Long Long = Longs.tryParse(value);
        if (Long != null) {
            System.out.print("\tuse : " + value);

            return Long;
        }
        return getValueFromRegister(value);
    }

    private void setValueOfRegister(String register, Long value) {
        registers.put(register, value);
        System.out.print("\treg : " + register + " => " + value);

    }

    private Long getValueFromRegister(String register) {
        Long i = registers.get(register);
        if (i == null) {
            System.out.print("\treg : " + register + " = " + 0);
            return Long.valueOf(0);
        }
        System.out.print("\treg : " + register + " = " + i);
        return i;
    }
}
