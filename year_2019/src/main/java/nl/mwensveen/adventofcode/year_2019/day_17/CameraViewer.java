package nl.mwensveen.adventofcode.year_2019.day_17;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.math.BigInteger;
import java.util.List;

public class CameraViewer {
    private final IntcodeProgram intcodeProgram;

    public CameraViewer(IntcodeProgram intcodeProgram) {
        super();
        this.intcodeProgram = intcodeProgram;
    }

    public Table<Integer, Integer, OutputView> view() {
        Table<Integer, Integer, OutputView> table = HashBasedTable.create();

        int x = 0;
        int y = 0;
        List<BigInteger> output = intcodeProgram.process(0, null);

        while (!output.isEmpty()) {
            OutputView outputView = OutputView.valueOf(output.get(0).intValue());
            if (outputView == OutputView.NEW_LINE) {
                x = 0;
                y++;
                System.out.println();
            } else {
                table.put(x, y, outputView);
                x++;
                System.out.print(outputView.getSymbol());
            }
            output = intcodeProgram.process(0, null);
        }
        return table;
    }
}
