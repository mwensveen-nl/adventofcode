package nl.mwensveen.adventofcode.year_2017.day_18;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.primitives.Longs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class Duet {
    private Map<String, Long> registers = new HashMap<>();
    private List<Instruction> instructions;
    private Long lastFrequency;

    public Duet(String input) {
        instructions = toInstructionList(input);
    }

    public Integer calculateSendReceive() {
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        DuetSendReceive duetSendReceive = new DuetSendReceive(instructions);
        return commonPool.invoke(duetSendReceive);
    }

    public Long calculate() {
        int i = 0;
        while (true) {
            System.out.println(i);
            Instruction instruction = instructions.get(i);
            System.out.println(instruction);
            Long value = null;
            Long instructionValue = null;
            switch (instruction.getCommand()) {
                case SND:
                    value = getValueOrUseLong(instruction.getRegister());
                    lastFrequency = value;
                    break;
                case SET:
                    instructionValue = getValueOrUseLong(instruction.getValue());
                    setValueOfRegister(instruction.getRegister(), instructionValue);
                    break;
                case INCREASE:
                    value = getValueFromRegister(instruction.getRegister());
                    instructionValue = getValueOrUseLong(instruction.getValue());
                    setValueOfRegister(instruction.getRegister(), value.longValue() + instructionValue.longValue());
                    break;
                case MULTIPLY:
                    value = getValueFromRegister(instruction.getRegister());
                    instructionValue = getValueOrUseLong(instruction.getValue());
                    setValueOfRegister(instruction.getRegister(), value.longValue() * instructionValue.longValue());
                    break;
                case REMAINDER:
                    value = getValueFromRegister(instruction.getRegister());
                    instructionValue = getValueOrUseLong(instruction.getValue());
                    setValueOfRegister(instruction.getRegister(), value % instructionValue.longValue());
                    break;
                case RCV:
                    value = getValueOrUseLong(instruction.getRegister());
                    if (value != Long.valueOf(0)) {
                        return lastFrequency;
                    }
                    break;
                case JUMP:
                    value = getValueOrUseLong(instruction.getRegister());
                    if (value > Long.valueOf(0)) {
                        instructionValue = getValueOrUseLong(instruction.getValue());
                        i = i + instructionValue.intValue() - 1;
                    }
                    break;
                default:
                    throw new RuntimeException("Instruction not implemented  " + instruction);
            }
            i++;
        }

    }

    private Long getValueOrUseLong(String value) {
        Long Long = Longs.tryParse(value);
        if (Long != null) {
            return Long;
        }
        return getValueFromRegister(value);
    }

    private void setValueOfRegister(String register, Long value) {
        registers.put(register, value);
    }

    private Long getValueFromRegister(String register) {
        Long i = registers.get(register);
        if (i == null) {
            return Long.valueOf(0);
        }
        return i;
    }

    private Instruction toInstruction(String input) {
        Iterable<String> split = Splitter.on(" ")
            .trimResults()
            .omitEmptyStrings()
            .split(input);
        ArrayList<String> newArrayList = Lists.newArrayList(split);
        System.out.println(input);
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
}
