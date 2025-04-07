package system;

import model.Book;
import model.LibraryMember;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<LibraryMember> members = new ArrayList<>();

    // إضافة كتاب إلى المكتبة
    public void addBook(Book book) {
        books.add(book);
    }

    // إضافة عضو إلى المكتبة
    public void addMember(LibraryMember member) {
        members.add(member);
    }

    // حجز كتاب لعضو
    public void reserveBook(LibraryMember member, Book book) {
        if (!book.isReserved()) {
            book.setReserved(true);
            member.addReservedBook(book);
            System.out.println(member.getName() + " reserved the book: " + book.getTitle());
        } else {
            System.out.println("The book is already reserved.");
        }
    }

    // إلغاء حجز كتاب لعضو
    public void cancelReservation(LibraryMember member, Book book) {
        if (book.isReserved() && member.hasReservedBook(book)) {
            book.setReserved(false);
            member.removeReservedBook(book);
            System.out.println(member.getName() + " canceled the reservation for the book: " + book.getTitle());
        } else {
            System.out.println("This book was not reserved by this member.");
        }
    }

    // عرض الكتب المحجوزة لكل عضو
    public void displayReservedBooks(LibraryMember member) {
        System.out.println("Reserved books for " + member.getName() + ":");
        for (Book book : member.getReservedBooks()) {
            System.out.println(book.getTitle());
        }
    }

    // عرض الكتب المتاحة في المكتبة
    public void displayBooks() {
        System.out.println("Books in Library:");
        for (Book book : books) {
            book.displayInfo();
        }
    }
}
