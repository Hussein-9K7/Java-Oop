public class Event implements Comparable<Event> {
    private EventType eventType;
    private double eventTime;

    public Event(EventType eventType, double eventTime) {
        this.eventType = eventType;
        this.eventTime = eventTime;
    }

    public EventType getEventType() {
        return eventType;
    }

    public double getEventTime() {
        return eventTime;
    }

    @Override
    public int compareTo(Event other) {
        return Double.compare(this.eventTime, other.eventTime);
    }

    @Override
    public String toString() {
        return "Event Type: " + eventType + ", Time: " + eventTime;
    }
}
