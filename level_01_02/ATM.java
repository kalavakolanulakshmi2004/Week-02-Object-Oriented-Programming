package level2;
import java.util.*;
public class ATM {
    private String accountHolder;
    private int accountNumber;
    private double balance;
    public ATM(String accountHolder, int accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
        System.out.println("Deposited: $" + amount);
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        }
        else {
            System.out.println("Insufficient balance.");
        }
    }
    public void displayBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: $" + balance);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Account Number: ");
        int accNum = sc.nextInt();
        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();
        ATM account = new ATM(name, accNum, balance);
        System.out.print("Enter Deposit Amount: ");
        account.deposit(sc.nextDouble());
        System.out.print("Enter Withdrawal Amount: ");
        account.withdraw(sc.nextDouble());
        account.displayBalance();
    }
}
