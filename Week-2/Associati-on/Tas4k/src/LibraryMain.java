import java.util.ArrayList;

class Book {
    private String title;
    private String author;
    private int publicationYear;
    private double rating;
    private ArrayList<String> reviews;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.rating = 0.0;
        this.reviews = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public double getRating() {
        return rating;
    }

    public ArrayList<String> getReviews() {
        return reviews;
    }

    public void setRating(double rating) {
        if (rating >= 0 && rating <= 5) {
            this.rating = rating;
        } else {
            System.out.println("Invalid rating! Please provide a rating between 0 and 5.");
        }
    }

    public void addReview(String review) {
        reviews.add(review);
    }

    public void displayBookDetails() {
        System.out.println("Title: " + title + ", Author: " + author + ", Year: " + publicationYear);
        System.out.println("Rating: " + rating + "/5");
        System.out.println("Reviews:");
        for (String review : reviews) {
            System.out.println("- " + review);
        }
    }
}

class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        System.out.println("Library Catalog:");
        int count = 1;
        for (Book book : books) {
            System.out.println(count + ". Title: \"" + book.getTitle() + "\", Author: \"" + book.getAuthor() + "\", Year: " + book.getPublicationYear());
            count++;
        }
    }

    public void findBooksByAuthor(String author) {
        System.out.println("Books by Author \"" + author + "\":");
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println("Title: \"" + book.getTitle() + "\", Year: " + book.getPublicationYear());
            }
        }
    }

    public void borrowBook(String title) {
        Book bookToBorrow = null;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                bookToBorrow = book;
                break;
            }
        }
        if (bookToBorrow != null) {
            books.remove(bookToBorrow);
            System.out.println("You have borrowed the book: " + bookToBorrow.getTitle());
        } else {
            System.out.println("Sorry, the book \"" + title + "\" is not available.");
        }
    }

    public void returnBook(Book book) {
        books.add(book);
        System.out.println("You have returned the book: " + book.getTitle());
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
        Book book1 = new Book("Introduction to Java Programming", "John Smith", 2020);
        Book book2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
        Book book3 = new Book("The Art of Fiction", "Alice Johnson", 2019);

        book1.setRating(4.5);
        book1.addReview("Great book for beginners.");
        book1.addReview("Very detailed and easy to follow.");

        book2.setRating(4.0);
        book2.addReview("Helpful for understanding algorithms.");
        book2.addReview("Clear explanations with examples.");

        book3.setRating(4.2);
        book3.addReview("A deep dive into storytelling.");
        book3.addReview("Well written and insightful.");

        Library library = new Library();

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.displayBooks();

        library.findBooksByAuthor("Jane Doe");

        library.borrowBook("Introduction to Java Programming");

        System.out.println("Is 'Introduction to Java Programming' available? " + library.isBookAvailable("Introduction to Java Programming"));

        library.returnBook(book1);

        System.out.println("Is 'Introduction to Java Programming' available? " + library.isBookAvailable("Introduction to Java Programming"));

        System.out.println("\nBook Details:");
        book1.displayBookDetails();
        book2.displayBookDetails();
        book3.displayBookDetails();
    }
}
