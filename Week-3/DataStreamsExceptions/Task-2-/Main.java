import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        int count = 60;
        long[] fib = new long[count];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < count; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        String fileName = "fibonacci.csv";
        try (FileWriter writer = new FileWriter(fileName)) {
            for (int i = 0; i < count; i++) {
                writer.write(Long.toString(fib[i]));
                if (i < count - 1) {
                    writer.write(",");
                }
            }
            System.out.println("Fibonacci sequence written to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
