public class Main {
    public static void main(String[] args) {

        EventList eventList = new EventList();


        Event event1 = new Event(5.5, "Arrival");
        Event event2 = new Event(2.0, "Departure");
        Event event3 = new Event(7.0, "Arrival");
        Event event4 = new Event(1.5, "Departure");


        eventList.addEvent(event1);
        eventList.addEvent(event2);
        eventList.addEvent(event3);
        eventList.addEvent(event4);


        System.out.println("Event List Ordered by Event Time:");
        eventList.printEventList();


        System.out.println("\nRemoving the next event: ");
        Event nextEvent = eventList.removeNextEvent();
        System.out.println(nextEvent);
    }
}
