import java.util.ArrayList;

public class LibraryMain {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Java Programming", "John Smith", 2020);
        Book book2 = new Book("Data Structures", "Jane Doe", 2018);
        library.addBook(book1);
        library.addBook(book2);

        User user1 = new User("Ali", 22);
        User user2 = new User("Sara", 19);
        library.addUser(user1);
        library.addUser(user2);

        library.borrowBook("Java Programming", user1);
        library.displayUsers();

        library.returnBook(book1, user1);
        library.displayUsers();
    }

    static class Book {
        private String title;
        private String author;
        private int year;

        public Book(String title, String author, int year) {
            this.title = title;
            this.author = author;
            this.year = year;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public int getYear() {
            return year;
        }
    }

    static class User {
        private String name;
        private int age;
        private ArrayList<Book> borrowedBooks;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
            this.borrowedBooks = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void borrowBook(Book book) {
            borrowedBooks.add(book);
        }

        public void returnBook(Book book) {
            borrowedBooks.remove(book);
        }

        public void displayBorrowedBooks() {
            System.out.println(name + " has borrowed the following books:");
            for (Book book : borrowedBooks) {
                System.out.println("- " + book.getTitle());
            }
        }
    }

    static class Library {
        private ArrayList<Book> books = new ArrayList<>();
        private ArrayList<User> users = new ArrayList<>();

        public void addBook(Book book) {
            books.add(book);
        }

        public void addUser(User user) {
            users.add(user);
        }

        public void borrowBook(String title, User user) {
            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    user.borrowBook(book);
                    books.remove(book);
                    System.out.println(user.getName() + " borrowed: " + title);
                    return;
                }
            }
            System.out.println("Sorry, book not available.");
        }

        public void returnBook(Book book, User user) {
            user.returnBook(book);
            books.add(book);
            System.out.println(user.getName() + " returned: " + book.getTitle());
        }

        public void displayUsers() {
            System.out.println("Library Users:");
            for (User user : users) {
                System.out.println("- " + user.getName() + " (Age: " + user.getAge() + ")");
                user.displayBorrowedBooks();
            }
        }
    }
}