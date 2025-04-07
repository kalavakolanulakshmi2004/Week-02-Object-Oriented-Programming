import java.util.Scanner;
class Book {
    protected String title;
    protected int publicationYear;
    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }
    public void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Book details (Title, Publication Year): ");
        String title = scanner.nextLine();
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Author details (Name, Bio): ");
        String name = scanner.nextLine();
        String bio = scanner.nextLine();
        Book book = new Author(title, year, name, bio);
        System.out.println("\nBook Details:");
        book.displayInfo();
    }
}
class Author extends Book {
    private String name;
    private String bio;
    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Author Name: " + name);
        System.out.println("Bio: " + bio);
    }
}