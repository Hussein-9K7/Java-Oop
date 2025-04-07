import model.Book;
import model.LibraryMember;
import system.Library;

public class Main {
    public static void main(String[] args) {
        // Create books
        Book book1 = new Book("1984", "George Orwell", "978-0451524935");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084");
        Book book3 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565");

        // Create library members
        LibraryMember member1 = new LibraryMember("Alice", 101);
        LibraryMember member2 = new LibraryMember("Bob", 102);

        // Create library
        Library library = new Library();

        // Add books and members to the library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addMember(member1);
        library.addMember(member2);

        // Display all books in the library
        library.displayBooks();

        // Borrow books
        library.borrowBook(member1, book1); // Alice borrows "1984"
        library.borrowBook(member2, book2); // Bob borrows "To Kill a Mockingbird"

        // Display books after borrowing
        library.displayBooks();

        // Return books
        library.returnBook(member1, book1); // Alice returns "1984"
        library.returnBook(member2, book2); // Bob returns "To Kill a Mockingbird"

        // Display books after returning
        library.displayBooks();
    }
}
