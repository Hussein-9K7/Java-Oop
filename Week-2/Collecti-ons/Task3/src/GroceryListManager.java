import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GroceryListManager {
    private HashMap<String, Item> groceryList = new HashMap<>();

    private static class Item {
        double cost;
        String category;

        Item(double cost, String category) {
            this.cost = cost;
            this.category = category;
        }
    }

    public void addItem(String item, double cost, String category) {
        if (!groceryList.containsKey(item)) {
            groceryList.put(item, new Item(cost, category));
            System.out.println(item + " added to the list with cost: " + cost + " in category: " + category);
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
            for (Map.Entry<String, Item> entry : groceryList.entrySet()) {
                System.out.println("- " + entry.getKey() + " : $" + entry.getValue().cost + " (" + entry.getValue().category + ")");
            }
        }
    }

    public void displayByCategory(String category) {
        boolean found = false;
        for (Map.Entry<String, Item> entry : groceryList.entrySet()) {
            if (entry.getValue().category.equalsIgnoreCase(category)) {
                if (!found) {
                    System.out.println("Items in category: " + category);
                    found = true;
                }
                System.out.println("- " + entry.getKey() + " : $" + entry.getValue().cost);
            }
        }
        if (!found) {
            System.out.println("No items found in category: " + category);
        }
    }

    public boolean checkItem(String item) {
        return groceryList.containsKey(item);
    }

    public double calculateTotalCost() {
        double total = 0;
        for (Item item : groceryList.values()) {
            total += item.cost;
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
            System.out.println("4. Display By Category");
            System.out.println("5. Check Item");
            System.out.println("6. Calculate Total Cost");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String addItem = scanner.nextLine();
                    System.out.print("Enter item cost: ");
                    double cost = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter item category: ");
                    String category = scanner.nextLine();
                    manager.addItem(addItem, cost, category);
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
                    System.out.print("Enter category to display: ");
                    String displayCategory = scanner.nextLine();
                    manager.displayByCategory(displayCategory);
                    break;
                case 5:
                    System.out.print("Enter item to check: ");
                    String checkItem = scanner.nextLine();
                    System.out.println("Is \"" + checkItem + "\" in the list? " + manager.checkItem(checkItem));
                    break;
                case 6:
                    System.out.println("Total cost of items: $" + manager.calculateTotalCost());
                    break;
                case 7:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);

        scanner.close();
    }
}
