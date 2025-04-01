import java.util.*;

class GroceryListManager {
    // كلاس داخلي لتمثيل العناصر في القائمة: يحتوي على التكلفة، الفئة، والكمية
    private static class Item {
        double cost; // التكلفة
        String category; // الفئة
        int quantity; // الكمية

        // المُنشئ الخاص بالكلاس Item
        Item(double cost, String category, int quantity) {
            this.cost = cost;
            this.category = category;
            this.quantity = quantity;
        }
    }

    // خريطة لتخزين العناصر (المفتاح هو اسم العنصر والقيمة هي كائن من نوع Item)
    private final Map<String, Item> groceryList = new HashMap<>();

    // دالة لإضافة عنصر مع التكلفة، الفئة، والكمية
    void addItem(String item, double cost, String category, int quantity) {
        groceryList.put(item, new Item(cost, category, quantity));
        System.out.println(item + " added.");
    }

    // دالة لتحديث كمية عنصر معين
    void updateQuantity(String item, int quantity) {
        if (groceryList.containsKey(item))
            groceryList.get(item).quantity = quantity; // تحديث الكمية
        else
            System.out.println("Item not found!"); // إذا كان العنصر غير موجود
    }

    // دالة لإزالة عنصر من القائمة
    void removeItem(String item) {
        if (groceryList.remove(item) != null)
            System.out.println(item + " removed.");
        else
            System.out.println("Item not found!"); // إذا كان العنصر غير موجود
    }

    // دالة لعرض جميع العناصر في القائمة
    void displayList() {
        if (groceryList.isEmpty())
            System.out.println("List is empty.");
        else
            groceryList.forEach((k, v) -> System.out.println(k + " - $" + v.cost + " - " + v.category + " - Qty: " + v.quantity));
    }

    // دالة لعرض العناصر بحسب الفئة
    void displayByCategory(String category) {
        groceryList.forEach((k, v) -> {
            if (v.category.equalsIgnoreCase(category))
                System.out.println(k + " - $" + v.cost + " - Qty: " + v.quantity);
        });
    }

    // دالة لعرض العناصر المتاحة (التي تحتوي على كمية أكبر من صفر)
    void displayAvailableItems() {
        groceryList.forEach((k, v) -> {
            if (v.quantity > 0)
                System.out.println(k + " - $" + v.cost + " - Qty: " + v.quantity);
        });
    }

    // دالة لحساب التكلفة الإجمالية لجميع العناصر
    double calculateTotalCost() {
        return groceryList.values().stream().mapToDouble(i -> i.cost * i.quantity).sum();
    }

    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add 2. Update Qty 3. Remove 4. Display 5. By Category 6. Available 7. Total 8. Exit");

            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.print("Item: ");
                    String item = scanner.next();
                    System.out.print("Cost: ");
                    double cost = scanner.nextDouble();
                    System.out.print("Category: ");
                    String category = scanner.next();
                    System.out.print("Qty: ");
                    int qty = scanner.nextInt();
                    manager.addItem(item, cost, category, qty);
                }
                case 2 -> {
                    System.out.print("Item: ");
                    manager.updateQuantity(scanner.next(), scanner.nextInt());
                }
                case 3 -> {
                    System.out.print("Item: ");
                    manager.removeItem(scanner.next());
                }
                case 4 -> manager.displayList();
                case 5 -> {
                    System.out.print("Category: ");
                    manager.displayByCategory(scanner.next());
                }
                case 6 -> manager.displayAvailableItems();
                case 7 -> System.out.println("Total Cost: $" + manager.calculateTotalCost());
                case 8 -> {
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice!"); // في حالة الاختيار غير الصحيح
            }
        }
    }
}
