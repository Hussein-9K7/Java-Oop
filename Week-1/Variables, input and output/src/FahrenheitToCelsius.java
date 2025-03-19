import java.util.Scanner;
public class FahrenheitToCelsius {
    public static void main(String[] args) {
        Scanner render = new Scanner(System.in);
        System.out.println("Put a fahrenheit in C to Celsius: ");
        double fahrenheit = Double.parseDouble(render.nextLine());
        double celsius = (fahrenheit - 32) * 5 / 9;
        System.out.printf("Celsius is %.1f%n" ,celsius);
        render.close();
    }
}
