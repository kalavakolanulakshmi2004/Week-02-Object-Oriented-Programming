package level1;
import java.util.*;
public class BookLibrary {
    String title, author;
    double price;
    boolean available;
    BookLibrary(String title, String author, double price, boolean available) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = available;
    }
    void borrowBook() {
        if (available) {
            available = false;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is not available.");
        }
    }
    void display() {
        System.out.println("Title: " + title + ", Author: " + author + ", Price: " + price + ", Available: " + available);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();
        System.out.print("Enter Book Price: ");
        double price = sc.nextDouble();
        System.out.print("Is the book available? (true/false): ");
        boolean available = sc.nextBoolean();
        BookLibrary book = new BookLibrary(title, author, price, available);
        book.display();
        System.out.print("\nWould you like to borrow the book? (true/false): ");
        boolean borrowRequest = sc.nextBoolean();
        if (borrowRequest) {
            book.borrowBook();
        }
        System.out.print("\nWould you like to borrow the book again? (true/false): ");
        borrowRequest = sc.nextBoolean();
        if (borrowRequest) {
            book.borrowBook();
        }
    }
}
