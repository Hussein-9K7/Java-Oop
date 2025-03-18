import java.util.Scanner;

public class SumOfThreeNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.println("Put the First Number:");
        int first = Integer.parseInt(scanner.nextLine());

        System.out.println("Put the Second Number:");
        int second = Integer.parseInt(scanner.nextLine());

        System.out.println("Put the Third Number:");
        int third = Integer.parseInt(scanner.nextLine());


        System.out.println("The sum of 3 numbers is: " + (first + second + third));


        System.out.println("The multiplication of 3 numbers is: " + (first * second * third));

        // Here The program will return True Number bc i use Integer Number (3)
        System.out.println("Average as integer: " + (first + second + third) / 3);

        // Here The Program Will Return Decinumber bc i use float Number (3.0)
        System.out.println("Average as float: " + (first + second + third) / 3.0);
    }
}
