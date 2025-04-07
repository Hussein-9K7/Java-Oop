package system;

import model.Book;
import model.LibraryMember;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<LibraryMember> members = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(LibraryMember member) {
        members.add(member);
    }

    public void borrowBook(LibraryMember member, Book book) {
        if (books.contains(book)) {
            member.borrowBook(book);
            books.remove(book);
            System.out.println(member.getName() + " borrowed the book: " + book.getTitle());
        } else {
            System.out.println("Book not available in the library.");
        }
    }

    public void returnBook(LibraryMember member, Book book) {
        if (member.getBorrowedBooks().contains(book)) {
            member.returnBook(book);
            books.add(book);
            System.out.println(member.getName() + " returned the book: " + book.getTitle());
        } else {
            System.out.println("This member did not borrow this book.");
        }
    }

    public void displayBooks() {
        System.out.println("Books in Library:");
        for (Book book : books) {
            book.displayInfo();
        }
    }
}
