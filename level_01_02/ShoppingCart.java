package level2;
import java.util.Scanner;
public class ShoppingCart {
    public static class CartItem {
        String itemName;
        double price;
        int quantity;
        public CartItem(String itemName, double price, int quantity) {
            this.itemName = itemName;
            this.price = price;
            this.quantity = quantity;
        }
    }
    private CartItem[] cart = new CartItem[10];
    private int itemCount = 0;
    public void addItem(String itemName, double price, int quantity) {
        if (itemCount < cart.length) {
            cart[itemCount++] = new CartItem(itemName, price, quantity);
            System.out.println(itemName + " added to cart.");
        }
        else {
            System.out.println("Cart is full!");
        }
    }
    public void removeItem(String itemName) {
        for (int i = 0; i < itemCount; i++) {
            if (cart[i].itemName.equalsIgnoreCase(itemName)) {
                for (int j = i; j < itemCount - 1; j++) {
                    cart[j] = cart[j + 1];
                }
                cart[--itemCount] = null;
                System.out.println(itemName + " removed from cart.");
                return;
            }
        }
        System.out.println("Item not found!");
    }
    public void displayTotalCost() {
        double total = 0;
        System.out.println("Shopping Cart:");
        for (int i = 0; i < itemCount; i++) {
            System.out.println(cart[i].itemName + " - " + cart[i].quantity + " x $" + cart[i].price);
            total += cart[i].price * cart[i].quantity;
        }
        System.out.println("Total Cost: $" + total);
    }
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Item  2. Remove Item  3. Display Total  4. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                System.out.print("Enter item name: ");
                String name = sc.nextLine();
                System.out.print("Enter price: ");
                double price = sc.nextDouble();
                System.out.print("Enter quantity: ");
                int qty = sc.nextInt();
                cart.addItem(name, price, qty);
            } else if (choice == 2) {
                System.out.print("Enter item name to remove: ");
                String name = sc.nextLine();
                cart.removeItem(name);
            } else if (choice == 3) {
                cart.displayTotalCost();
            } else {
                break;
            }
        }
    }
}
