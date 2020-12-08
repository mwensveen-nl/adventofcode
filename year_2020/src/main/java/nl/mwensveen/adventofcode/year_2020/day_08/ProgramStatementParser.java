package nl.mwensveen.adventofcode.year_2020.day_08;

public class ProgramStatementParser {

    public ProgramStatement parse(String input) {
        String[] strings = input.split(" ");
        return ProgramStatement.builder().withInstruction(Instruction.find(strings[0])).withArgument(Integer.valueOf(strings[1])).build();
    }
}
