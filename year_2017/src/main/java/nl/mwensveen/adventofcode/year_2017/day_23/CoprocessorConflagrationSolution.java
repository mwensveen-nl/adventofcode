package nl.mwensveen.adventofcode.year_2017.day_23;

public class CoprocessorConflagrationSolution {

    private static final String INPUT = "set b 93\n" +
            "set c b\n" +
            "jnz a 2\n" +
            "jnz 1 5\n" +
            "mul b 100\n" +
            "sub b -100000\n" +
            "set c b\n" +
            "sub c -17000\n" +
            "set f 1\n" +
            "set d 2\n" +
            "set e 2\n" +
            "set g d\n" +
            "mul g e\n" +
            "sub g b\n" +
            "jnz g 2\n" +
            "set f 0\n" +
            "sub e -1\n" +
            "set g e\n" +
            "sub g b\n" +
            "jnz g -8\n" +
            "sub d -1\n" +
            "set g d\n" +
            "sub g b\n" +
            "jnz g -13\n" +
            "jnz f 2\n" +
            "sub h -1\n" +
            "set g b\n" +
            "sub g c\n" +
            "jnz g 2\n" +
            "jnz 1 3\n" +
            "sub b -17\n" +
            "jnz 1 -23";

    public static void main(String[] args) {
        CoprocessorConflagration coprocessorConflagration = new CoprocessorConflagration(INPUT);
        System.out.println("Part 1: " + coprocessorConflagration.calculate());

        CoprocessorConflagrationNoDebug coprocessorConflagrationNoDebug = new CoprocessorConflagrationNoDebug();
        System.out.println("Part 2: " + coprocessorConflagrationNoDebug.calculate());
    }

}
