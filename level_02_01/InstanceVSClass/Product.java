package InstanceVSClass;
import java.util.*;
public class Product {
    String productName;
    double price;
    static int totalProducts = 0;
    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }
    void displayProductDetails() {
        System.out.println("Product Name: " + productName + ", Price: " + price);
    }
    static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine();
        Product[] products = new Product[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter product name:");
            String name = sc.nextLine();
            System.out.println("Enter product price:");
            double price = sc.nextDouble();
            sc.nextLine();
            products[i] = new Product(name, price);
        }
        System.out.println("\nProduct Details:");
        for (Product p : products) {
            p.displayProductDetails();
        }
        Product.displayTotalProducts();
    }
}
