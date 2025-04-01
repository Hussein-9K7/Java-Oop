import java.util.HashMap;
import java.util.Scanner;

public class GroceryListManager {
    private HashMap<String, Double> groceryList = new HashMap<>();

    public void addItem(String item, double cost) {
        if (!groceryList.containsKey(item)) {
            groceryList.put(item, cost);
            System.out.println(item + " added to the list with cost: " + cost);
        } else {
            System.out.println(item + " is already in the list!");
        }
    }

    public void removeItem(String item) {
        if (groceryList.containsKey(item)) {
            groceryList.remove(item);
            System.out.println(item + " removed from the list.");
        } else {
            System.out.println(item + " is not in the list!");
        }
    }

    public void displayList() {
        if (groceryList.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("Grocery List:");
            for (String item : groceryList.keySet()) {
                System.out.println("- " + item + " : $" + groceryList.get(item));
            }
        }
    }

    public boolean checkItem(String item) {
        return groceryList.containsKey(item);
    }

    public double calculateTotalCost() {
        double total = 0;
        for (double cost : groceryList.values()) {
            total += cost;
        }
        return total;
    }

    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Display List");
            System.out.println("4. Check Item");
            System.out.println("5. Calculate Total Cost");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String addItem = scanner.nextLine();
                    System.out.print("Enter item cost: ");
                    double cost = scanner.nextDouble();
                    manager.addItem(addItem, cost);
                    break;
                case 2:
                    System.out.print("Enter item to remove: ");
                    String removeItem = scanner.nextLine();
                    manager.removeItem(removeItem);
                    break;
                case 3:
                    manager.displayList();
                    break;
                case 4:
                    System.out.print("Enter item to check: ");
                    String checkItem = scanner.nextLine();
                    System.out.println("Is \"" + checkItem + "\" in the list? " + manager.checkItem(checkItem));
                    break;
                case 5:
                    System.out.println("Total cost of items: $" + manager.calculateTotalCost());
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}