import model.Book;
import model.LibraryMember;
import system.Library;

public class Main {
    public static void main(String[] args) {
        // إنشاء الكتب
        Book book1 = new Book("1984", "George Orwell", "978-0451524935");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084");
        Book book3 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565");

        // إنشاء الأعضاء
        LibraryMember member1 = new LibraryMember("Alice", 101);
        LibraryMember member2 = new LibraryMember("Bob", 102);

        // إنشاء المكتبة
        Library library = new Library();

        // إضافة الكتب والأعضاء إلى المكتبة
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addMember(member1);
        library.addMember(member2);

        // عرض الكتب المتاحة في المكتبة
        library.displayBooks();

        // حجز الكتب
        library.reserveBook(member1, book1); // Alice يحجز "1984"
        library.reserveBook(member2, book2); // Bob يحجز "To Kill a Mockingbird"

        // عرض الكتب المحجوزة لأعضاء
        library.displayReservedBooks(member1);
        library.displayReservedBooks(member2);

        // إلغاء حجز الكتب
        library.cancelReservation(member1, book1); // Alice يلغي حجز "1984"
        library.cancelReservation(member2, book2); // Bob يلغي حجز "To Kill a Mockingbird"

        // عرض الكتب بعد الإلغاء
        library.displayReservedBooks(member1);
        library.displayReservedBooks(member2);

        // عرض الكتب المتاحة بعد الإلغاء
        library.displayBooks();
    }
}
