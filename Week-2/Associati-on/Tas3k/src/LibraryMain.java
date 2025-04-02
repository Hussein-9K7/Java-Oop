// هذا البرنامج يمثل مكتبة تحتوي على مجموعة من الكتب ويمكن استعارتها وإرجاعها.
// تم إضافة وظيفة جديدة للتحقق من توفر كتاب معين في المكتبة.
// فئة Book تحتوي على بيانات الكتاب مثل العنوان، المؤلف، وسنة النشر.
// فئة Library تحتوي على قائمة من الكتب مع وظائف لإدارتها.
// الفئة الرئيسية LibraryMain تقوم بإنشاء الكتب وإضافتها إلى المكتبة وعرضها واستعارتها وإرجاعها والتحقق من توفر كتاب معين.

import java.util.ArrayList;

class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }

    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Year: " + year;
    }
}

class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("The library has no books.");
        } else {
            System.out.println("Library Catalog:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void findBooksByAuthor(String author) {
        boolean found = false;
        System.out.println("Books by Author: " + author);
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found by this author.");
        }
    }

    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                books.remove(book);
                System.out.println("You borrowed: " + book);
                return;
            }
        }
        System.out.println("Sorry, this book is not available.");
    }

    public void returnBook(Book book) {
        books.add(book);
        System.out.println("You returned: " + book);
    }

    public boolean isBookAvailable(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }
}

public class LibraryMain {
    public static void main(String[] args) {
        Book book1 = new Book("Introduction to Java", "John Smith", 2020);
        Book book2 = new Book("Data Structures", "Jane Doe", 2018);
        Book book3 = new Book("The Art of Writing", "Alice Johnson", 2019);

        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.displayBooks();

        System.out.println();
        library.borrowBook("Data Structures");
        library.displayBooks();

        System.out.println();
        System.out.println("Is 'Data Structures' available? " + library.isBookAvailable("Data Structures"));

        System.out.println();
        library.returnBook(book2);
        library.displayBooks();
        System.out.println("Is 'Data Structures' available? " + library.isBookAvailable("Data Structures"));
    }
}