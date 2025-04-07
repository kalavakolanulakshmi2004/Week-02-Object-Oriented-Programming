package AccessModifiers;
import java.util.*;
public class Book {
    public String ISBN;
    protected String title;
    private String author;
    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void displayBookDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}
class EBook extends Book {
    public EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }
    public void displayEBookDetails() {
        System.out.println("E-Book Details:");
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
    }
}
class BookLibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ISBN: ");
        String ISBN = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        EBook ebook = new EBook(ISBN, title, author);
        System.out.println("\nBook Details:");
        ebook.displayBookDetails();
        System.out.print("\nEnter new author name: ");
        String newAuthor = scanner.nextLine();
        ebook.setAuthor(newAuthor);
        System.out.println("\nUpdated Book Details:");
        ebook.displayBookDetails();
        System.out.println(" ");
        ebook.displayEBookDetails();
    }
}