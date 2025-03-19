import java.util.Scanner;

public class ObsoleteMeasures {
    public static void main(String[] args) {
        double luotiInGrams = 13.28;
        double naulaInGrams = 32 * luotiInGrams;
        double leiviskaInGrams = 20 * naulaInGrams;

        Scanner reader = new Scanner(System.in);
        System.out.print("Please enter the weight in grams: ");
        double userInput = Double.parseDouble(reader.nextLine());

        double totalLuoti = userInput / luotiInGrams;

        int leiviska = (int) (totalLuoti / 640);

        double remainingLuotiAfterLeiviska = totalLuoti % 640;
        int naula = (int) (remainingLuotiAfterLeiviska / 32);

        double remainingLuoti = remainingLuotiAfterLeiviska % 32;

        System.out.printf("Entered weight: %.2f grams equals: %d Leiviskä, %d Naula, and %.2f Luoti%n",
                userInput, leiviska, naula, remainingLuoti);
    }
}
