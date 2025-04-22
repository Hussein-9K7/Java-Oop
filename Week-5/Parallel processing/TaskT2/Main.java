import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int size = 100000;
        int[] numbers = new int[size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            numbers[i] = rand.nextInt(100);
        }

        int cores = Runtime.getRuntime().availableProcessors();
        SumThread[] threads = new SumThread[cores];

        int chunkSize = size / cores;
        int start = 0;

        for (int i = 0; i < cores; i++) {
            int end = (i == cores - 1) ? size : start + chunkSize;
            threads[i] = new SumThread(numbers, start, end);
            threads[i].start();
            start = end;
        }

        int totalSum = 0;
        for (int i = 0; i < cores; i++) {
            try {
                threads[i].join();
                totalSum += threads[i].getPartialSum();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Total Sum: " + totalSum);
    }
}

class SumThread extends Thread {
    private int[] array;
    private int start, end;
    private int partialSum = 0;

    public SumThread(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    public void run() {
        for (int i = start; i < end; i++) {
            partialSum += array[i];
        }
    }

    public int getPartialSum() {
        return partialSum;
    }
}
