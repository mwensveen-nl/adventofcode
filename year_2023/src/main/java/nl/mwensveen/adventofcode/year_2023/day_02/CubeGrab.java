package nl.mwensveen.adventofcode.year_2023.day_02;

public record CubeGrab(int blue, int red, int green) {

    public boolean isAllowed(CubeGrab max) {
        return blue <= max.blue && red <= max.red && green <= max.green;
    }

    public CubeGrab max(CubeGrab max) {
        return new CubeGrab(Math.max(blue, max.blue), Math.max(red, max.red), Math.max(green, max.green));
    }

    public static CubeGrab parse(String grab) {
        int red = 0, blue = 0, green = 0;
        String[] colors = grab.split(",");
        for (int j = 0; j < colors.length; j++) {
            String colorgrab = colors[j].trim();
            String[] s2 = colorgrab.split(" ");
            String color = s2[1];
            if (color.equals("red")) {
                red = Integer.valueOf(s2[0]);
            }
            if (color.equals("blue")) {
                blue = Integer.valueOf(s2[0]);
            }
            if (color.equals("green")) {
                green = Integer.valueOf(s2[0]);
            }
        }
        return new CubeGrab(blue, red, green);
    }
}
