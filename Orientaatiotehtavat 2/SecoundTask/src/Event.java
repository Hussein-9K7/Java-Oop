import java.util.*;

public class Event implements Comparable<Event> {
    private double eventTime;
    private String eventType;

    // Constructor
    public Event(double eventTime, String eventType) {
        this.eventTime = eventTime;
        this.eventType = eventType;
    }


    public double getEventTime() {
        return eventTime;
    }

    public String getEventType() {
        return eventType;
    }


    @Override
    public int compareTo(Event otherEvent) {
        // Sorting by event time
        if (this.eventTime < otherEvent.eventTime) {
            return -1;
        } else if (this.eventTime > otherEvent.eventTime) {
            return 1;
        } else {
            return 0; // Same time
        }
    }

    // To display event details
    @Override
    public String toString() {
        return "Event Type: " + eventType + ", Time: " + eventTime;
    }
}
