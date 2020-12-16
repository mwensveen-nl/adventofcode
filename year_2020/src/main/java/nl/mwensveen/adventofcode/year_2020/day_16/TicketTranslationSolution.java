package nl.mwensveen.adventofcode.year_2020.day_16;

import java.util.List;
import nl.mwensveen.adventofcode.year_2020.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2020.FileReadHelper;

public class TicketTranslationSolution extends AbstractTimedSolution {
    private Input input;

    public static void main(String[] args) {
        new TicketTranslationSolution().run();
    }

    @Override
    protected void init() {
        List<String> strings = FileReadHelper.readLinesAsStrings("Day_16.txt");
        input = new InputParser().parse(strings);
    }

    @Override
    protected void part1() {
        TicketsProcessor ticketsProcessor = new TicketsProcessor();
        long result = ticketsProcessor.process(input.getNearbyTickets(), input.getFields());
        System.out.println("Ticket scanning error rate = " + result);

    }

    @Override
    protected void part2() {
        // TODO Auto-generated method stub

    }

}
