package nl.mwensveen.adventofcode.year_2017.day_20;

import org.junit.Assert;
import org.junit.Test;

public class ParticleSwarmTest {

    @Test
    public void testOne() {
        ParticleSwarm particleSwarm = new ParticleSwarm("p=<3,0,0>, v=<2,0,0>, a=<-1,0,0>\n" +
                "p=<4,0,0>, v=<0,0,0>, a=<-2,0,0>");
        Assert.assertEquals(0, particleSwarm.calculate());
    }

    @Test
    public void testTwo() {
        ParticleSwarm particleSwarm = new ParticleSwarm("p=<-6,0,0>, v=< 3,0,0>, a=< 0,0,0>\n" +
                "p=<-4,0,0>, v=< 2,0,0>, a=< 0,0,0>\n" +
                "p=<-2,0,0>, v=< 1,0,0>, a=< 0,0,0>\n" +
                "p=< 3,0,0>, v=<-1,0,0>, a=< 0,0,0>");
        Assert.assertEquals(1, particleSwarm.calculateCollision());
    }
}
