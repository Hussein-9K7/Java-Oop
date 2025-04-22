public class Main {
    public static void main(String[] args) {
        TicketSystem system = new TicketSystem(10); // عدد المقاعد 10

        for (int i = 1; i <= 15; i++) {
            int customerId = i;
            int ticketsToReserve = (int)(Math.random() * 4) + 1; // عدد عشوائي من 1 إلى 4

            Thread t = new Thread(new Customer(system, customerId, ticketsToReserve));
            t.start();
        }
    }
}

class TicketSystem {
    private int availableSeats;

    public TicketSystem(int totalSeats) {
        this.availableSeats = totalSeats;
    }

    public synchronized boolean reserve(int customerId, int seats) {
        if (seats <= availableSeats) {
            availableSeats -= seats;
            System.out.println("Customer " + customerId + " reserved " + seats + " tickets.");
            return true;
        } else {
            System.out.println("Customer " + customerId + " couldn't reserve " + seats + " tickets.");
            return false;
        }
    }
}

class Customer implements Runnable {
    private TicketSystem system;
    private int customerId;
    private int tickets;

    public Customer(TicketSystem system, int customerId, int tickets) {
        this.system = system;
        this.customerId = customerId;
        this.tickets = tickets;
    }

    public void run() {
        system.reserve(customerId, tickets);
    }
}
