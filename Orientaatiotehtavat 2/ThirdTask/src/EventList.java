import java.util.PriorityQueue;

public class EventList {
    private PriorityQueue<Event> eventQueue;

    public EventList() {
        this.eventQueue = new PriorityQueue<>();
    }

    public void addEvent(Event event) {
        eventQueue.add(event);
    }

    public Event getNextEvent() {
        return eventQueue.poll();
    }

    public void printEventList() {
        for (Event event : eventQueue) {
            System.out.println(event);
        }
    }
}
