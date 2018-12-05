package nl.mwensveen.adventofcode.year_2018.day_4;

import org.junit.Assert;
import org.junit.Test;

public class GuardEventTest {

    @Test
    public void testGuardEvent() throws Exception {
        GuardEvent guardEvent = new GuardEvent("[1518-11-01 00:00] Guard #10 begins shift");
        Assert.assertEquals(Event.START_DUTY, guardEvent.getEvent());
        Assert.assertEquals(new Integer(10), guardEvent.getGuardNumber());
    }

    @Test
    public void testGuardEvent2() throws Exception {
        GuardEvent guardEvent = new GuardEvent("[1518-11-01 23:59] Guard #10456 begins shift");
        Assert.assertEquals(Event.START_DUTY, guardEvent.getEvent());
        Assert.assertEquals(new Integer(10456), guardEvent.getGuardNumber());
        Assert.assertEquals(1518, guardEvent.getEventTime().getYear());
        Assert.assertEquals(11, guardEvent.getEventTime().getMonthValue());
        Assert.assertEquals(1, guardEvent.getEventTime().getDayOfMonth());
        Assert.assertEquals(23, guardEvent.getEventTime().getHour());
        Assert.assertEquals(59, guardEvent.getEventTime().getMinute());

    }

    @Test
    public void testGuardEvent3() throws Exception {
        GuardEvent guardEvent = new GuardEvent("[1518-11-02 00:00] Guard #1 begins shift");
        Assert.assertEquals(Event.START_DUTY, guardEvent.getEvent());
        Assert.assertEquals(new Integer(1), guardEvent.getGuardNumber());
    }

    @Test
    public void testEventFallAsleep() throws Exception {
        GuardEvent asleepEvent = new GuardEvent("[1518-11-01 00:05] falls asleep");
        Assert.assertEquals(Event.FALL_ASLEEP, asleepEvent.getEvent());
        Assert.assertNull(asleepEvent.getGuardNumber());
    }

    @Test
    public void testEventWakeUp() throws Exception {
        GuardEvent wakeUpEvent = new GuardEvent("[1518-11-01 00:25] wakes up");
        Assert.assertEquals(Event.WAKE_UP, wakeUpEvent.getEvent());
        Assert.assertNull(wakeUpEvent.getGuardNumber());
    }

    @Test
    public void testCompare() {
        GuardEvent wakeUpEvent = new GuardEvent("[1518-11-01 00:25] wakes up");
        GuardEvent asleepEvent = new GuardEvent("[1518-11-01 00:05] falls asleep");

        Assert.assertEquals(-1, asleepEvent.compareTo(wakeUpEvent));
        Assert.assertEquals(1, wakeUpEvent.compareTo(asleepEvent));
    }
}