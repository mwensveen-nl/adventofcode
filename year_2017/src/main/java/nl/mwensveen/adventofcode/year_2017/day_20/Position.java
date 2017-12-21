package nl.mwensveen.adventofcode.year_2017.day_20;

import com.google.common.base.Objects;
import java.math.BigInteger;

public class Position {
    private BigInteger x;
    private BigInteger y;
    private BigInteger z;

    public Position(BigInteger x, BigInteger y, BigInteger z) {
        super();
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (!getClass().equals(other.getClass())) {
            return false;
        }
        Position castOther = (Position) other;
        return Objects.equal(x, castOther.x) && Objects.equal(y, castOther.y) && Objects.equal(z, castOther.z);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(x, y, z);
    }

}
