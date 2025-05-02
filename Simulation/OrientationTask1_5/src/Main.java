// إنشاء العملاء وإضافتهم إلى الطابور
// كلش مهم هذا البرنامج لازم ادرسه بعدين
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ServicePoint servicePoint = new ServicePoint();


        CustomerGenerator.generateCustomers(servicePoint, 5);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Service Point Program");
        System.out.println("Enter 'S' to start serving customers, or 'E' to exit.");

        while (true) {
            System.out.print("Enter command: ");
            String command = scanner.nextLine().trim().toUpperCase();

            if (command.equals("S")) {
                servicePoint.serve();
            } else if (command.equals("E")) {
                System.out.println("Exiting program.");
                break;
            } else {
                System.out.println("Invalid command.");
            }
        }

        scanner.close();
    }
}
