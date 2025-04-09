import java.util.LinkedList;
import java.util.Scanner;

public class QueueProgram {
    public static void main(String[] args) {
        LinkedList<Customer> queue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        String command;
        System.out.println("Queue Program");
        System.out.println("Enter 'Q' to enqueue, 'D' to dequeue, or 'E' to exit.");
        while (true) {
            System.out.print("Enter command: ");
            command = scanner.nextLine().trim().toUpperCase();
            if (command.equals("Q")) {
                Customer newCustomer = new Customer();
                newCustomer.setStartTime(System.nanoTime());
                queue.addFirst(newCustomer);
                System.out.println("Customer with ID " + newCustomer.getId() + " enqueued.");
            } else if (command.equals("D")) {
                if (queue.isEmpty()) {
                    System.out.println("The queue is empty. Cannot dequeue.");
                } else {
                    Customer dequeuedCustomer = queue.removeLast();
                    dequeuedCustomer.setEndTime(System.nanoTime());
                    long timeSpent = dequeuedCustomer.getTimeSpent();
                    System.out.println("Customer with ID " + dequeuedCustomer.getId() + " dequeued.");
                    System.out.println("Time spent in the queue: " + timeSpent + " nanoseconds.");
                }
            } else if (command.equals("E")) {
                System.out.println("Exiting program.");
                break;
            } else {
                System.out.println("Invalid command. Please enter Q, D, or E.");
            }
        }
        scanner.close();
    }
}
