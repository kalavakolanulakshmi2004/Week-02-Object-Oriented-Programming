package level1;
import java.util.*;
public class Book {
    String title, author;
    double price;
    Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
    }
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    void display() {
        System.out.println("Title: " + title + ", Author: " + author + ", Price: " + price);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter book title:");
        String title = sc.nextLine();
        System.out.println("Enter book author:");
        String author = sc.nextLine();
        System.out.println("Enter book price:");
        double price = sc.nextDouble();
        Book b1 = new Book();
        Book b2 = new Book(title, author, price);
        b1.display();
        b2.display();
    }
}
