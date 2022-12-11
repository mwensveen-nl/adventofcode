package nl.mwensveen.adventofcode.year_2022.day_11;

public record Operation(String operator, String operand) {

    public Integer calculate(Integer old) {
        int foo = 0;
        if (isNumeric(operand)) {
            foo = Integer.parseInt(operand);
        } else {
            foo = old;
        }
        return switch (operator) {
            case "*" -> old * foo;
            case "+" -> old + foo;
            default -> throw new IllegalArgumentException("Unexpected value: " + operator);
        };
    }

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
