import java.util.Scanner;
interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}
abstract class LibraryItem implements Reservable {
    private int itemId;
    private String title;
    private String author;
    protected String borrower;
    protected boolean reserved;
    protected int loanDuration;
    public int getItemId() {
        return itemId;
    }
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setLoanDuration(int loanDuration) {
        this.loanDuration = loanDuration;
    }
    public void reserveItem(String borrowerName) {
        this.borrower = borrowerName;
        this.reserved = true;
    }
    public boolean checkAvailability() {
        return !reserved;
    }
    public String getItemDetails() {
        return "ID: " + itemId + ", Title: " + title + ", Author: " + author;
    }
    public abstract int getLoanDuration();
    public void displayInfo() {
        System.out.println(getItemDetails() + ", Loan Duration: " + getLoanDuration() + " days, Available: " + checkAvailability());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryItem[] items = new LibraryItem[3];
        Book b = new Book();
        System.out.println("Enter details for Book:");
        System.out.print("Item ID: ");
        b.setItemId(sc.nextInt());
        sc.nextLine();
        System.out.print("Title: ");
        b.setTitle(sc.nextLine());
        System.out.print("Author: ");
        b.setAuthor(sc.nextLine());
        System.out.print("Loan Duration (days): ");
        b.setLoanDuration(sc.nextInt());
        sc.nextLine();
        System.out.print("Reserve Book? (yes/no): ");
        if(sc.nextLine().equalsIgnoreCase("yes")) {
            System.out.print("Enter borrower name: ");
            b.reserveItem(sc.nextLine());
        }
        items[0] = b;
        Magazine m = new Magazine();
        System.out.println("\nEnter details for Magazine:");
        System.out.print("Item ID: ");
        m.setItemId(sc.nextInt());
        sc.nextLine();
        System.out.print("Title: ");
        m.setTitle(sc.nextLine());
        System.out.print("Author: ");
        m.setAuthor(sc.nextLine());
        System.out.print("Loan Duration (days): ");
        m.setLoanDuration(sc.nextInt());
        sc.nextLine();
        System.out.print("Reserve Magazine? (yes/no): ");
        if(sc.nextLine().equalsIgnoreCase("yes")) {
            System.out.print("Enter borrower name: ");
            m.reserveItem(sc.nextLine());
        }
        items[1] = m;
        DVD d = new DVD();
        System.out.println("\nEnter details for DVD:");
        System.out.print("Item ID: ");
        d.setItemId(sc.nextInt());
        sc.nextLine();
        System.out.print("Title: ");
        d.setTitle(sc.nextLine());
        System.out.print("Author: ");
        d.setAuthor(sc.nextLine());
        System.out.print("Loan Duration (days): ");
        d.setLoanDuration(sc.nextInt());
        sc.nextLine();
        System.out.print("Reserve DVD? (yes/no): ");
        if(sc.nextLine().equalsIgnoreCase("yes")) {
            System.out.print("Enter borrower name: ");
            d.reserveItem(sc.nextLine());
        }
        items[2] = d;
        System.out.println("\nLibrary Items:");
        for(LibraryItem item : items) {
            item.displayInfo();
        }
    }
}
class Book extends LibraryItem {
    public int getLoanDuration() {
        return loanDuration;
    }
}
class Magazine extends LibraryItem {
    public int getLoanDuration() {
        return loanDuration;
    }
}
class DVD extends LibraryItem {
    public int getLoanDuration() {
        return loanDuration;
    }
}