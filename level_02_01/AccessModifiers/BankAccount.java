package AccessModifiers;
import java.util.*;
public class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Amount should be positive.");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}
class SavingsAccount extends BankAccount{
    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }
    public void displaySavingsAccountDetails() {
        System.out.println("Savings Account Details:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
    }
}
class  BankAccountManagementSystem{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter Account Holder: ");
        String accountHolder = scanner.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance = scanner.nextDouble();
        SavingsAccount savingsAccount = new SavingsAccount(accountNumber, accountHolder, balance);
        System.out.println("\nAccount Details:");
        savingsAccount.displayAccountDetails();
        System.out.print("\nEnter deposit amount: ");
        double depositAmount = scanner.nextDouble();
        savingsAccount.deposit(depositAmount);
        System.out.print("\nEnter withdrawal amount: ");
        double withdrawalAmount = scanner.nextDouble();
        savingsAccount.withdraw(withdrawalAmount);
        System.out.println("\nUpdated Account Details:");
        savingsAccount.displayAccountDetails();
        System.out.println(" ");
        savingsAccount.displaySavingsAccountDetails();
    }
}
