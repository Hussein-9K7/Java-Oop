import java.util.Scanner;

public class Triangles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the length of the first side: ");
        double firstSide = Double.parseDouble(scanner.nextLine());
        double firstSideSquared = firstSide * firstSide;

        System.out.print("Please enter the length of the second side: ");
        double secondSide = Double.parseDouble(scanner.nextLine());
        double secondSideSquared = secondSide * secondSide;

        double totalSquared = firstSideSquared + secondSideSquared;

        double hypotenuseLength = Math.sqrt(totalSquared);

        System.out.printf("The length of the hypotenuse is: %.2f%n", hypotenuseLength);

        scanner.close();
    }
}
