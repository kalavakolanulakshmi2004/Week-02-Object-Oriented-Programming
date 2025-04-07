import java.util.Scanner;
class Order {
    protected int orderId;
    protected String orderDate;
    public Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }
    public String getOrderStatus() {
        return "Order placed on " + orderDate;
    }
    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Status: " + getOrderStatus());
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Order ID: ");
        int orderId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Order Date: ");
        String orderDate = scanner.nextLine();
        System.out.print("Enter Tracking Number: ");
        String trackingNumber = scanner.nextLine();
        System.out.print("Enter Delivery Date: ");
        String deliveryDate = scanner.nextLine();
        Order order = new DeliveredOrder(orderId, orderDate, trackingNumber, deliveryDate);
        System.out.println("\nOrder Details:");
        order.displayOrderDetails();
    }
}
class ShippedOrder extends Order {
    protected String trackingNumber;
    public ShippedOrder(int orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }
    @Override
    public String getOrderStatus() {
        return "Order shipped with Tracking Number: " + trackingNumber;
    }
    @Override
    public void displayOrderDetails() {
        super.displayOrderDetails();
        System.out.println("Tracking Number: " + trackingNumber);
    }
}
class DeliveredOrder extends ShippedOrder {
    private String deliveryDate;
    public DeliveredOrder(int orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }
    @Override
    public String getOrderStatus() {
        return "Order delivered on " + deliveryDate;
    }
    @Override
    public void displayOrderDetails() {
        super.displayOrderDetails();
        System.out.println("Delivery Date: " + deliveryDate);
    }
}