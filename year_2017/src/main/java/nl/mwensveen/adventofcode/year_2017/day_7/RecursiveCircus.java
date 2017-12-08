package nl.mwensveen.adventofcode.year_2017.day_7;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RecursiveCircus {
    private List<String> lines;

    public RecursiveCircus(String input) {
        lines = toLineList(input);
    }

    public String calculate() {
        return findBottomProgram().getName();
    }

    public int calculateNewWeight() {
        ProgramData bottomProgram = findBottomProgram();
        calculateTotalWeight(bottomProgram);
        System.out.println("unbalanced");
        findUnbalanced(bottomProgram);
        return 0;
    }

    private void findUnbalanced(ProgramData bottomProgram) {
        if (bottomProgram.getAbovePrograms().stream().map(p -> p.getTotalWeight()).collect(Collectors.toSet()).size() > 1) {
            System.out.println(bottomProgram.getName());
            bottomProgram.getAbovePrograms().stream().forEach(p -> System.out.println("  " + p.getName() + "("
                    + p.getWeight() + ")" + " " + p.getTotalWeight()));
            bottomProgram.getAbovePrograms().stream().forEach(p -> findUnbalanced(p));
        }
    }

    private int calculateTotalWeight(ProgramData program) {
        int weightAbove = program.getAbovePrograms().stream().mapToInt(pd -> calculateTotalWeight(pd)).sum();
        program.setTotalWeight(program.getWeight() + weightAbove);
        return program.getTotalWeight();
    }

    private ProgramData findBottomProgram() {
        Map<String, ProgramData> towers = new HashMap<>();
        towers = lines.stream().map(line -> toProgramData(line)).collect(Collectors.toMap(ProgramData::getName, Function.identity()));

        return procesTowers(towers);
    }

    private ProgramData procesTowers(Map<String, ProgramData> towers) {
        if (towers.size() != 1) {
            towers.values().forEach(pd -> procesProgramData(pd, towers));
            return procesTowers(towers.entrySet().stream().filter(es -> {
                System.out.println("* " + es);
                return !es.getValue().isHasProgramUnder();
            })
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue)));
        }
        return towers.values().iterator().next();
    }

    private void procesProgramData(ProgramData pd, Map<String, ProgramData> towers) {
        System.out.println(pd.getName());
        System.out.println(pd.getAboveNames());

        pd.getAboveNames().stream().forEach(name -> {
            ProgramData data = towers.get(name);
            data.setHasProgramUnder(true);
            pd.getAbovePrograms().add(data);
        });
        List<String> list = pd.getAboveNames().stream().filter(name -> !pd.hasAboveProgramWithName(name)).collect(Collectors.toList());
        pd.setAboveNames(list);

        System.out.println("   -> " + pd.getAboveNames());
    }

    private ProgramData toProgramData(String line) {
        Iterable<String> split = Splitter.on(" ")
            .trimResults()
            .omitEmptyStrings()
            .split(line);
        ArrayList<String> data = Lists.newArrayList(split);
        String name = data.get(0);
        String weight = data.get(1);
        List<String> above = new ArrayList<>();
        if (data.size() > 2) {
            IntStream.range(3, data.size()).forEach(i -> above.add(data.get(i)));
        }
        ProgramData programData = new ProgramData(name, toWeight(weight), above);
        System.out.println(programData);
        return programData;
    }

    private int toWeight(String weight) {
        return Integer.valueOf(weight.substring(1, weight.length() - 1)).intValue();
    }

    private List<String> toLineList(String in) {
        Iterable<String> split = Splitter.on("\n")
            .trimResults()
            .omitEmptyStrings()
            .split(in);
        ArrayList<String> newArrayList = Lists.newArrayList(split);
        System.out.println(newArrayList);
        return newArrayList;

    }
}
