public class TestProgram {
    public static void main(String[] args) {
        EventList eventList = new EventList();

        Event arrival1 = new Event(EventType.ARRIVAL, 5.5);
        Event departure1 = new Event(EventType.DEPARTURE, 1.5);
        Event arrival2 = new Event(EventType.ARRIVAL, 7.0);
        Event departure2 = new Event(EventType.DEPARTURE, 2.0);

        eventList.addEvent(arrival1);
        eventList.addEvent(departure1);
        eventList.addEvent(arrival2);
        eventList.addEvent(departure2);

        System.out.println("Event List Ordered by Event Time:");
        eventList.printEventList();

        System.out.println("\nRemoving the next event: ");
        Event nextEvent = eventList.getNextEvent();
        System.out.println(nextEvent);
    }
}
