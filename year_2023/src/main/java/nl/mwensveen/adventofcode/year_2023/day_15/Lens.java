package nl.mwensveen.adventofcode.year_2023.day_15;

import java.util.Objects;
import java.util.Optional;

public class Lens {
    private final String label;
    private Optional<Integer> focal;

    public Lens(String label, Integer focalInt) {
        this.label = label;
        this.focal = Optional.of(focalInt);
    }

    public Lens(String label) {
        this.label = label;
        focal = Optional.empty();
    }

    public static Lens parse(String s) {
        if (s.endsWith("-")) {
            return new Lens(s.substring(0, s.length() - 1));
        }

        String[] t = s.split("=");
        return new Lens(t[0], Integer.valueOf(t[1]));
    }

    public Optional<Integer> getFocal() {
        return focal;
    }

    public void setFocal(Optional<Integer> focal) {
        this.focal = focal;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Lens other = (Lens) obj;
        return Objects.equals(label, other.label);
    }

}
