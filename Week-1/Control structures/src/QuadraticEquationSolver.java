import java.util.Scanner;

public class QuadraticEquationSolver {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Enter a: ");
        double a = reader.nextDouble();
        System.out.print("Enter b: ");
        double b = reader.nextDouble();
        System.out.print("Enter c: ");
        double c = reader.nextDouble();

        double d = b * b - 4 * a * c;

        if (d < 0) {
            System.out.println("No real roots");
        } else if (d == 0) {
            double root = -b / (2 * a);
            System.out.println("One root: " + root);
        } else {
            double root1 = (-b + Math.sqrt(d)) / (2 * a);
            double root2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.println("Root 1: " + root1);
            System.out.println("Root 2: " + root2);
        }

        reader.close();
    }
}
