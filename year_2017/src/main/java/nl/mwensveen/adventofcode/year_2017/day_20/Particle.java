package nl.mwensveen.adventofcode.year_2017.day_20;

import java.math.BigInteger;

public class Particle {
    private static int sequence = 0;

    private int id;

    public int getId() {
        return id;
    }

    private BigInteger px;
    private BigInteger py;
    private BigInteger pz;
    private BigInteger vx;
    private BigInteger vy;
    private BigInteger vz;
    private BigInteger ax;
    private BigInteger ay;
    private BigInteger az;

    public BigInteger distance() {
        return px.abs().add(py.abs()).add(pz.abs());
    }

    @Override
    public String toString() {
        return "Particle [id=" + id + ", p=" + px + ", " + py + ", " + pz + ", v=" + vx + ", " + vy + ", "
                + vz + ", a=" + ax + ", " + ay + ", " + az + "]";
    }

    public Position getPosition() {
        return new Position(px, py, pz);
    }

    private Particle(Builder builder) {
        id = sequence;
        sequence++;
        this.px = builder.px;
        this.py = builder.py;
        this.pz = builder.pz;
        this.vx = builder.vx;
        this.vy = builder.vy;
        this.vz = builder.vz;
        this.ax = builder.ax;
        this.ay = builder.ay;
        this.az = builder.az;
    }

    public void tick() {
        // System.out.print(this.toString() + " --> ");
        vx = vx.add(ax);
        vy = vy.add(ay);
        vz = vz.add(az);

        px = px.add(vx);
        py = py.add(vy);
        pz = pz.add(vz);
        // System.out.println(this.toString());
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private BigInteger px;
        private BigInteger py;
        private BigInteger pz;
        private BigInteger vx;
        private BigInteger vy;
        private BigInteger vz;
        private BigInteger ax;
        private BigInteger ay;
        private BigInteger az;

        public Builder setPx(String px) {
            this.px = new BigInteger(px);
            return this;
        }

        public Builder setPy(String py) {
            this.py = new BigInteger(py);
            return this;
        }

        public Builder setPz(String pz) {
            this.pz = new BigInteger(pz);
            return this;
        }

        public Builder setVx(String vx) {
            this.vx = new BigInteger(vx);
            return this;
        }

        public Builder setVy(String vy) {
            this.vy = new BigInteger(vy);
            return this;
        }

        public Builder setVz(String vz) {
            this.vz = new BigInteger(vz);
            return this;
        }

        public Builder setAx(String ax) {
            this.ax = new BigInteger(ax);
            return this;
        }

        public Builder setAy(String ay) {
            this.ay = new BigInteger(ay);
            return this;
        }

        public Builder setAz(String az) {
            this.az = new BigInteger(az);
            return this;
        }

        public Particle build() {
            return new Particle(this);
        }
    }
}
