import java.util.Scanner;
import java.util.Random;

public class ANameGenerator {

    public static void main(String[] args) {
        String[] firstNames = {"Ali", "Sara", "Omar", "Lina", "Khaled"};
        String[] lastNames = {"Ahmed", "Mohamed", "Hassan", "Ibrahim", "El-Sayed"};

        Scanner scanner = new Scanner(System.in);
        System.out.print("How many random names would you like to generate? ");
        int numberOfNames = scanner.nextInt();

        Random random = new Random();

        System.out.println("Random names:");
        for (int i = 0; i < numberOfNames; i++) {
            int randomFirstNameIndex = random.nextInt(firstNames.length);
            int randomLastNameIndex = random.nextInt(lastNames.length);

            String randomName = firstNames[randomFirstNameIndex] + " " + lastNames[randomLastNameIndex];
            System.out.println(randomName);
        }

        scanner.close();
    }
}
