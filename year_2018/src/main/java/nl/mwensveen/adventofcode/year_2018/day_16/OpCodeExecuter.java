package nl.mwensveen.adventofcode.year_2018.day_16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OpCodeExecuter {
    private static final List<OpCode> opcodes = Arrays.asList(new ADDI(), new ADDR(), new BANI(), new BANR(), new BORI(), new BORR(), new EQIR(), new EQRI(),
            new EQRR(), new GTIR(), new GTRI(), new GTRR(), new MULI(), new MULR(), new SETI(), new SETR());
    private static final String REGEX_BEFORE_AFTER = ".*?(\\d+).*?(\\d+).*?(\\d+).*?(\\d+)";;
    private static final Pattern PATTERN_BEFORE_AFTER = Pattern.compile(REGEX_BEFORE_AFTER, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    private static final String REGEX_INSTRUCTION = "(\\d+).*?(\\d+).*?(\\d+).*?(\\d+)";;
    private static final Pattern PATTERN_INSTRUCTION = Pattern.compile(REGEX_INSTRUCTION, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    private List<String> input;
    private Map<Integer, List<OpCode>> opCodesNumbers = new HashMap<>();

    public OpCodeExecuter(List<String> input) {
        this.input = input;
        IntStream.range(0, opcodes.size()).forEach(i -> opCodesNumbers.put(i, new ArrayList(opcodes)));
    }

    public long find3OrMore() {
        return IntStream.range(0, input.size() / 4).map(i -> i * 4).filter(i -> check(input.get(i), input.get(i + 1), input.get(i + 2)) >= 3).count();
    }

    public Integer findRegister0(List<String> input2) {

        IntStream.range(0, input.size() / 4).map(i -> i * 4).forEach(i -> check(input.get(i), input.get(i + 1), input.get(i + 2)));
        while (opCodesNumbers.values().stream().filter(ops -> ops.size() == 1).peek(ops -> {
            System.out.println(ops);
            reducePosibilities(ops);
        }).count() < opcodes.size())
            ;

        List<Integer> registers = Arrays.asList(0, 0, 0, 0);
        List<List<Integer>> instructions = input2.stream().map(s -> extract(s, PATTERN_INSTRUCTION)).collect(Collectors.toList());
        for (List<Integer> instrucion : instructions) {
            registers = opCodesNumbers.get(instrucion.get(0)).get(0).perform(registers, instrucion);
        }
        return registers.get(0);
    }

    private void execute(List<Integer> registers, List<Integer> inst) {

    }

    private void reducePosibilities(List<OpCode> ocs) {
        opCodesNumbers.values().stream().filter(v -> v.size() != 1).forEach(v -> v.remove(ocs.get(0)));
        System.out.println(opCodesNumbers);
    }

    private int check(String string0, String string1, String string2) {
        List<Integer> regIn = extract(string0, PATTERN_BEFORE_AFTER);
        List<Integer> inst = extract(string1, PATTERN_INSTRUCTION);
        List<Integer> regOut = extract(string2, PATTERN_BEFORE_AFTER);

        return (int) opcodes.stream().filter(oc -> {
            boolean match = regOut.equals(oc.perform(regIn, inst));
            reducePosibilities(inst, oc, match);
            return match;
        }).count();
    }

    private void reducePosibilities(List<Integer> inst, OpCode oc, boolean match) {
        if (!match) {
            opCodesNumbers.get(inst.get(0)).remove(oc);
        }
    }

    private List<Integer> extract(String input, Pattern p) {
        Matcher m = p.matcher(input);
        if (m.find()) {
            Integer i0 = Integer.parseInt(m.group(1));
            Integer i1 = Integer.parseInt(m.group(2));
            Integer i2 = Integer.parseInt(m.group(3));
            Integer i3 = Integer.parseInt(m.group(4));
            return Arrays.asList(i0, i1, i2, i3);
        }
        return null;
    }
}
