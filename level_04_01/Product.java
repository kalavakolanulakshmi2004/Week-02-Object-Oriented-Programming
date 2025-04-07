import java.util.*;
class Product {
    private String name;
    private double price;
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of customers: ");
        int numCustomers = sc.nextInt();
        sc.nextLine();
        Customer1[] customers = new Customer1[numCustomers];
        for (int i = 0; i < numCustomers; i++) {
            System.out.print("Enter customer name: ");
            String name = sc.nextLine();
            customers[i] = new Customer1(name, 5);
        }
        System.out.print("Enter number of products in catalog: ");
        int numProducts = sc.nextInt();
        sc.nextLine();
        Product[] catalog = new Product[numProducts];
        for (int i = 0; i < numProducts; i++) {
            System.out.print("Enter product name: ");
            String pname = sc.nextLine();
            System.out.print("Enter price: ");
            double price = sc.nextDouble();
            sc.nextLine();
            catalog[i] = new Product(pname, price);
        }
        for (Customer1 customer : customers) {
            System.out.println("Creating order for " + customer.getName());
            System.out.print("Enter order ID: ");
            int orderId = sc.nextInt();
            System.out.print("How many products in this order? ");
            int pcount = sc.nextInt();
            sc.nextLine();
            Order order = new Order(orderId, pcount);
            for (int i = 0; i < pcount; i++) {
                System.out.print("Enter product name to add: ");
                String pname = sc.nextLine();
                for (int j = 0; j < catalog.length; j++) {
                    if (catalog[j].getName().equalsIgnoreCase(pname)) {
                        order.addProduct(catalog[j]);
                        break;
                    }
                }
            }
            customer.placeOrder(order);
        }
        System.out.println("\nCustomer Orders Summary");
        for (Customer1 customer : customers) {
            customer.showOrders();
        }
    }
}
class Order {
    private int orderId;
    private Product[] products;
    private int productCount;
    public Order(int orderId, int maxProducts) {
        this.orderId = orderId;
        this.products = new Product[maxProducts];
        this.productCount = 0;
    }
    public void addProduct(Product p) {
        if (productCount < products.length) {
            products[productCount++] = p;
        }
    }
    public void showOrderDetails() {
        System.out.println("Order ID: " + orderId);
        double total = 0;
        for (int i = 0; i < productCount; i++) {
            Product p = products[i];
            System.out.println("- " + p.getName() + ": $" + p.getPrice());
            total += p.getPrice();
        }
        System.out.println("Total: $" + total);
    }
    public int getOrderId() {
        return orderId;
    }
}
class Customer1 {
    private String name;
    private Order[] orders;
    private int orderCount;
    public Customer1(String name, int maxOrders) {
        this.name = name;
        this.orders = new Order[maxOrders];
        this.orderCount = 0;
    }
    public String getName() {
        return name;
    }
    public void placeOrder(Order order) {
        if (orderCount < orders.length) {
            orders[orderCount++] = order;
            System.out.println(name + " placed Order ID: " + order.getOrderId());
        }
    }
    public void showOrders() {
        System.out.println("Orders for " + name + ":");
        for (int i = 0; i < orderCount; i++) {
            orders[i].showOrderDetails();
            System.out.println();
        }
    }
}
