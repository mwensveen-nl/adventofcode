package nl.mwensveen.adventofcode.year_2019.day_16;

import java.util.List;

public class MessageRetreiver {
    private final int NUMBER_OF_DIGETS_TO_RETURN = 8;

    public String retrieve(List<Integer> input, int numberOffset, List<Integer> output) {
        int offset = 0;
        if (numberOffset != 0) {
            StringBuffer foo = new StringBuffer();
            for (int i = 0; i < numberOffset; i++) {
                foo.append(input.get(i));
            }
            offset = Integer.parseInt(foo.toString());
        }

        StringBuffer foo = new StringBuffer();
        for (int i = offset; i < NUMBER_OF_DIGETS_TO_RETURN; i++) {
            foo.append(output.get(i));
        }
        return foo.toString();
    }
}
