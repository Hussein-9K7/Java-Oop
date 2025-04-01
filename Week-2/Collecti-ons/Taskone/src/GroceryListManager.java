// شرح الكود:
// هذا البرنامج يمثل مدير قائمة البقالة باستخدام Java
// يمكن للمستخدم إضافة عناصر إلى القائمة، حذفها، عرض القائمة، والتحقق من وجود عنصر معين
// نستخدم ArrayList لتخزين العناصر، مما يسمح بإدارة القائمة بسهولة
// يتم تنفيذ جميع العمليات من خلال مجموعة من الدوال، ثم يتم تجربتها داخل الدالة main

import java.util.ArrayList;
import java.util.Scanner;

public class GroceryListManager {
    private ArrayList<String> groceryList = new ArrayList<>(); // قائمة لتخزين العناصر

    // دالة لإضافة عنصر إلى القائمة
    public void addItem(String item) {
        if (!groceryList.contains(item)) { // التحقق من عدم وجود العنصر مسبقًا
            groceryList.add(item); // إضافة العنصر
            System.out.println(item + " added to the list.");
        } else {
            System.out.println(item + " is already in the list!");
        }
    }

    // دالة لحذف عنصر من القائمة
    public void removeItem(String item) {
        if (groceryList.contains(item)) { // التحقق من وجود العنصر قبل حذفه
            groceryList.remove(item); // حذف العنصر
            System.out.println(item + " removed from the list.");
        } else {
            System.out.println(item + " is not in the list!");
        }
    }

    // دالة لعرض جميع العناصر في القائمة
    public void displayList() {
        if (groceryList.isEmpty()) { // التحقق مما إذا كانت القائمة فارغة
            System.out.println("The list is empty.");
        } else {
            System.out.println("Grocery List:");
            for (int i = 0; i < groceryList.size(); i++) {
                System.out.println((i + 1) + ". " + groceryList.get(i));
            }
        }
    }

    // دالة للتحقق مما إذا كان عنصر معين موجودًا في القائمة
    public boolean checkItem(String item) {
        return groceryList.contains(item);
    }

    // البرنامج الرئيسي لتجربة الوظائف
    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();

        // إضافة عناصر إلى القائمة
        manager.addItem("Apples");
        manager.addItem("Milk");
        manager.addItem("Bread");

        // عرض القائمة
        manager.displayList();

        // التحقق من وجود عنصر معين
        System.out.println("\nIs \"Milk\" in the list? " + manager.checkItem("Milk"));

        // إزالة عنصر من القائمة
        System.out.println("\nRemoving \"Milk\" from the list...");
        manager.removeItem("Milk");

        // عرض القائمة بعد التعديل
        manager.displayList();
    }
}
