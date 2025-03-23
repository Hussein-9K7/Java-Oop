import java.util.Scanner;

public class BinaryValues {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Put a Binary Number (only 0 and 1): ");
        String binary = reader.nextLine();

        if (!binary.matches("[01]+")) {
            System.out.println("Invalid input! Please enter a valid binary number.");
        } else {
            int decimal = 0;
            int power = 1;

            for (int i = binary.length() - 1; i >= 0; i--) {
                if (binary.charAt(i) == '1') {
                    decimal += power;
                }
                power *= 2;
            }

            System.out.println("The decimal equivalent is: " + decimal);
        }

        reader.close();
    }
}
