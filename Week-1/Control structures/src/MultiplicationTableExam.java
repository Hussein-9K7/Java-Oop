import java.util.Random;
import java.util.Scanner;

public class MultiplicationTableExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            int score = 0;

            for (int i = 1; i <= 10; i++) {
                int num1 = random.nextInt(10) + 1;
                int num2 = random.nextInt(10) + 1;

                System.out.println("What is " + num1 + " × " + num2 + "?");
                int userAnswer = scanner.nextInt();

                if (userAnswer == num1 * num2) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Incorrect. The correct answer is " + (num1 * num2));
                }
            }

            if (score == 10) {
                System.out.println("Congratulations! You have mastered the multiplication tables!");
                break;
            } else {
                System.out.println("You didn't get 10 points. Let's try again.\n");
            }
        }

        scanner.close();
    }
}
