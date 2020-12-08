package nl.mwensveen.adventofcode.year_2020.day_08;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BootCodeRunner {

    public Result runBootCode(List<ProgramStatement> programStatements) {
        Result result = new Result();
        boolean done = false;
        int accumulator = 0;
        int i = 0;
        Set<Integer> run = new HashSet<>();
        while (!done) {
            if (run.contains(i)) {
                done = true;
                result.setInfiniteLoop(true);
            } else {
                ProgramStatement programStatement = programStatements.get(i);
                run.add(i);
                switch (programStatement.getInstruction()) {
                    case ACC:
                        accumulator += programStatement.getArgument();
                        i++;
                        break;
                    case NOP:
                        i++;
                        break;
                    case JMP:
                        i += programStatement.getArgument();
                        break;
                }
                if (i >= programStatements.size()) {
                    done = true;
                    result.setInfiniteLoop(false);
                }
            }
        }
        result.setAccumulator(accumulator);
        return result;
    }

    public Result findWrongStatement(List<ProgramStatement> programStatements) {
        Result result = new Result();
        result.setInfiniteLoop(true);
        int i = 0;
        while (result.isInfiniteLoop()) {
            ProgramStatement orig = programStatements.get(i);
            switch (orig.getInstruction()) {
                case ACC:
                    break;
                case JMP:
                    programStatements.set(i, ProgramStatement.builder().withArgument(orig.getArgument()).withInstruction(Instruction.NOP).build());
                    result = runBootCode(programStatements);
                    programStatements.set(i, orig);
                    break;
                case NOP:
                    programStatements.set(i, ProgramStatement.builder().withArgument(orig.getArgument()).withInstruction(Instruction.JMP).build());
                    result = runBootCode(programStatements);
                    programStatements.set(i, orig);
            }
            i++;
        }
        return result;
    }

    public static class Result {
        private boolean infiniteLoop;
        private int accumulator;

        public boolean isInfiniteLoop() {
            return infiniteLoop;
        }

        public void setInfiniteLoop(boolean infiniteLoop) {
            this.infiniteLoop = infiniteLoop;
        }

        public int getAccumulator() {
            return accumulator;
        }

        public void setAccumulator(int accumulator) {
            this.accumulator = accumulator;
        }
    }

}
