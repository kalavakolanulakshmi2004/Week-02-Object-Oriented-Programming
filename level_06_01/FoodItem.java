import java.util.Scanner;
interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}
abstract class FoodItem implements Discountable {
    private String itemName;
    private double price;
    private int quantity;
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public abstract double calculateTotalPrice();
    public void getItemDetails() {
        System.out.println("Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity + ", Total Price: " + calculateTotalPrice() + ", Discount: " + applyDiscount());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FoodItem[] items = new FoodItem[2];
        VegItem v = new VegItem();
        System.out.println("Enter Veg Item Details:");
        System.out.print("Name: ");
        v.setItemName(sc.nextLine());
        System.out.print("Price: ");
        v.setPrice(sc.nextDouble());
        System.out.print("Quantity: ");
        v.setQuantity(sc.nextInt());
        System.out.print("Discount Percentage: ");
        v.setDiscountPercent(sc.nextDouble());
        sc.nextLine();
        items[0] = v;
        NonVegItem n = new NonVegItem();
        System.out.println("\nEnter Non-Veg Item Details:");
        System.out.print("Name: ");
        n.setItemName(sc.nextLine());
        System.out.print("Price: ");
        n.setPrice(sc.nextDouble());
        System.out.print("Quantity: ");
        n.setQuantity(sc.nextInt());
        System.out.print("Extra Charge per Item: ");
        n.setExtraCharge(sc.nextDouble());
        System.out.print("Discount Percentage: ");
        n.setDiscountPercent(sc.nextDouble());
        sc.nextLine();
        items[1] = n;
        System.out.println("\nOrder Summary:");
        for (FoodItem item : items) {
            item.getItemDetails();
        }
    }
}
class VegItem extends FoodItem {
    private double discountPercent;
    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }
    public double applyDiscount() {
        return (getPrice() * getQuantity()) * discountPercent / 100;
    }
    public String getDiscountDetails() {
        return "Veg Discount: " + discountPercent + "%";
    }
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) - applyDiscount();
    }
}
class NonVegItem extends FoodItem {
    private double extraCharge;
    private double discountPercent;
    public void setExtraCharge(double extraCharge) {
        this.extraCharge = extraCharge;
    }
    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }
    public double applyDiscount() {
        return (getPrice() * getQuantity() + extraCharge * getQuantity()) * discountPercent / 100;
    }
    public String getDiscountDetails() {
        return "Non-Veg Discount: " + discountPercent + "%";
    }
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity() + extraCharge * getQuantity()) - applyDiscount();
    }
}