package nl.mwensveen.adventofcode.year_2019.day_07;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AmplifierSeries {
    List<Integer> phaseSettings;
    private int input;
    private List<Integer> programCode;

    public AmplifierSeries(List<Integer> phaseSettings, int input, List<Integer> programCode) {
        this.phaseSettings = phaseSettings;
        this.input = input;
        this.programCode = programCode;
    }

    public int caluclateThrusterInput() {
        Integer output = input;
        for (Integer ps : phaseSettings) {
            IntcodeProgram prog = new IntcodeProgram(ps.intValue(), programCode.stream().collect(Collectors.toList()));
            output = prog.process(false, output);
        }
        return output;
    }

    public int caluclateThrusterInputWithFeedback() {
        Integer output = input;
        // init programs
        List<IntcodeProgram> progs = new ArrayList<>();
        for (Integer ps : phaseSettings) {
            IntcodeProgram prog = new IntcodeProgram(ps.intValue(), programCode.stream().collect(Collectors.toList()));
            progs.add(prog);
        }
        // repeat until exit of final prog
        boolean exited = false;
        while (!exited) {
            for (IntcodeProgram prog : progs) {
                output = prog.process(true, output);
                exited = prog.isExit();
            }
        }
        return output;
    }

}
