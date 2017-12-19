package nl.mwensveen.adventofcode.year_2017.day_18;

import com.google.common.primitives.Longs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RecursiveTask;

public class Program extends RecursiveTask<Integer> {

    private static final long serialVersionUID = -6402758295313457796L;
    private Map<String, Long> registers = new HashMap<>();
    private List<Instruction> instructions;
    private Program other;
    private String name;

    private List<Long> queue = new ArrayList<>();
    private boolean waiting = false;
    private boolean ended = false;

    public void setOnQueue(Long value) {
        synchronized (queue) {
            System.out.println(name + " get value " + value);
            queue.add(value);
        }
    }

    private Long getFromQueue() {
        while (true) {
            synchronized (queue) {
                if (queue.size() > 0) {
                    waiting = false;
                    Long v = queue.get(0);
                    queue.remove(0);
                    return v;
                }
                waiting = true;
                System.out.println(name + " waiting");
                if (other.isWaiting() || other.isEnded()) {
                    ended = true;
                    return null;
                }
            }
        }
    }

    public boolean isWaiting() {
        return waiting && queue.size() == 0;
    }

    public boolean isEnded() {
        return ended;
    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public void setOther(Program other) {
        this.other = other;
    }

    @Override
    protected Integer compute() {
        int i = 0;
        int sndCounter = 0;
        while (true) {
            // System.out.println(name + " " + i);
            Instruction instruction = instructions.get(i);
            System.out.println(name + " " + instruction);
            Long value = null;
            Long instructionValue = null;
            switch (instruction.getCommand()) {
                case SND:
                    value = getValueOrUseLong(instruction.getRegister());
                    System.out.println(name + " sending value " + value);
                    other.setOnQueue(value);
                    sndCounter++;
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
                    value = getFromQueue();
                    if (value == null) {
                        System.out.println(name + " cannot RCV");
                        return Integer.valueOf(sndCounter);
                    }
                    setValueOfRegister(instruction.getRegister(), value);
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
            if (i >= instructions.size()) {
                ended = true;
                System.out.println(name + " ended normaly");
                return Integer.valueOf(sndCounter);
            }
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

    public void setName(String name) {
        this.name = name;
        registers.put("p", Long.valueOf(name));
    }

}
