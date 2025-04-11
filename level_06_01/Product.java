import java.util.Scanner;
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}
abstract class Product implements Taxable {
    private int productId;
    private String name;
    private double price;
    protected double discountPercent;
    protected double taxPercent;
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }
    public void setTaxPercent(double taxPercent) {
        this.taxPercent = taxPercent;
    }
    public abstract double calculateDiscount();
    public void displayFinalPrice() {
        double discount = calculateDiscount();
        double tax = calculateTax();
        double finalPrice = price + tax - discount;
        System.out.println("ID: " + productId + " \nName: " + name
                + " \nPrice: " + price
                + " \nDiscount: " + discount
                + " \nTax: " + tax
                + " \nFinal Price: " + finalPrice);
        System.out.println(" ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product[] products = new Product[3];
        Electronics e = new Electronics();
        System.out.println("Enter details for Electronics:");
        System.out.print("Product ID: ");
        e.setProductId(sc.nextInt());
        sc.nextLine();
        System.out.print("Name: ");
        e.setName(sc.nextLine());
        System.out.print("Price: ");
        e.setPrice(sc.nextDouble());
        System.out.print("Discount Percentage: ");
        e.setDiscountPercent(sc.nextDouble());
        System.out.print("Tax Percentage: ");
        e.setTaxPercent(sc.nextDouble());
        sc.nextLine();
        products[0] = e;
        Clothing c = new Clothing();
        System.out.println("\nEnter details for Clothing:");
        System.out.print("Product ID: ");
        c.setProductId(sc.nextInt());
        sc.nextLine();
        System.out.print("Name: ");
        c.setName(sc.nextLine());
        System.out.print("Price: ");
        c.setPrice(sc.nextDouble());
        System.out.print("Discount Percentage: ");
        c.setDiscountPercent(sc.nextDouble());
        System.out.print("Tax Percentage: ");
        c.setTaxPercent(sc.nextDouble());
        sc.nextLine();
        products[1] = c;
        Groceries g = new Groceries();
        System.out.println("\nEnter details for Groceries:");
        System.out.print("Product ID: ");
        g.setProductId(sc.nextInt());
        sc.nextLine();
        System.out.print("Name: ");
        g.setName(sc.nextLine());
        System.out.print("Price: ");
        g.setPrice(sc.nextDouble());
        System.out.print("Discount Percentage: ");
        g.setDiscountPercent(sc.nextDouble());
        System.out.print("Tax Percentage: ");
        g.setTaxPercent(sc.nextDouble());
        sc.nextLine();
        products[2] = g;
        System.out.println("\nProduct Final Price:");
        for (Product p : products) {
            p.displayFinalPrice();
        }
    }
}
class Electronics extends Product {
    public double calculateDiscount() {
        return getPrice() * discountPercent / 100;
    }
    public double calculateTax() {
        return getPrice() * taxPercent / 100;
    }
    public String getTaxDetails() {
        return "Electronics Tax: " + taxPercent + "%";
    }
}
class Clothing extends Product {
    public double calculateDiscount() {
        return getPrice() * discountPercent / 100;
    }
    public double calculateTax() {
        return getPrice() * taxPercent / 100;
    }
    public String getTaxDetails() {
        return "Clothing Tax: " + taxPercent + "%";
    }
}
class Groceries extends Product {
    public double calculateDiscount() {
        return getPrice() * discountPercent / 100;
    }
    public double calculateTax() {
        return getPrice() * taxPercent / 100;
    }
    public String getTaxDetails() {
        return "Groceries Tax: " + taxPercent + "%";
    }
}