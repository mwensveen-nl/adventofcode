package nl.mwensveen.adventofcode.year_2025.day_10;

import java.util.List;

public class MachineParser {
    private IndicatorLightParser indicatorLightParser = new IndicatorLightParser();
    private ButtonParser buttonParser = new ButtonParser();

    public Machine parse(String input) {
        int buttonStart = input.indexOf("(");
        int joltageStart = input.indexOf("{");
        IndicatorLight indicatorLight = indicatorLightParser.parse(input.substring(0, buttonStart - 1).trim());
        List<Button> buttons = buttonParser.parse(input.substring(buttonStart, joltageStart - 1).trim());
        return new Machine(indicatorLight, buttons);
    }
}
