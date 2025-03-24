import java.util.Scanner;

public class FindingTheMaximumSubarraySum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] numbers = new int[size];

        System.out.println("Enter the integers into the array:");
        for (int i = 0; i < size; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;

        for (int i = 0; i < size; i++) {
            int currentSum = 0;
            for (int j = i; j < size; j++) {
                currentSum += numbers[j];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    start = i;
                    end = j;
                }
            }
        }

        System.out.println("Maximum sum: " + maxSum);
        System.out.println("Integers: " + (start + 1) + "-" + (end + 1));

        scanner.close();
    }
}
