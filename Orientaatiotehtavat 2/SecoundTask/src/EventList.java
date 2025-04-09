import java.util.*;

public class EventList {
    private PriorityQueue<Event> eventQueue;


    public EventList() {

        eventQueue = new PriorityQueue<>();
    }


    public void addEvent(Event event) {
        eventQueue.add(event);
    }


    public Event removeNextEvent() {
        return eventQueue.poll();
    }
    public void printEventList() {

        PriorityQueue<Event> copyQueue = new PriorityQueue<>(eventQueue);
        while (!copyQueue.isEmpty()) {
            System.out.println(copyQueue.poll());
        }
    }
}
