import java.util.*;
class Bank {
    private String name;
    public Bank(String name) {
        this.name = name;
    }
    public void openAccount(Customer customer, double balance) {
        customer.setBank(this);
        customer.setBalance(balance);
        System.out.println("Account opened for " + customer.getName() + " in " + name);
    }
    public String getBankName() {
        return name;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank("City Bank");
        System.out.print("Enter number of customers: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter customer name: ");
            String name = sc.nextLine();
            System.out.print("Enter initial balance: ");
            double balance = sc.nextDouble();
            sc.nextLine();
            Customer customer = new Customer(name);
            bank.openAccount(customer, balance);
            customer.viewBalance();
            System.out.println();
        }
    }
}
class Customer {
    private String name;
    private double balance;
    private Bank bank;
    public Customer(String name) {
        this.name = name;
    }
    public void setBank(Bank bank) {
        this.bank = bank;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void viewBalance() {
        System.out.println("Customer: " + name);
        System.out.println("Bank: " + bank.getBankName());
        System.out.println("Balance: $" + balance);
    }
    public String getName() {
        return name;
    }
}