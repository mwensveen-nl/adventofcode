package nl.mwensveen.adventofcode.year_2018.day_4;

public enum Event {
    START_DUTY("Guard"),
    WAKE_UP("wakes"),
    FALL_ASLEEP("falls");

    private String note;

    private Event(String note) {
        this.note = note;
    }

    public static Event valueFor(String findNote) {
        for (Event event : Event.values()) {
            if (event.note.equals(findNote)) {
                return event;
            }
        }
        throw new RuntimeException("cannot find Event for " + findNote);
    }
}
