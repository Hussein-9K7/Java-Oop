import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SafeList list = new SafeList();

        for (int i = 1; i <= 5; i++) {
            int threadNumber = i;
            Thread t = new Thread(() -> {
                list.add("Item from Thread " + threadNumber);
                System.out.println("Thread " + threadNumber + " added an item. Size now: " + list.size());
            });
            t.start();
        }

        for (int i = 0; i < 2; i++) {
            Thread t = new Thread(() -> {
                String removed = list.remove();
                if (removed != null) {
                    System.out.println("Removed: " + removed + ". Size now: " + list.size());
                } else {
                    System.out.println("List was empty, couldn't remove.");
                }
            });
            t.start();
        }
    }
}

class SafeList {
    private ArrayList<String> list = new ArrayList<>();

    public synchronized void add(String item) {
        list.add(item);
    }

    public synchronized String remove() {
        if (!list.isEmpty()) {
            return list.remove(0);
        } else {
            return null;
        }
    }

    public synchronized int size() {
        return list.size();
    }
}
