import java.util.ArrayList;
import java.util.Scanner;
class Book {
    private String title;
    private String author;
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    public void displayBook() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of books: ");
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<Book> allBooks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter title of book " + (i + 1) + ": ");
            String title = sc.nextLine();
            System.out.print("Enter author of book " + (i + 1) + ": ");
            String author = sc.nextLine();
            allBooks.add(new Book(title, author));
        }
        Library lib1 = new Library("Central Library");
        Library lib2 = new Library("Community Library");
        for (int i = 0; i < allBooks.size(); i++) {
            System.out.print("Add book " + (i + 1) + " to which library? (1 = Central, 2 = Community, 3 = Both): ");
            int choice = sc.nextInt();
            if (choice == 1) {
                lib1.addBook(allBooks.get(i));
            } else if (choice == 2) {
                lib2.addBook(allBooks.get(i));
            } else if (choice == 3) {
                lib1.addBook(allBooks.get(i));
                lib2.addBook(allBooks.get(i));
            }
        }
        lib1.showLibraryBooks();
        lib2.showLibraryBooks();
    }
}
class Library {
    private String name;
    private ArrayList<Book> books;
    public Library(String name) {
        this.name = name;
        books = new ArrayList<>();
    }
    public void addBook(Book book) {
        books.add(book);
    }
    public void showLibraryBooks() {
        System.out.println("Books in " + name + ":");
        for (Book book : books) {
            book.displayBook();
        }
        System.out.println();
    }
}