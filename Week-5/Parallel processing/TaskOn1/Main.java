public class Main {
    public static void main(String[] args) {
        int max = 20;
        Thread oddThread = new Thread(new OddPrinter(max));
        Thread evenThread = new Thread(new EvenPrinter(max));

        oddThread.start();
        evenThread.start();

        try {
            oddThread.join();
            evenThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Printing complete.");
    }
}

class OddPrinter implements Runnable {
    private int max;

    public OddPrinter(int max) {
        this.max = max;
    }

    public void run() {
        for (int i = 1; i <= max; i += 2) {
            System.out.println("Odd Thread: " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class EvenPrinter implements Runnable {
    private int max;

    public EvenPrinter(int max) {
        this.max = max;
    }

    public void run() {
        for (int i = 2; i <= max; i += 2) {
            System.out.println("Even Thread: " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
