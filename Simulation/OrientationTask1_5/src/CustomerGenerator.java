public class CustomerGenerator {
    public static void generateCustomers(ServicePoint servicePoint, int numberOfCustomers) {
        for (int i = 0; i < numberOfCustomers; i++) {
            Customer customer = new Customer();
            customer.setStartTime(System.nanoTime());
            servicePoint.addToQueue(customer);
        }
    }
}
