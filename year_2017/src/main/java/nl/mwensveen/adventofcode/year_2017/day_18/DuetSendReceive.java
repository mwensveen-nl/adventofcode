package nl.mwensveen.adventofcode.year_2017.day_18;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class DuetSendReceive extends RecursiveTask<Integer> {

    private List<Instruction> instructions;

    public DuetSendReceive(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    @Override
    protected Integer compute() {
        Program p0 = new Program();
        Program p1 = new Program();
        p0.setInstructions(instructions);
        p1.setInstructions(instructions);
        p0.setOther(p1);
        p1.setOther(p0);
        p0.setName("0");
        p1.setName("1");

        p0.fork();
        Integer result1 = p1.compute();
        Integer result0 = p0.join();

        System.out.println("0: " + result0);
        System.out.println("1: " + result1);

        return result1;

    }
}
