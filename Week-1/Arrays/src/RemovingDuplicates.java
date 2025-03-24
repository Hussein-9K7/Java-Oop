import java.util.Scanner;

public class RemovingDuplicates {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter how many numbers you want: ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];

        System.out.println("Enter your numbers:");
        for (int i = 0; i < size; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        int[] uniqueNumbers = new int[size];
        int uniqueCount = 0;

        for (int i = 0; i < size; i++) {
            boolean foundDuplicate = false;
            for (int j = 0; j < uniqueCount; j++) {
                if (numbers[i] == uniqueNumbers[j]) {
                    foundDuplicate = true;
                    break;
                }
            }
            if (!foundDuplicate) {
                uniqueNumbers[uniqueCount++] = numbers[i];
            }
        }

        System.out.println("Here are your numbers without duplicates:");
        for (int i = 0; i < uniqueCount; i++) {
            System.out.print(uniqueNumbers[i] + " ");
        }

        scanner.close();
    }
}
