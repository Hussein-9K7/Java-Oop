import java.util.LinkedList;

public class ServicePoint {
    private LinkedList<Customer> queue = new LinkedList<>();

    public void addToQueue(Customer a) {
        queue.add(a);
    }

    public Customer removeFromQueue() {
        return queue.poll();
    }

    public void serve() {
        while (!queue.isEmpty()) {
            Customer currentCustomer = removeFromQueue();
            currentCustomer.setEndTime(System.nanoTime());
            long serviceTime = (long) (Math.random() * 1000); // Random service time (ms)
            try {
                Thread.sleep(serviceTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            long timeSpent = currentCustomer.getTimeSpent() + serviceTime;
            System.out.println("Customer " + currentCustomer.getId() + " served.");
            System.out.println("Total response time: " + timeSpent + " nanoseconds.");
        }
    }
}
